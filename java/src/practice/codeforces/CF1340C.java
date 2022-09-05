package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict W.A.
 * @url <https://codeforces.com/problemset/problem/1340/C>
 * @category graph
 * @date 8/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1340C {
    static int N, M;
    static int[] P;
    static int G, R;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken()) - 1;
            P = new int[M];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < M; ) {
                int v = parseInt(st.nextToken());
                if (v != N)
                    P[i++] = v;
            }
            st = new StringTokenizer(in.readLine());
            G = parseInt(st.nextToken());
            R = parseInt(st.nextToken());
            Arrays.sort(P);
            min = Long.MAX_VALUE;
            vis = new boolean[N][G + 1];
            f();
            if (min < Long.MAX_VALUE)
                System.out.println(min);
            else System.out.println(-1);
        }
    }

    static boolean[][] vis;
    static long min;

    static void f() {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        vis[0][0] = true;
        while (!queue.isEmpty()) {
            int[] u = queue.poll();
            if (N - P[u[0]] <= u[1])
                min = Math.min(u[2] + N - P[u[0]], min);
            if (u[1] == 0 && u[0] > 0)
                u[2] += R;
            if (u[1] == 0 && !vis[u[0]][G]) {
                vis[u[0]][G] = true;
                queue.add(new int[]{u[0], G, u[2]});
            }
            for (int i = -1; i < 2; i += 2)
                if (u[0] + i >= 0 && u[0] + i < M) {
                    int p = u[0], p1 = u[0] + i, v = u[1] - Math.abs(P[p] - P[p1]);
                    if (v >= 0 && !vis[p1][v]) {
                        vis[p1][v] = true;
                        queue.add(new int[]{p1, v, u[2] + Math.abs(P[p] - P[p1])});
                    }
                }
        }
    }

}
