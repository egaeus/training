/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1353/F
 * @category dp
 * @date 14/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

public class CFF {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            long min = Long.MAX_VALUE;
            arr = new long[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Long.parseLong(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    min = Math.min(min, check(arr[i][j] - i - j));
            System.out.println(min);
        }
    }

    static long[][] arr;
    static long[][] mem = new long[100][100];

    static long check(long A) {
        if (arr[0][0] < A)
            return Long.MAX_VALUE;
        for (long[] m : mem) Arrays.fill(m, Long.MAX_VALUE);
        mem[0][0] = arr[0][0] - A;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++) {
                long actual = arr[i][j];
                long ant = A + i + j - 1;
                if (actual > ant && i > 0 && mem[i - 1][j] < Long.MAX_VALUE)
                    mem[i][j] = Math.min(mem[i][j], mem[i - 1][j] + actual - ant - 1);
                if (actual > ant && j > 0 && mem[i][j - 1] < Long.MAX_VALUE)
                    mem[i][j] = Math.min(mem[i][j], mem[i][j - 1] + actual - ant - 1);
            }
        return mem[arr.length - 1][arr[0].length - 1];
    }

}
