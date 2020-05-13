package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict W.A.
 * @url https://codeforces.com/problemset/problem/1349/A
 * @category arrays
 * @date 12/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

public class CF1349B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            int[] arr = new int[N];
            int[] reverse = new int[N];
            int P = -1;
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = parseInt(st.nextToken());
                reverse[N - i - 1] = arr[i];
                if (arr[i] == K)
                    P = i;
            }
            if (P == -1) {
                System.out.println("no");
            } else {
                boolean ws = f(arr, N, P, K) || f(reverse, N, N - P - 1, K);
                System.out.println(ws ? "yes" : "no");
            }
        }
    }

    static boolean f(int[] arr, int N, int P, int K) {
        int[] Q = new int[N + 1];
        boolean different = false;
        for (int i = 0; i < N; i++) {
            Q[i + 1] = Q[i] + (arr[i] > K ? 1 : arr[i] < K ? -1 : 0);
            if (arr[i] != K)
                different = true;
        }
        if (!different)
            return true;
        boolean ws = N == 1;
        TreeSet<Integer> values = new TreeSet<>();
        for (int i = P; i >= 0; i--)
            values.add(Q[i]);
        int q = 0;
        //System.out.println(Arrays.toString(Q));
        for (int i = P + 2; i < N + 1 && !ws; i++) {
            if (arr[i - 1] == K) q++;
            if (values.contains(-(Q[i] - q)) || values.contains(-(Q[i] + q)))
                ws = true;
        }
        return ws;
    }
}
