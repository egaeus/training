package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/118/D>
 * @category dp
 * @date 29/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF118D {
    static int N1, N2, K1, K2;
    static int MOD = 100000000;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            N1 = parseInt(st.nextToken());
            N2 = parseInt(st.nextToken());
            K1 = parseInt(st.nextToken());
            K2 = parseInt(st.nextToken());
            mem = new int[N1 + 1][N2 + 1][2];
            for (int[][] a : mem)
                for (int[] b : a)
                    Arrays.fill(b, -1);
            System.out.println((f(0, 0, 0) + f(0, 0, 1)) % MOD);
        }
    }

    static int[][][] mem;

    static int f(int p1, int p2, int last) {
        if (p1 == N1 && p2 == N2)
            return 1;
        if (mem[p1][p2][last] >= 0)
            return mem[p1][p2][last];
        int sol = 0;
        if (last == 0)
            for (int k = 1; k <= K1 && p1 + k <= N1; k++)
                sol = sol + f(p1 + k, p2, (last + 1) % 2);
        else
            for (int k = 1; k <= K2 && p2 + k <= N2; k++)
                sol = sol + f(p1, p2 + k, (last + 1) % 2);
        return mem[p1][p2][last] = sol % MOD;
    }
}
