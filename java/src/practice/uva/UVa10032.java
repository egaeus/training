package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10032
 * @problemName Tug of War
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 29/03/2012
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.ceil;
import static java.lang.Math.floor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10032{
	static int[] arr;
	static int f(int n,int sum){
		long h=(1L<<(n/2+2))-1;
		long[] dp=new long[sum+1];
		dp[0]=1;
		for(int i=0;i<arr.length;i++)
			for(int k=sum;k>=0;k--)
				if(dp[k]>0)dp[k+arr[i]]=(dp[k+arr[i]]|(dp[k]<<1))&h;
		int m1=(int)ceil(n/2.),m2=(int)floor(n/2.);
		for(int i=sum/2;i>=0;i--)if(((dp[i]&(1L<<m1))>0)||((dp[i]&(1L<<m2))>0))return i;
		return -1;
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int T=parseInt(in.readLine().trim()),t=0;t<T;t++){
			in.readLine();
			int N=parseInt(in.readLine().trim()),sum=0;
			arr=new int[N];
			for(int i=0;i<N;i++)sum+=(arr[i]=parseInt(in.readLine().trim()));
			int S=f(N,sum);
			sb.append(S+" "+(sum-S)+"\n"+(t<T-1?"\n":""));
		}
		System.out.print(new String(sb));
	}
}

