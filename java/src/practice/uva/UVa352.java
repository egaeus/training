package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 352
 * @problemName The Seasonal War
 * @judge http://uva.onlinejudge.org/
 * @category floodfill
 * @level easy
 * @date 27/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa352 {
	static int floodFill(char[][] tab){
		int n,res=0;boolean[][] v=new boolean[n=tab.length][n];
		for(int i=0;i<n;i++)for(int j=0;j<n;j++)if(!v[i][j]&&tab[i][j]=='1'){res++;floodFill(tab,v,i,j,n);};
		return res;
	}
	static int[][] cola;
	static void floodFill(char[][] tab,boolean[][] v,int i,int j,int n){
		int p=0,c=0;
		cola[c][0]=i;cola[c++][1]=j;v[i][j]=true;
		for(;p<c;){
			i=cola[p][0];j=cola[p++][1];
			for(int H=-1;H<2;H++)
				for(int K=-1;K<2;K++)
					if(i+H>=0&&i+H<n&&j+K>=0&&j+K<n&&tab[i+H][j+K]=='1'&&!v[i+H][j+K]){
						v[i+H][j+K]=true;
						cola[c][0]=i+H;cola[c++][1]=j+K;
					}
		}
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int caso=1;
		cola=new int[26*26][2];
		for (String ln;(ln=in.readLine())!=null;caso++) {
			int N=parseInt(ln.trim());
			char[][] tab=new char[N][];
			for(int i=0;i<N;i++)tab[i]=in.readLine().trim().toCharArray();
			sb.append("Image number "+caso+" contains "+floodFill(tab)+" war eagles.\n");
		}
		System.out.print(new String(sb));
	}
}
