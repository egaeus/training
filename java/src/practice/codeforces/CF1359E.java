package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1359/E>
 * @category math
 * @date 28/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1359E {
    static int N, K, MOD = 998244353;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            N = parseInt(st.nextToken());
            K = parseInt(st.nextToken());
            long s = 0;
            for (int i = 1; i <= N; i++) {
                    s = (s+f(N / i - 1, K - 1))%MOD;
                }
            System.out.println(s);
        }
    }

    static long f(int N, int K) {
        if (K > N) return 0;
        long ans = 1;
        for (long i = Math.max(K, N - K) + 1; i <= N; i++)
            ans = (ans * i) % MOD;
        for (long i = Math.min(K, N - K); i > 1; i--) {
            //System.out.println(i+" "+modInverse(i, MOD));
            ans = (ans * modInverse(i, MOD)) % MOD;
        }
        return ans;
    }

    //Existe si a y mod son coprimos
    static long modInverse(long a, long mod) {
        return euclidesExtendido(a, mod)[1]>0?euclidesExtendido(a, mod)[1]:mod+euclidesExtendido(a, mod)[1];
    }

    static long[] euclidesExtendido(long a, long b) {
        for (long q, s = 1, t = 0, s1 = 0, t1 = 1, x; ; ) {
            x = b;
            q = a / b;
            b = a % b;
            a = x;
            x = s1;
            s1 = s - q * s1;
            s = x;
            x = t1;
            t1 = t - q * t1;
            t = x;
            if (b == 0) return new long[]{a, s, t};
        }
    }
}
