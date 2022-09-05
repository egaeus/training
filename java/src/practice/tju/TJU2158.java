package practice.tju; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict R.E.
 * @problemId 2158
 * @problemName Table
 * @judge http://acm.tju.edu.cn/
 * @category characters
 * @level easy
 * @date 03/08/2012
 **/
import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class TJU2158{
	static char vLine=179;
	static char vInterRight=180;
	static char bRightTop=191;
	static char bLeftBottom=192;
	static char hInterBottom=193;
	static char hInterTop=194;
	static char vInterLeft=195;
	static char hLine=196;
	static char plus=197;
	static char bRightBottom=217;
	static char bLeftTop=218;
//	static char vLine='|';
//	static char vInterRight='{';
//	static char bRightTop=']';
//	static char bLeftBottom='(';
//	static char hInterBottom='=';
//	static char hInterTop='"';
//	static char vInterLeft='}';
//	static char hLine='-';
//	static char plus='+';
//	static char bRightBottom=')';
//	static char bLeftTop='[';
	static void plot(StringBuilder sb,ArrayList<String>[][] table) {
		int rows=table.length,cols=table[0].length,columnSize[]=new int[cols],rowSize[]=new int[rows],totalRows=0,totalCols=0;
		for(int i=0;i<cols;i++) 
			for(int j=0;j<rows;j++){
				for(String a:table[j][i])
					columnSize[i]=max(columnSize[i],a.length()+2);
				rowSize[j]=max(rowSize[j],table[j][i].size());
			}
		for(int i=0;i<rows;i++)totalRows+=rowSize[i];
		for(int i=0;i<cols;i++)totalCols+=columnSize[i];
		char[][] mat=new char[totalRows+table.length+1][totalCols+table[0].length+1];
		for(char[] a:mat)Arrays.fill(a,' ');
		{
			int j=0;
			mat[0][j++]=bLeftTop;
			for(int C=0;C<table[0].length;C++){
				for(int h=0;h<columnSize[C];j++,h++)
					mat[0][j]=hLine;
				mat[0][j++]=hInterTop;
			}
			mat[0][mat[0].length-1]=bRightTop;
		}
		for(int i=1,R=0;R<table.length;R++,i++) {
			for(int I=0,j=0;I<rowSize[R];I++,i++,j=0){
				mat[i][j++]=vLine;
				for(int C=0;C<table[R].length;C++){
					char[] str=llenarCeros(columnSize[C]-2,(I<table[R][C].size()?table[R][C].get(I):"")).toCharArray();
					j++;
					for(int h=0;h<str.length;j++,h++)
						mat[i][j]=str[h];
					j++;mat[i][j++]=vLine;
				}
			}
			int j=0;
			mat[i][j++]=vInterLeft;
			for(int C=0;C<table[R].length;C++){
				for(int h=0;h<columnSize[C];j++,h++)
					mat[i][j]=hLine;
				mat[i][j++]=plus;
			}
			mat[i][mat[i].length-1]=vInterRight;
		}
		{
			int j=0;
			mat[mat.length-1][j++]=bLeftBottom;
			for(int C=0;C<table[0].length;C++){
				for(int h=0;h<columnSize[C];j++,h++)
					mat[mat.length-1][j]=hLine;
				mat[mat.length-1][j++]=hInterBottom;
			}
			mat[mat.length-1][mat[0].length-1]=bRightBottom;
		}
		for(char[] a:mat){
			sb.append(a);
			sb.append("\n");
		}
	}
	static String llenarCeros(int size,String s){
		for(;s.length()<size;)s+=" ";
		return s;
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		ArrayList<ArrayList<ArrayList<String>>> table=new ArrayList<ArrayList<ArrayList<String>>>();
		for(String ln;(ln=in.readLine()).charAt(0)!=bLeftBottom;){
			System.out.println((int)ln.charAt(0));
			if(ln.charAt(0)==vLine){
				int a=0;
				for(;ln.contains(vLine+""+vLine);ln=ln.replace(vLine+""+vLine,vLine+" "+vLine));
				StringTokenizer st=new StringTokenizer(ln,vLine+"");
				for(;st.hasMoreTokens();a++){
					ArrayList<String> arr=a<table.get(table.size()-1).size()?table.get(table.size()-1).get(a):null;
					if(arr==null)table.get(table.size()-1).add(arr=new ArrayList<String>());
					arr.add(st.nextToken().trim());
				}
			}
			else table.add(new ArrayList<ArrayList<String>>());
		}
		ArrayList<String>[][] mat=new ArrayList[table.size()][table.get(0).size()];
		for(int i=0;i<mat.length;i++)
			for(int j=0;j<mat[i].length;j++)
				mat[i][j]=table.get(i).get(j);
		plot(sb,mat);
		System.out.print(new String(sb));
	}
}
