package practice.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class CF1328E {
    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            ArrayList<Integer> lAdy[] = new ArrayList[N];
            int[] parents = new int[N];
            int[] level = new int[N];
            for (int i = 0; i < N; i++)
                lAdy[i] = new ArrayList<>();
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(in.readLine());
                int u = parseInt(st.nextToken()) - 1;
                int v = parseInt(st.nextToken()) - 1;
                lAdy[u].add(v);
                lAdy[v].add(u);
            }
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(0);
            boolean[] visited = new boolean[N];
            visited[0] = true;
            for (; !queue.isEmpty(); ) {
                int u = queue.poll();
                for (int v : lAdy[u]) {
                    if (!visited[v]) {
                        queue.add(v);
                        visited[v] = true;
                        level[v] = level[u] + 1;
                        parents[v] = u;
                    }
                }
            }
            int[] path = new int[N];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int[] arr = new int[parseInt(st.nextToken())];
                int maxLevel = 0;
                int maxNode = 0;
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = parseInt(st.nextToken()) - 1;
                    if (level[arr[j]] > maxLevel) {
                        maxLevel = level[arr[j]];
                        maxNode = arr[j];
                    }
                }
                path[0] = i + 1;
                for (int u = maxNode; u > 0; u = parents[u])
                    path[u] = i + 1;
                boolean ws = true;
                for (int u : arr)
                    if (path[u] != i + 1 && path[parents[u]] != i + 1) {
                        ws = false;
                        break;
                    }
                sb.append(ws ? "YES" : "NO").append("\n");
            }
        }
        System.out.print(new String(sb));
    }
}
