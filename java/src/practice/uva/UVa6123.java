package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict R.E.
 * @problemId 6123
 * @problemName Flash Mob
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Jul 9, 2013
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa6123 {
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
	public static void main(String args[]) throws Throwable {
		StringBuilder sb=new StringBuilder();
		Escaner sc=new Escaner();
		for (int N,c=1;(N=sc.nextInt())!=0;c++) {
			int[] xs=new int[N];
			int[] ys=new int[N];
			for(int i=0;i<N;i++){
				xs[i]=sc.nextInt();
				ys[i]=sc.nextInt();
			}
			Arrays.sort(xs);
			Arrays.sort(ys);
			int x=N%2==1?xs[N/2]:(xs[N/2]+xs[N/2-1])/2,y=N%2==1?ys[N/2]:(ys[N/2]+ys[N/2-1])/2,s=0;
			for(int i=0;i<N;i++)
				s+=abs(xs[i]-x)+abs(ys[i]-y);
			sb.append("Case ").append(c).append(": (").append(x).append(",").append(y).append(") ").append(s).append("\n");
		}
		System.out.print(new String(sb));
	}
}
