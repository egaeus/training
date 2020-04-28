package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10271
 * @problemName Chopsticks
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date Jun 19, 2013
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa10271 {
	static int K,N;
	static long[] arr;
	static long[][] mem;
	static long f(int k,int n) {
		if(k==0)return 0;
		if(n==N)return MAX_VALUE;
		if(N-n<3*k)return MAX_VALUE;
		if(mem[k][n]>-1)return mem[k][n];
		return mem[k][n]=min(f(k,n+1),f(k-1,n+2)+(arr[n+1]-arr[n])*(arr[n+1]-arr[n]));
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int T=parseInt(in.readLine().trim()),t=0;t++<T;) {
			StringTokenizer st=new StringTokenizer(in.readLine()); 
			K=parseInt(st.nextToken())+8;
			N=parseInt(st.nextToken());
			arr=new long[N];
			mem=new long[K+1][N];
			for(long[] a:mem)Arrays.fill(a,-1);
			st=new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++)arr[i]=parseInt(st.nextToken());
			sb.append(f(K,0)).append("\n");
		}
		System.out.print(new String(sb));
	}
}
