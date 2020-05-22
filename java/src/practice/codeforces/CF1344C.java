package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict W.A.
 * @url <https://codeforces.com/problemset/problem/1344/C>
 * @category graph
 * @date 09/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class CF1344C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            TreeSet<Integer> lAdy[] = new TreeSet[N];
            TreeSet<Integer> lAdyTrans[] = new TreeSet[N];
            for (int i = 0; i < N; i++) {
                lAdy[i] = new TreeSet<>();
                lAdyTrans[i] = new TreeSet<>();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int u = parseInt(st.nextToken()) - 1;
                int v = parseInt(st.nextToken()) - 1;
                lAdy[u].add(v);
                lAdyTrans[v].add(u);
            }
            boolean[] solution = solve(lAdy, lAdyTrans, N);
            if (solution == null)
                System.out.println(-1);
            else {
                int q = 0;
                char[] result = new char[N];
                for (int i = 0; i < N; i++)
                    if (solution[i]) {
                        q++;
                        result[i] = 'A';
                    } else result[i] = 'E';
                System.out.println(q);
                System.out.println(new String(result));
            }
        }
    }

    static boolean[] solve(TreeSet<Integer>[] lAdy, TreeSet<Integer>[] lAdyTrans, int N) {
        //0 -> no visitado, -1 -> En proceso, 1 -> Creciente, 2 -> Decreciente
        int[] visited = new int[N];
        int[] max = new int[N];
        boolean[] result = new boolean[N];
        Arrays.fill(visited, Integer.MAX_VALUE);
        for (int i = 0; i < N; i++)
            if (visited[i] == Integer.MAX_VALUE) {
                int firstSolution = dfs(i, lAdy, visited, N, max);
                if (firstSolution == -1)
                    return null;
                if (lAdyTrans[i].size() == 0 && (visited[i] > i))
                    result[i] = true;
                else if (lAdyTrans[i].size() == 0)
                    result[visited[i]] = true;
            }
        return result;
    }

    static int dfs(int u, TreeSet<Integer>[] lAdy, int[] visited, int N, int[] max) {
        if (visited[u] == -1) return -1;
        if (visited[u] != Integer.MAX_VALUE) return visited[u];
        visited[u] = -1;
        int children = N;
        int maxChildren = -2;
        for (int v : lAdy[u]) {
            int solution = dfs(v, lAdy, visited, N, max);
            if (solution == -1) return -1;
            children = Math.min(children, Math.min(visited[v], v));
            maxChildren = Math.max(maxChildren, Math.max(max[v], v));
        }
        visited[u] = children;
        max[u] = maxChildren;
        return visited[u];
    }
}
