package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/296/B>
 * @category dp
 * @date 9/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF296B {
    static int N;
    static char[] A;
    static char[] B;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            N = parseInt(st.nextToken());
            A = in.readLine().toCharArray();
            B = in.readLine().toCharArray();
            mem = new long[N][2][2];
            for (long[][] a : mem)
                for (long[] b : a)
                    Arrays.fill(b, -1);
            for (int i = N; i >= 0; i--) {
                f(i, false, false);
                f(i, false, true);
                f(i, true, false);
                f(i, true, true);
            }
            System.out.println(f(0, false, false));
        }
    }

    static long MOD = 1000000007;
    static long[][][] mem;

    static long f(int p, boolean max, boolean min) {
        if (p == N)
            return max && min ? 1 : 0;
        if (mem[p][max ? 0 : 1][min ? 0 : 1] >= 0)
            return mem[p][max ? 0 : 1][min ? 0 : 1];
        if (A[p] == '?' && B[p] == '?') {
            long s = 0;
            for (int i = 0; i < 10; i++)
                for (int j = 0; j < 10; j++)
                    s = (s + f(p + 1, max || i > j, min || i < j)) % MOD;
            return mem[p][max ? 0 : 1][min ? 0 : 1] = s;
        }
        if (A[p] == '?') {
            long s = 0;
            for (int i = 0; i < 10; i++)
                s = (s + f(p + 1, max || i + '0' > B[p], min || i + '0' < B[p])) % MOD;
            return mem[p][max ? 0 : 1][min ? 0 : 1] = s;
        }
        if (B[p] == '?') {
            long s = 0;
            for (int i = 0; i < 10; i++)
                s = (s + f(p + 1, max || i + '0' < A[p], min || i + '0' > A[p])) % MOD;
            return mem[p][max ? 0 : 1][min ? 0 : 1] = s;
        }
        return mem[p][max ? 0 : 1][min ? 0 : 1] = f(p + 1, max || A[p] > B[p], min || A[p] < B[p]);
    }
}
