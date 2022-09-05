package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1231/E>
 * @category strings, dp
 * @date 30/09/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class CF1231E {

    static char[] S;
    static char[] T;
    static int[][][] mem;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int C = parseInt(in.readLine()), t = 0; t++ < C; ) {
            int N = parseInt(in.readLine());
            S = in.readLine().toCharArray();
            T = in.readLine().toCharArray();
            int[] A = new int[26], B = new int[26];
            for (int i = 0; i < N; i++) {
                A[S[i] - 'a']++;
                B[T[i] - 'a']++;
            }
            boolean ws = true;
            for (int i = 0; i < 26; i++)
                ws = ws && A[i] == B[i];
            if (ws) {
                mem = new int[N + 1][N + 1][N + 1];
                int max = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = N; j > i; j--)
                        if (f(i, j, 0)) {
                            ws = true;
                            max = Math.max(j - i, max);
                        }
                }
                if (!ws)
                    System.out.println(-1);
                else
                    System.out.println(N - max);
            } else System.out.println(-1);
        }
    }

    static boolean f(int I, int J, int P) {
        if (I >= J)
            return true;
        if (P == S.length)
            return false;
        if (mem[I][J][P] != 0)
            return mem[I][J][P] == 1;
        boolean ws = f(I, J, P + 1);
        if (!ws && T[I] == S[P])
            ws = f(I + 1, J, P + 1);
        mem[I][J][P] = ws ? 1 : 2;
        return ws;
    }
}
