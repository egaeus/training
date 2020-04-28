package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2066
 * @problemName Instruens Fabulam
 * @judge http://livearchive.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 01/08/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class LAUVa2066 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln=in.readLine();ln.charAt(0)!='*';){
			char[] alT=ln.toCharArray();int cols=alT.length,width[]=new int[cols];
			ArrayList<char[][]> arr=new ArrayList<char[][]>();
			for(;!(ln=in.readLine()).contains("<")&&!ln.contains(">")&&!ln.contains("=")&&!ln.contains("*");){
				char[][] nuevo=new char[cols][];
				StringTokenizer st=new StringTokenizer(ln,"&");
				for(int i=0;i<cols;i++)width[i]=Math.max((nuevo[i]=st.nextToken().toCharArray()).length,width[i]);
				arr.add(nuevo);
			}
			int n=arr.size();
			int c=cols+1+2*cols;
			for(int i=0;i<cols;i++)c+=width[i];
			char[][] res=new char[n+3][c];
			for(char[] r:res)Arrays.fill(r, ' ');
			for(int i=0;i<c;i++)res[0][i]=res[2][i]=res[n+2][i]='-';
			for(int i=0,s=0;i<=cols;s+=width[i%cols]+3,i++)for(int j=1;j<n+2;j++)res[j][s]=j==2&&s!=0&&s!=c-1?'+':'|';
			res[0][0]=res[n+2][0]=res[n+2][c-1]=res[0][c-1]='@';
			for(int i=0,s=2;i<cols;s+=width[i]+3,i++)
				for(int j=0,h=1;j<n;h+=j==0?2:1,j++)
					for(int k=0,l=alT[i]=='<'?s:(alT[i]=='>'?s+width[i]-arr.get(j)[i].length:(s+(width[i]-arr.get(j)[i].length)/2));k<arr.get(j)[i].length;k++,l++)
						res[h][l]=arr.get(j)[i][k];						
			for(char[] r:res)sb.append(new String(r)+"\n");
		}
		System.out.print(new String(sb));
	}
}
