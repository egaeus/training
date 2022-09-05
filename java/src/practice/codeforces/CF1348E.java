package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1348/E>
 * @category dp
 * @date 01/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1348E {

    static int[][] arr;
    static long[] sums;
    static int K;
    static long[][] mem;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            K = parseInt(st.nextToken());
            arr = new int[N][];
            sums = new long[N];
            mem = new long[N][K + 1];
            for (long[] a : mem) Arrays.fill(a, -1);
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                arr[i] = new int[]{parseInt(st.nextToken()), parseInt(st.nextToken())};
                sums[i] = (i > 0 ? sums[i - 1] : 0) + arr[i][1] + arr[i][0];
            }
            for (int i = N; i >= 0; i--) for (int F = K; F >= 0; F--) f(i, F);
            System.out.println(f(0, 0));
        }
    }

    public static long f(int shrub, int blue) {
        if (shrub == arr.length)
            return 0;
        if (mem[shrub][blue] >= 0)
            return mem[shrub][blue];
        int S = (int) (shrub > 0 ? (sums[shrub - 1] - blue) % K : 0);
        long max = 0;
        for (int i = 0; i < K && i <= arr[shrub][0]; i++) {
            int sum = (arr[shrub][0] + arr[shrub][1] - i);
            int mod = sum % K;
            if (mod <= arr[shrub][1]) {
                long firstSolution = (blue + i >= K ? 1 : 0) + (S + mod >= K ? 1 : 0);
                firstSolution += f(shrub + 1, blue + i >= K ? blue + i - K : blue + i);
                firstSolution += sum / K;
                max = Math.max(firstSolution, max);
            }
        }
        return mem[shrub][blue] = max;
    }
}
