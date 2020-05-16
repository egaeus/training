/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1353/E
 * @category dp
 * @date 14/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CFE {

    static char[] arr;
    static int[] Q;
    static int N, K;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = parseInt(st.nextToken());
            K = parseInt(st.nextToken());
            arr = in.readLine().toCharArray();
            Q = new int[N];
            for (int i = 0; i < N; i++) {
                Q[i] = (i > 0 ? Q[i - 1] : 0) + (arr[i] - '0');
                mem[i][0] = -1;
                mem[i][1] = -1;
            }
            for(int i=N-1;i>=0;i--) {
                f(i, true);
                f(i, false);
            }
            System.out.println(f(0, false));
        }
    }

    static int[][] mem = new int[1000000][2];

    static int f(int p, boolean obligatory) {
        if (p >= N) return 0;
        if (mem[p][obligatory ? 0 : 1] >= 0)
            return mem[p][obligatory ? 0 : 1];
        int min = N;
        if (!obligatory)
            min = f(p + 1, false) + (arr[p] == '1' ? 1 : 0);
        int s = 0, s1 = 0;
        if (arr[p] == '0') {
            s++;
            s1++;
        }
        s1 += Q[N - 1] - Q[p];
        s += f(p + K, true) + Q[Math.min(p + K - 1, N - 1)] - Q[p];
        return mem[p][obligatory ? 0 : 1] = Math.min(min, Math.min(s1, s));
    }
}
