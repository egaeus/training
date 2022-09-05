package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/200/A>
 * @category brute force
 * @date 3/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF200A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            int[][] right = new int[N][M];
            int[][] left = new int[N][M];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++) {
                    left[i][j] = j;
                    right[i][j] = j;
                }
            int p[] = new int[]{-1, -1};
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(in.readLine());
                int x = parseInt(st.nextToken()) - 1, y = parseInt(st.nextToken()) - 1;
                int min = MAX_VALUE;
                p[0] = N;
                p[1] = M;
                for (int i = x; i >= 0; i--) {
                    if (min < x - i) break;
                    if (min >= y - right[i][y] + x - i && right[i][y] < N * M) {
                        min = y - right[i][y] + x - i;
                        p[0] = i;
                        p[1] = right[i][y];
                    }
                    if ((min > left[i][y] - y + x - i || (left[i][y] - y + x - i == min && i < p[0])) && left[i][y] < N * M) {
                        min = left[i][y] - y + x - i;
                        p[0] = i;
                        p[1] = left[i][y];
                    }
                }
                for (int i = x; i < N; i++) {
                    if (min < i - x) break;
                    if (min > y - right[i][y] + i - x && right[i][y] < N * M) {
                        min = y - right[i][y] + i - x;
                        p[0] = i;
                        p[1] = right[i][y];
                    }
                    if ((min > left[i][y] - y + i - x || (left[i][y] - y + i - x == min && i < p[0])) && left[i][y] < N * M) {
                        min = left[i][y] - y + i - x;
                        p[0] = i;
                        p[1] = left[i][y];
                    }
                }
                x = p[0];
                y = p[1];
                int v = left[x][y];
                for (int i = y; i >= 0; i--) {
                    if (left[x][i] != v) break;
                    left[x][i] = y < M - 1 ? left[x][y + 1] : N * M;
                }
                for (int i = y; i < M; i++) {
                    if (right[x][i] != v) break;
                    right[x][i] = y > 0 ? right[x][y - 1] : N * M;
                }
                sb.append((x + 1) + " " + (y + 1)).append("\n");
            }
            System.out.print(new String(sb));
        }
    }
}

