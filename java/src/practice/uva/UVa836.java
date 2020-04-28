package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accpeted
 * @problemId 836
 * @problemName Largest Submatrix
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 09/07/2012
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa836{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int t=0,T=parseInt(in.readLine().trim());t<T;t++){
			if(t>0)sb.append("\n");
			in.readLine();
			char[][] mat=new char[25][];
			int N=(mat[0]=in.readLine().trim().toCharArray()).length;
			for(int i=1;i<N;i++)mat[i]=in.readLine().trim().toCharArray();
			int[][] dp=new int[N][N];
			dp[0][0]=mat[0][0]-'0';
			for(int i=1;i<N;i++){
				dp[i][0]=dp[i-1][0]+(mat[i][0]-'0');
				dp[0][i]=dp[0][i-1]+(mat[0][i]-'0');
			}
			for(int i=1;i<N;i++)
				for(int j=1;j<N;j++)
					dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+(mat[i][j]-'0');
			int max=0;
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					for(int h=i;h<N;h++)
						for(int k=j;k<N;k++)
							if(dp[h][k]-(i>0?dp[i-1][k]:0)-(j>0?dp[h][j-1]:0)+(i>0&&j>0?dp[i-1][j-1]:0)==(k-j+1)*(h-i+1))
								max=max(max,(k-j+1)*(h-i+1));
			sb.append(max+"\n");				
		}
		System.out.print(new String(sb));
	}
}
