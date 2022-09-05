package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 371
 * @problemName Ackermann Functions
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 20/12/2010
 **/
import static java.lang.Long.max;
import static java.lang.Long.min;
import static java.lang.Long.parseLong;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa371 {
	static long mem[];
	static long function(long n){
		if(n == 1)return 0;
		if(n < mem.length && mem[(int)n] > 0)return mem[(int)n];
		if(n%2==0)return n < mem.length?(mem[(int)n] = function(n/2) + 1):(function(n/2) + 1);
		return n < mem.length?(mem[(int)n] = function(3*n+1) + 1):(function(3*n+1) + 1);
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		mem = new long[1000000];
		for(String ln; (ln = in.readLine().trim()) != null;){
			StringTokenizer st = new StringTokenizer(ln);
			long A = parseLong(st.nextToken()), B = parseLong(st.nextToken());
			if(A==0&&B==0)break;
			long max = 0, val = A;
			for (long i = min(A,B); i <= max(A,B); i++) {
				if(function(i) > max)val = i;
				max = max(function(i), max);
			}
			if(min(A,B) <= 1){
				if(max <= 3)val = 1;
				max = max(3, max);
			}
			System.out.println("Between " + min(A,B) + " and " + max(A,B) + ", " + val + " generates the longest sequence of " + max + " values.");
		}
	}
}
