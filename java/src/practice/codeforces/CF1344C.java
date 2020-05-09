package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict W.A.
 * @url https://codeforces.com/problemset/problem/1344/C
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
            for(int i=0;i<N;i++)
                System.out.println(i+" "+lAdy[i]);
            ArrayList<ArrayList<Integer>> components = components(lAdy, lAdyTrans, N);
            System.out.println(components);
            boolean[] solution = new boolean[N];
            TreeSet<Integer> lAdys[][] = new TreeSet[][]{lAdy, lAdyTrans};
            for (ArrayList<Integer> component : components) {
                boolean[] betterSolution = new boolean[N];
                int betterCount = 0;
                for (int i = 0; i < 2 && solution != null; i++) {
                    boolean[] result = solve(lAdys[i], lAdys[(i + 1) % 2], N, component);
                    if (result == null) {
                        solution = null;
                        break;
                    } else {
                        int quantity = IntStream.range(0, N).map(p -> result[p] ? 1 : 0).sum();
                        if (quantity >= betterCount) {
                            betterCount = quantity;
                            betterSolution = result;
                        }
                    }
                    if(component.contains(1)) {
                        System.out.println(i+"?");
                        IntStream.range(0,N).forEach(p -> {if(result[p]) System.out.print(p+" ");});
                        System.out.println("....");
                    }
                }
                if (solution == null) break;
                for (int i = 0; i < N; i++)
                    solution[i] |= betterSolution[i];
            }
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

    static ArrayList<ArrayList<Integer>> components(TreeSet<Integer>[] lAdy, TreeSet<Integer>[] lAdyTrans, int N) {
        boolean[] vis = new boolean[N];
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(i);
                component.add(i);
                vis[i] = true;
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    for (int v : lAdy[u])
                        if (!vis[v]) {
                            queue.add(v);
                            component.add(v);
                            vis[v] = true;
                        }
                    for (int v : lAdyTrans[u])
                        if (!vis[v]) {
                            queue.add(v);
                            component.add(v);
                            vis[v] = true;
                        }
                }
                components.add(component);
            }
        }
        return components;
    }

    static boolean[] solve(TreeSet<Integer>[] lAdy, TreeSet<Integer>[] lAdyTrans, int N, ArrayList<Integer> component) {
        //0 -> no visitado, -1 -> En proceso, 1 -> Creciente, 2 -> Decreciente
        int[] visited = new int[N];
        int[] max = new int[N];
        boolean[] result = new boolean[N];
        Arrays.fill(visited, Integer.MAX_VALUE);
        for (int i: component)
            if (visited[i] == Integer.MAX_VALUE) {
                int firstSolution = dfs(i, lAdy, visited, N, max);
                if (firstSolution == -1)
                    return null;
                if (lAdyTrans[i].size() == 0 && (visited[i] > i || max[i] < i))
                    result[i] = true;
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
