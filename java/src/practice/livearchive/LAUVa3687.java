package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 3687
 * @problemName Football Foundation (FOFO)
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 24/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa3687 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken()),I=parseInt(st.nextToken())-1;
			if(N==0&&M==0&&I==-1)break;
			char[][] mat=new char[N][];
			for(int i=0;i<N;i++)mat[i]=in.readLine().trim().toCharArray();
			int sol[][]=new int[N][M];
			int i=0,j=I,c=1;
			for(;i>=0&&i<N&&j>=0&&j<M&&sol[i][j]==0;c++){
				sol[i][j]=c;
				if(mat[i][j]=='S'||mat[i][j]=='N')i+=(mat[i][j]=='S'?1:(mat[i][j]=='N'?-1:0));
				else j+=(mat[i][j]=='E'?1:(mat[i][j]=='W'?-1:0));
			}
			if(i<0||i>=N||j<0||j>=M)System.out.println(c-1+" step(s) to exit");
			else System.out.println(sol[i][j]-1+" step(s) before a loop of "+(c-sol[i][j])+" step(s)");
		}
	}
}
