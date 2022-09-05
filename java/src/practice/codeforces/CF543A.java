package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/543/A>
 * @category dp
 * @date 28/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF543A {

    static int N, M, B, MOD;
    static int[] arr;
    static long[][][] dp;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            B = parseInt(st.nextToken());
            MOD = parseInt(st.nextToken());
            dp = new long[2][M + 1][B + 1];
            arr = new int[N];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = parseInt(st.nextToken());
            System.out.println(dp());
        }
    }

    static long dp() {
        Arrays.fill(dp[1][0], 1);
        for (int n = N - 1; n >= 0; n--) {
            for (int m = 0; m <= M; m++)
                for (int b = 0; b <= B; b++) {
                    dp[0][m][b] = dp[1][m][b];
                    if (m > 0 && b >= arr[n]) {
                        dp[0][m][b] = (dp[0][m][b]+dp[0][m - 1][b - arr[n]])%MOD;
                    }
                }
            dp[1] = dp[0];
            dp[0] = new long[M+1][B+1];
        }
        return dp[1][M][B];
    }
}
