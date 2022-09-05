package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 5733
 * @problemName Iterated Difference
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Aug 21, 2013
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa5733 {
	static class Escaner {
		BufferedReader in;
		StringTokenizer st;
		Escaner() {
			in = new BufferedReader(new InputStreamReader(System.in));
			st=new StringTokenizer("");
		}
		int nextInt() throws Throwable {
			if(st.hasMoreTokens())return parseInt(st.nextToken());
			String ln=in.readLine();
			if(ln==null)return 0;
			st=new StringTokenizer(ln);
			return nextInt();
		}
	}
	static boolean isEqual(int[] arr) {
		for(int i=1;i<arr.length;i++)
			if(arr[i]!=arr[i-1])
				return false;
		return true;
	}
	public static void main(String args[]) throws Throwable {
		Escaner sc=new Escaner();
		StringBuilder sb = new StringBuilder();
		for (int N,c=1;(N=sc.nextInt())!=0;c++) {
			int arr[]=new int[N],first;
			for(int i=0;i<N;i++)
				arr[i]=sc.nextInt();
			int sol=0;
			for(;sol<=1001;sol++) {
				if(isEqual(arr))break;
				first=arr[0];
				for(int i=0;i<N-1;i++)
					arr[i]=abs(arr[i]-arr[i+1]);
				arr[N-1]=abs(arr[N-1]-first);
			}
			sb.append("Case ").append(c).append(": ");
			if(sol<=1000)sb.append(sol).append(" iterations");
			else sb.append("not attained");
			sb.append("\n");
			if(sb.length()>1000000) {
				System.out.print(new String(sb));
				sb=new StringBuilder();
			}
		}
		System.out.print(new String(sb));
	}
}
