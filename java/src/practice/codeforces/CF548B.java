package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/548/B>
 * @category implementation
 * @date 6/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF548B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken()), Q = parseInt(st.nextToken());
            int[][] mat = new int[N][M];
            int[] score = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < M; j++)
                    mat[i][j] = parseInt(st.nextToken());
                score[i] = f(mat, i);
            }
            for (int q = 0; q < Q; q++) {
                st = new StringTokenizer(in.readLine());
                int i = parseInt(st.nextToken()) - 1, j = parseInt(st.nextToken()) - 1;
                mat[i][j] = (mat[i][j] + 1) % 2;
                score[i] = f(mat, i);
                int max = 0;
                for (int k = 0; k < N; k++)
                    max = Math.max(score[k], max);
                sb.append(max).append("\n");
            }
            System.out.print(new String(sb));
        }
    }

    static int f(int[][] mat, int i) {
        int ones = 0, max = 0;
        for (int j = 0; j < mat[i].length; j++) {
            if (mat[i][j] == 0) {
                max = Math.max(ones, max);
                ones = 0;
            } else ones++;
        }
        return Math.max(ones, max);
    }
}
