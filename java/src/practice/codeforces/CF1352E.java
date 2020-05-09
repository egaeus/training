package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1352/E
 * @category two pointers
 * @date 09/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1352E {
    static int[] A = new int[8000];
    static boolean[] vis = new boolean[8001];

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = parseInt(st.nextToken());
                if (i > 0) A[i] += A[i - 1];
                vis[i] = false;
            }
            for (int i = N; i < 8001; i++)
                vis[i] = false;
            int sum;
            int result = 0;
            for (int i = 0; i < N; i++)
                for (int j = i + 1; j < N; j++) {
                    sum = A[j] - (i > 0 ? A[i - 1] : 0);
                    if (sum <= 8000)
                        vis[sum] = true;
                }
            for (int i = 0; i < N; i++) {
                sum = A[i] - (i > 0 ? A[i - 1] : 0);
                if (vis[sum]) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
