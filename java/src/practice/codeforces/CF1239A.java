package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1239/A>
 * @category dp
 * @date 21/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1239A {
    static long MOD = 1000000007;
    static int N, M;
    static long[] mem;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            mem = new long[Math.max(M,N)+1];
            System.out.println((2*f(N)+2*f(M)-2)%MOD);
        }
    }

    static long f(int p) {
        if (p == 0) return 1;
        if (p <0) return 0;
        if(mem[p]>0)return mem[p];
        return mem[p]=(f(p - 1) + f(p - 2)) % MOD;
    }
}
