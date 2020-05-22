package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1344/B
 * @category graph
 * @date 09/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class CF1344B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            char[][] tab = new char[N][];
            for (int i = 0; i < N; i++)
                tab[i] = in.readLine().toCharArray();
            int[] qCols = new int[M];
            int[] qRows = new int[N];
            for (int i = 0; i < N; i++) {
                int comps = 0;
                for (int j = 0; j < M; j++)
                    if (tab[i][j] == '#' && (j == 0 || tab[i][j - 1] == '.'))
                        comps++;
                qRows[i] = comps;
            }
            for (int j = 0; j < M; j++) {
                int comps = 0;
                for (int i = 0; i < N; i++)
                    if (tab[i][j] == '#' && (i == 0 || tab[i - 1][j] == '.'))
                        comps++;
                qCols[j] = comps;
            }
            boolean[] putCol = new boolean[M];
            boolean[] putRow = new boolean[N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    if (tab[i][j] == '#') {
                        if (qCols[j] == 1 && qRows[i] == 1) {
                            putCol[j] = true;
                            putRow[i] = true;
                        }
                    } else {
                        if (qCols[j] == 0 && qRows[i] == 0) {
                            putCol[j] = true;
                            putRow[i] = true;
                        }
                    }
            int countCol = 0;
            int countRow = 0;
            for (int i = 0; i < N; i++)
                if (putRow[i]) countRow++;
            for (int j = 0; j < M; j++)
                if (putCol[j]) countCol++;
            if (countCol == M && countRow == N) {
                boolean[][] visited = new boolean[N][M];
                int comps = 0;
                LinkedList<int[]> queue = new LinkedList<>();
                int[][] neighborhoods = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int i = 0; i < N; i++)
                    for (int j = 0; j < M; j++)
                        if (tab[i][j] == '#' && !visited[i][j]) {
                            queue.add(new int[]{i, j});
                            visited[i][j] = true;
                            comps++;
                            for (int[] u; !queue.isEmpty(); ) {
                                u = queue.poll();
                                for (int[] k : neighborhoods) {
                                    if (u[0] + k[0] >= 0 && u[0] + k[0] < N && u[1] + k[1] >= 0 && u[1] + k[1] < M &&
                                            tab[u[0] + k[0]][u[1] + k[1]] == '#' && !visited[u[0] + k[0]][u[1] + k[1]]) {
                                        queue.add(new int[]{u[0] + k[0], u[1] + k[1]});
                                        visited[u[0] + k[0]][u[1] + k[1]] = true;
                                    }
                                }
                            }
                        }
                System.out.println(comps);
            } else {
                System.out.println(-1);
            }

        }
    }
}

