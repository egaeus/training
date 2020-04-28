package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 5784
 * @problemName The Banzhaf Buzz-Off
 * @judge http://livearchive.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 30/05/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
public class LAUVa5784{
	public static void main(String args[]) throws Throwable{
		BigInteger[][] binomial=new BigInteger[61][61];int caso=1;
		for(int i=0;i<binomial.length;i++){binomial[i][0]=BigInteger.ONE;binomial[i][i]=BigInteger.ONE;}
		for(int i=1;i<binomial.length;i++)for(int j=1;j<i;j++)binomial[i][j]=binomial[i-1][j-1].add(binomial[i-1][j]);
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;caso++){
			int n=parseInt(st.nextToken()),q=parseInt(st.nextToken());
			if(n==0&&q==0)break;
			int[][] arr=new int[n][];
			st=new StringTokenizer(in.readLine());
			for(int i=0;i<n;i++)arr[i]=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken())};
			long[] dp=new long[61];
			sb.append("Case "+caso+":");
			for(int i=0;i<n;i++){
				Arrays.fill(dp,0);dp[0]=1;
				for(int j=0;j<n;j++)
					if(i!=j)
						for(int h=0;h<arr[j][1];h++)
							for(int k=dp.length-arr[j][0]-1;k>=0;k--)
								dp[k+arr[j][0]]+=dp[k];
				BigInteger sol=BigInteger.ZERO;
				for(int j=0;j<arr[i][1];j++)
					for(int k=0;k<61;k++)
						if(dp[k]>0&&k+(j+1)*arr[i][0]>=q&&k+j*arr[i][0]<q)
							sol=sol.add(BigInteger.valueOf(dp[k]).multiply(binomial[arr[i][1]-1][arr[i][1]-j-1]));
				sb.append(" "+sol);
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
