package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 694
 * @problemName The Collatz Sequence
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 13/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa694 {
	static long f(long A, long L){
		long r=0;
		for(;A!=1&&A<=L;A=(A%2==0?A/2:(3*A+1)),r++);if(A==1)r++;
		return r;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));int c=1;
		StringBuilder sb=new StringBuilder();
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			long A=parseInt(st.nextToken()),L=parseInt(st.nextToken());
			if(A<0&&L<0)break;
			sb.append("Case "+c+++": A = "+A+", limit = "+L+", number of terms = "+f(A,L)+"\n");
		}
		System.out.print(new String(sb));
	}
}