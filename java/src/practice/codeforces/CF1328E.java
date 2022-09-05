/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1328/E>
 * @category trees, lca
 * @date 13/05/2020
 **/

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
            int[] sqrtParents = new int[N];
            int sqrt = (int) Math.sqrt(N);
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
            Arrays.fill(sqrtParents, 0);
            for (; !queue.isEmpty(); ) {
                int u = queue.poll();
                for (int v : lAdy[u]) {
                    if (!visited[v]) {
                        queue.add(v);
                        visited[v] = true;
                        level[v] = level[u] + 1;
                        parents[v] = u;
                        if (level[v] % sqrt == 0)
                            sqrtParents[v] = u;
                        else sqrtParents[v] = sqrtParents[u];
                    }
                }
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
                for (int j = 0, J = parseInt(st.nextToken()); j < J; j++) {
                    int u = parseInt(st.nextToken()) - 1;
                    TreeSet<Integer> list = map.get(level[u]);
                    if (list == null)
                        list = new TreeSet<>();
                    list.add(u);
                    map.put(level[u], list);
                }
                boolean ws = true;
                int parent = -1;
                for (Map.Entry<Integer, TreeSet<Integer>> entry : map.descendingMap().entrySet()) {
                    TreeSet<Integer> list = entry.getValue();
                    parent = parents[list.first()];
                    for (int j : list)
                        if (parents[j] != parent)
                            ws = false;
                    if (ws) {
                        Integer lastLevel = map.floorKey(entry.getKey() - 1);
                        if(lastLevel != null) {
                            while(level[parent]>lastLevel) {
                                if(level[sqrtParents[parent]] < lastLevel)
                                    parent = parents[parent];
                                else parent = sqrtParents[parent];
                            }
                            map.get(lastLevel).add(parent);
                        }
                    }
                }
                sb.append(ws ? "YES" : "NO").append("\n");
            }
        }
        System.out.print(new String(sb));
    }
}
