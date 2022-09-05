package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1228/C>
 * @category maths
 * @date 01/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Long.parseLong;

public class CF1228C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            long X = parseLong(st.nextToken()), N = parseLong(st.nextToken()), sqrt = (long) Math.sqrt(X);
            TreeSet<Long> primes = new TreeSet<>();
            for (long p = 2; p <= sqrt && X > 1; p++)
                if (X % p == 0) {
                    primes.add(p);
                    for (; X % p == 0; )
                        X /= p;
                }
            if (X > 1) primes.add(X);
            long val = 1;
            for(long p:primes) {
                long r=0,n=N;
                for(;n>1;n/=p)r+=n/p;
                val=(val*BigInteger.valueOf(p).modPow(BigInteger.valueOf(r), BigInteger.valueOf(1000000007)).longValue())%1000000007;
            }
            System.out.println(val);
        }
    }
}
