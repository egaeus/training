package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10042
 * @problemName Smith Numbers
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 20/12/2010
 **/
import static java.lang.Long.parseLong;
import static java.lang.Math.max;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10042 {
	static long sumDigits(long n){
		long res = 0;
		for(;n > 0; n/=10)res+=n%10;
		return res;
	}
	static boolean function(long n){
		long numDigits = sumDigits(n);
		long sol = 0, m = n;
		for(long i = 2; i < sqrt(n) + 1; i++)
			if(m%i==0){
				sol+=sumDigits(i);
				m/=(i--);
				if(sol>numDigits)break;
			}
		if(m!=n && m!=1)sol+=sumDigits(m);
		return numDigits == sol;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(long c = 0, C = parseLong(in.readLine().trim()); c < C; c++){
			long N = parseLong(in.readLine().trim());
			for (long i = max(N + 1, 3); ; i++) 
				if(function(i)){
					System.out.println(i);
					break;
				}
		}
	}
}
