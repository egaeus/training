package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/116/B>
 * @category implementation
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF116B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            char[][] mat = new char[N][M];
            for (int i = 0; i < N; i++)
                mat[i] = in.readLine().toCharArray();
            boolean[][] wolfs = new boolean[N][M];
            boolean[][] pigs = new boolean[N][M];
            int[][] neigh = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++) {
                    if (mat[i][j] != '.') {
                        for (int[] a : neigh)
                            if (i + a[0] >= 0 && i + a[0] < N && j + a[1] >= 0 && j + a[1] < M) {
                                if (mat[i][j] == 'P' && mat[i + a[0]][j + a[1]] == 'W')
                                    pigs[i][j] = true;
                                if (mat[i][j] == 'W' && mat[i + a[0]][j + a[1]] == 'P')
                                    wolfs[i][j] = true;
                            }
                    }
                }
            int p = 0, w = 0;
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++) {
                    if (pigs[i][j]) p++;
                    if (wolfs[i][j]) w++;
                }
            System.out.println(Math.min(w, p));
        }
    }
}
