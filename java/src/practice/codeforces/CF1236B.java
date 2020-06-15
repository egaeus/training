package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1236/B>
 * @category math
 * @date 9/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1236B {
    static long N, M;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            long Q = f(2, M);
            if (Q == 0) Q = MOD;
            Q--;
            System.out.println(f(Q, N));
        }
    }

    static long MOD = 1000000007;

    static long f(long n, long exp) {
        if (exp == 0) return 1;
        if (exp == 1) return n % MOD;
        long middle = f(n, exp / 2);
        long result = (middle * middle) % MOD;
        if (exp % 2 == 1)
            result = (result * n) % MOD;
        return result;
    }
}
