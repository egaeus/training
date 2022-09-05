package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/contest/269/problem/B>
 * @category dp
 * @date 27/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF269B {
    static int N, M;
    static int[][] mem;
    static int[][] arr;
    static int[] S;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            arr = new int[M][N + 1];
            mem = new int[M][N + 1];
            S = new int[N];
            for (int[] a : mem) Arrays.fill(a, -1);
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                int s = parseInt(st.nextToken()) - 1;
                arr[s][i] = 1;
                S[i] = s;
            }
            long T = System.currentTimeMillis();
            for (int i = 0; i < M; i++)
                for (int j = N - 2; j >= 0; j--)
                    arr[i][j] += arr[i][j + 1];
            //for (int[] a : arr) System.out.println(Arrays.toString(a));
            for (int p = M - 1; p >= 0; p--)
                for (int x = N; x >= 0; x--)
                    f(p, x);
            if (M == 1)
                System.out.println(0);
            else
                System.out.println(f(0, 0));
            //System.out.println(System.currentTimeMillis()-T);
        }
    }

    static int f(int p, int x) {
        if (p == M - 1) return 0;
        if (mem[p][x] >= 0)
            return mem[p][x];
        if (x == N) {
            int c = 0;
            for (int i = p + (p > 0 ? 1 : 0); i < M; i++)
                c += arr[i][0];
            return c;
        }
        int min = N+1, val1 = 0, val2 = 0, val3 = 0;
        {
            val1 = f(p, x + 1);
            if (min > val1)
                min = val1;
        }
        {
            val2 = f(p + 1, x);
            val2 += arr[p][x] + arr[p+1][0] - arr[p+1][x];
            if (min > val2)
                min = val2;
        }
        {
            val3 = f(p + 1, x + 1);
            //System.out.println(val3+" "+(arr[p][x + 1])+" "+(arr[p + 1][0] - (x>0?arr[p + 1][x-1]:0)));
            val3 += arr[p][x + 1];
            val3 += arr[p + 1][0] - arr[p + 1][x];
            if (min > val3)
                min = val3;
        }
        //System.out.println(p + " " + x + " " + val1 + " " + val2 + " " + val3 + " " + min);
        return mem[p][x] = min;
    }
}
