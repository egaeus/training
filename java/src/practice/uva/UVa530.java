package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 530
 * @problemName Binomial Showdown 
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 2009
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
public class UVa530 {
	static BigInteger[] fact = new BigInteger[15000];
	static BigInteger factorial(int n){
		if(n<15000&&fact[n]!=null)return fact[n];
		else return n < 15000?fact[n] = new BigInteger(n + "").multiply(factorial(n - 1)):new BigInteger(n + "").multiply(factorial(n - 1));
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long t = System.currentTimeMillis();
		fact[0] = fact[1] = BigInteger.ONE;
		for (int i = 0; i < fact.length; i++) 
			factorial(i);
		while(true){
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int n = parseInt(st.nextToken()), k = parseInt(st.nextToken());
			if(n==0 && k==0)break;
			BigInteger res = BigInteger.ONE;
			for (int i = n; i > Math.max(k, n-k); i--)res = res.multiply(new BigInteger(i + ""));
			System.out.println(res.divide(factorial(Math.min(k, n-k))));
		}
	}
}
