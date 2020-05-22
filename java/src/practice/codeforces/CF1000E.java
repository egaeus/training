package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict W.A.
 * @url <https://codeforces.com/problemset/problem/1000/E>
 * @category graph
 * @date 30/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class CF1000E {

    static int[] low, disc;
    static int time;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            TreeSet<Integer>[] lAdy = new TreeSet[N];
            for (int i = 0; i < N; i++)
                lAdy[i] = new TreeSet<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int u = parseInt(st.nextToken()) - 1;
                int v = parseInt(st.nextToken()) - 1;
                lAdy[u].add(v);
                lAdy[v].add(u);
            }

            dfs(lAdy, N);
            int solution = 0;
            for (int u = 0; u < N; u++)
                for (int v : lAdy[u])
                    if (low[v] > disc[u])
                        solution++;
            System.out.println(solution);
        }
    }

    enum Visited {
        NONE, ADD_TO_STACK, VISITED
    }

    static Visited[] visit;
    static int[] parent;

    static void dfs(TreeSet<Integer>[] lAdy, int N) {
        low = new int[N];
        disc = new int[N];
        time = 0;
        visit = new Visited[N];
        parent = new int[N];
        Arrays.fill(visit, Visited.NONE);
        Arrays.fill(parent, -1);
        visit[0] = Visited.ADD_TO_STACK;
        dfs1(lAdy, 0);
    }

    static void dfs1(TreeSet<Integer>[] lAdy, int u) {
        visit[u] = Visited.VISITED;
        disc[u] = time;
        low[u] = time++;
        for (int v : lAdy[u]) {
            if (visit[v] == Visited.NONE) {
                visit[v] = Visited.ADD_TO_STACK;
                parent[v] = u;
                dfs1(lAdy, v);
                low[u] = Math.min(low[u], low[v]);
            } else if (v != parent[u])
                low[u] = Math.min(low[u], disc[v]);
        }
    }
}
