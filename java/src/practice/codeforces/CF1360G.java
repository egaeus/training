package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Not sended
 * @url <https://codeforces.com/problemset/problem/1360/G>
 * @category flow
 * @date 24/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1360G {

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken()),
                    A = parseInt(st.nextToken()), B = parseInt(st.nextToken());
            int[][] cap = new int[N + M + 2][N + M + 2];
            int s = cap.length - 2, d = cap.length - 1;
            for (int i = 0; i < N; i++) {
                cap[s][i] = A;
                for (int j = 0; j < M; j++) {
                    cap[N+j][d] = B;
                    cap[i][N+j] = 1;
                }
            }
            if (A * N == M * B) {
                int f = edmondsKarp(cap, s, d, cap.length);
                if (A * N == f) {
                    sb.append("YES\n");
                    char[][] result = new char[N][M];
                    for (char[] a : result) Arrays.fill(a, '0');
                    for (int i = 0; i < N; i++)
                        for (int j = 0; j < M; j++)
                            if (flow[i][N+j] == 1)
                                result[i][j] = '1';
                    for (char[] a : result)
                        sb.append(new String(a)).append("\n");
                } else
                    sb.append("NO\n");
            } else
                sb.append("NO\n");

        }
        System.out.print(new String(sb));
    }

    static int[][] flow;

    static int edmondsKarp(int[][] capacity, int v1, int v2, int n) { // residualCapacity=capacity-flow
        int lAdy[][] = new int[n][], ants[] = new int[n], queue[] = new int[n], v, u;
        int f = 0, m, minCap[] = new int[n];
        flow = new int[n][n];
        List h[] = new List[n];
        for (u = 0; u < n; u++) h[u] = new ArrayList<Integer>();
        for (u = 0; u < n; u++)
            for (v = 0; v < n; v++)
                if (capacity[u][v] > 1e-10) {
                    h[u].add(v);
                    h[v].add(u);
                }
        for (u = 0; u < n; u++) lAdy[u] = toArr(h[u]);
        for (; (m = bfsEK(capacity, flow, lAdy, ants, minCap, queue, v1, v2)) > 1e-10; f += m)
            for (v = v2, u = ants[v]; v != v1; v = u, u = ants[v]) {
                flow[u][v] += m;
                flow[v][u] -= m;
            }
        return f;
    }

    static int bfsEK(int[][] capacity, int[][] flow, int[][] lAdy,
                     int[] ants, int[] minCap, int[] queue, int v1, int v2) {
        int i, t = 0, u;
        int z;
        Arrays.fill(ants, -1);
        ants[v1] = -2;
        minCap[v1] = 3000;
        for (queue[t++] = v1, i = 0; i < t; i++)
            for (int v : lAdy[u = queue[i]])
                if ((z = capacity[u][v] - flow[u][v]) > 1e-10 && ants[v] == -1) {
                    ants[v] = u;
                    minCap[v] = Math.min(minCap[u], z);
                    if (v == v2) return minCap[v2];
                    queue[t++] = v;
                }
        return 0;
    }

    static int[] toArr(List<Integer> p) {
        int r[] = new int[p.size()], i = 0;
        for (int x : p) r[i++] = x;
        return r;
    }
}

