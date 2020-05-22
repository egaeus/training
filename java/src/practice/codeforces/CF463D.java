package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/463/D
 * @category dp
 * @date 23/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF463D {
    static int[][] arr;
    static int[] mem;
    static int K, N;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            N = parseInt(st.nextToken());
            K = parseInt(st.nextToken());
            arr = new int[K][N];
            mem = new int[N + 1];
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(in.readLine());
                for (int i = 0; i < N; i++) {
                    int a = parseInt(st.nextToken());
                    arr[k][a - 1] = i;
                }
            }
            Arrays.fill(mem, -1);
            System.out.println(f(-1));
        }
    }

    static int f(int ant) {
        int max = 0;
        if (mem[ant + 1] >= 0)
            return mem[ant + 1];
        for (int i = 0; i < N; i++)
            if (check(ant, i))
                max = Math.max(max, f(i) + 1);
        return mem[ant + 1] = max;
    }

    static boolean check(int ant, int act) {
        if (ant == -1) return true;
        for (int i = 0; i < K; i++)
            if (arr[i][ant] >= arr[i][act])
                return false;
        return true;
    }
}
