package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1354/E>
 * @category graph, dp
 * @date 18/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class CF1354E {
    static TreeSet<Integer> lAdy[];
    static int[] vis;
    static ArrayList<int[]> list;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            int N1 = parseInt(st.nextToken()), N2 = parseInt(st.nextToken()), N3 = parseInt(st.nextToken());
            lAdy = new TreeSet[N];
            vis = new int[N];
            for (int i = 0; i < N; i++) {
                lAdy[i] = new TreeSet<>();
                vis[i] = -1;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int u = parseInt(st.nextToken()) - 1;
                int v = parseInt(st.nextToken()) - 1;
                lAdy[u].add(v);
                lAdy[v].add(u);
            }
            list = new ArrayList<>();
            boolean ws = true;
            for (int i = 0; i < N && ws; i++)
                if (vis[i] == -1) {
                    int[] b = f(i, 0);
                    if (b == null)
                        ws = false;
                    list.add(b);
                }
            if (ws) {
                mem = new int[list.size()][N2 + 1];
                if (fMem(0, N2)) {
                    sb.append("YES\n");
                    int p = 0;
                    int[] solution = new int[N];
                    for (p = 0; p < list.size(); p++) {
                        for (int i = 0; i < N; i++)
                            if (vis[i] / 2 == p) {
                                if (vis[i] % 2 == mem[p][N2] % 2)
                                    solution[i] = 2;
                                else if (N1 > 0) {
                                    solution[i] = 1;
                                    N1--;
                                } else {
                                    solution[i] = 3;
                                    N3--;
                                }
                            }
                        if (mem[p][N2] == 2)
                            N2 -= list.get(p)[0];
                        else
                            N2 -= list.get(p)[1];
                    }
                    sb.append(IntStream.of(solution).mapToObj(a -> a + "").collect(Collectors.joining()));
                    sb.append("\n");
                } else sb.append("NO\n");
            } else sb.append("NO\n");
        }
        System.out.print(new String(sb));
    }

    static int[][] mem;

    static boolean fMem(int p, int n2) {
        if (n2 < 0) return false;
        if (p == list.size()) return n2 == 0;
        if (mem[p][n2] != 0)
            return mem[p][n2] > 1;
        if (fMem(p + 1, n2 - list.get(p)[0])) {
            mem[p][n2] = 2;
            return true;
        }
        if (fMem(p + 1, n2 - list.get(p)[1])) {
            mem[p][n2] = 3;
            return true;
        }
        mem[p][n2] = 1;
        return false;
    }

    static int[] f(int u, int c) {
        if (vis[u] >= 0)
            if (c == vis[u] % 2)
                return new int[]{0, 0};
            else return null;
        int[] solution = new int[]{0, 0};
        solution[c]++;
        vis[u] = list.size() * 2 + c;
        for (int v : lAdy[u]) {
            int[] b = f(v, (c + 1) % 2);
            if (b == null)
                solution = null;
            if (solution != null) {
                solution[0] += b[0];
                solution[1] += b[1];
            }
        }
        return solution;
    }
}
