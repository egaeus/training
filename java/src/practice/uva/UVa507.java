package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 507
 * @problemName Jill Rides Again
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date Jun 6, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa507 {
	static class Escaner {
		BufferedReader in;
		StringTokenizer st;
		public Escaner() {
			 in = new BufferedReader(new InputStreamReader(System.in));
			 st=new StringTokenizer("");
		}
		public int nextInt() throws Throwable {
			if(st.hasMoreTokens())return parseInt(st.nextToken());
			st=new StringTokenizer(in.readLine());
			return nextInt();
		}
	}
	static long[] maxSumSubArr(long[] nums) {
		int N=nums.length;
		long[] creciente=new long[N+2];
		long[] decreciente=new long[N+2];
		long[] mins=new long[N+2];
		mins[N+1]=creciente[0]=decreciente[N+1]=0;
		creciente[N+1]=decreciente[0]=Long.MAX_VALUE;
		long sum=0;
		for(int i=0;i<N;i++) {
			sum+=nums[i];
			creciente[i+1]=creciente[i]+nums[i];
			decreciente[N-i]=decreciente[N+1-i]+nums[N-1-i];
			mins[N-i]=Math.min(mins[N+1-i],decreciente[N-i]);
		}
		long max=Long.MIN_VALUE;
		int I=-1,J=-1;
		for(int i=0;i<N+1;i++) 
			if(sum-(creciente[i]+mins[i+1])>max) {
				max=sum-(creciente[i]+mins[i+1]);
				I=i;
			}
		for(int i=N+1;i>=0&&J==-1;i--)
			if(decreciente[i]==mins[I+1])
				J=i;
		return new long[]{max,I,J-2};
	}
	public static void main(String args[]) throws Throwable {
		Escaner sc=new Escaner();
		StringBuilder sb = new StringBuilder();
		for (int t=0,T=sc.nextInt();t++<T;) {
			int N=sc.nextInt();
			long[] nums=new long[N-1];
			for(int i=0;i<N-1;i++) 
				nums[i]=sc.nextInt();
			long[] p=maxSumSubArr(nums);
			if(p[0]>0)sb.append("The nicest part of route ").append(t).append(" is between stops ").append(p[1]+1).append(" and ").append(p[2]+2);
			else sb.append("Route ").append(t).append(" has no nice parts");
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
