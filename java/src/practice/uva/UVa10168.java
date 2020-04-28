package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10168
 * @probleName Summation of Four Primes
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 2008
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10168 {
	public static void main(String[] args) throws Throwable {
		boolean[] primos = new boolean[10000000];
		primos[0] = primos[1] = true;
		for (int i = 0; i < primos.length; i++)
			if (!primos[i]) 
				for (int j = i + i; j < primos.length; j += i)
					primos[j] = true;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String N; (N = in.readLine()) != null; ) {
			int n = parseInt(N.trim());
			if(n <= 7)System.out.println("Impossible.");
			else{
				int[] res = new int[4];
				if(n%2==0){
					res[0] = res[1] = 2;
					n -=4;
				}
				else{
					res[0] = 2;
					res[1] = 3;
					n -=5;
				}
				for (int i = 2; i < primos.length && i < n; i++) 
					if(!primos[i] && !primos[n-i]){
						res[2] = i;
						res[3] = n - i;
					}
				System.out.println(res[0] + " " + res[1] + " " + res[2] + " " + res[3]);
			}
		}
	}
}