package practice.codeforces;

/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict WA
 * @url <https://codeforces.com/problemset/problem/1344/D>
 * @category
 * @date
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1344D {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        st = new StringTokenizer(in.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++)
            arr[i] = parseInt(st.nextToken());
        long[] solution = new long[N];
        if (K > 0) {
            long a = -1000000000000000L, b = 1000000000000000L;
            for (; a < b; ) {
                long p = (a + b) / 2;
                if (check(p, solution, K, N, arr))
                    a = p;
                else b = p - 1;
            }
            long k = K;
            for (int i = 0; i < N && K > 0; i++) {
                long s = Math.min(f(i, solution, a, k, arr), K);
                solution[i] += s;
                K -= s;
            }
        }
        StringBuilder sb = new StringBuilder();
        long total = 0;
        for (int i = 0; i < N; i++) {
            sb.append(i > 0 ? " " : "").append(solution[i]);
            total += solution[i] * (arr[i] - solution[i] * solution[i]);
        }
        System.out.println(new String(sb));
    }

    private static long f(int index, long[] solution, long search, long K, long[] arr) {
        long a = 0, b = Math.min(arr[index], K);
        while (a < b) {
            long P = (a + b) / 2;
            if ((P * (arr[index] - P * P) - ((P - 1) * (arr[index] - (P - 1) * (P - 1)))) <= search)
                b = P;
            else a = P + 1;
        }
        return a == 0 ? 1 : a;
    }

    private static boolean check(long p, long[] solution, long k, int N, long[] arr) {
        long K = 0;
        for (int i = 0; i < N; i++)
            K += f(i, solution, p, k, arr);
        return K >= k;
    }
}
