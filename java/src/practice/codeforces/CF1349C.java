package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1349/C>
 * @category graph
 * @date 27/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1349C {

    static int[][] neigh = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken()), T = parseInt(st.nextToken());
            char[][] mat = new char[N][];
            for (int i = 0; i < N; i++) mat[i] = in.readLine().toCharArray();
            int[][] visited = new int[N][M];
            for (int[] a : visited) Arrays.fill(a, -1);
            LinkedList<int[]> queue = new LinkedList<>();
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++) {
                    int c = 0;
                    for (int k = 0; k < 4; k++)
                        if (neigh[k][0] + i >= 0 && neigh[k][0] + i < N &&
                                neigh[k][1] + j >= 0 && neigh[k][1] + j < M &&
                                mat[i][j] == mat[neigh[k][0] + i][neigh[k][1] + j])
                            c++;
                    if (c > 0) {
                        queue.add(new int[]{i, j});
                        visited[i][j] = 1;
                    }
                }
            for (int t = 2; !queue.isEmpty();t++) {
                int size = queue.size();
                for(int r = 0; r < size; r++) {
                    int[] p = queue.poll();
                    int i = p[0], j = p[1];
                    for (int k = 0; k < 4; k++)
                        if (neigh[k][0] + i >= 0 && neigh[k][0] + i < N &&
                                neigh[k][1] + j >= 0 && neigh[k][1] + j < M &&
                                mat[i][j] != mat[neigh[k][0] + i][neigh[k][1] + j] &&
                                visited[neigh[k][0] + i][neigh[k][1] + j] < 0) {
                            visited[neigh[k][0] + i][neigh[k][1] + j] = t;
                            queue.add(new int[]{neigh[k][0] + i, neigh[k][1] + j});
                        }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int t = 0; t < T; t++) {
                st = new StringTokenizer(in.readLine());
                int i = parseInt(st.nextToken()) - 1, j = parseInt(st.nextToken()) - 1;
                long Q = Long.parseLong(st.nextToken());
                if (Q < visited[i][j] || visited[i][j] == -1)
                    sb.append(mat[i][j]).append("\n");
                else {
                    long p = (mat[i][j] - '0' + (Q - visited[i][j] + 1)) % 2;
                    sb.append(p).append("\n");
                }
            }
            /*for (int[] a : visited)
                System.out.println(Arrays.toString(a));*/
            System.out.print(new String(sb));
        }
    }
}
