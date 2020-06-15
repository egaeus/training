package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/791/B>
 * @category graph
 * @date 5/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF791B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            ArrayList<Integer> lAdy[] = new ArrayList[N];
            int[][] edges = new int[M][];
            int[] component = new int[N];
            int[] edgesComponent = new int[N];
            long[] verticesComponent = new long[N];
            for (int i = 0; i < N; i++) {
                lAdy[i] = new ArrayList<>();
                component[i] = -1;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int u = parseInt(st.nextToken()) - 1, v = parseInt(st.nextToken()) - 1;
                edges[i] = new int[]{u, v};
                lAdy[u].add(v);
                lAdy[v].add(u);
            }
            int components = 0;
            for (int i = 0; i < N; i++)
                if (component[i] == -1) {
                    component[i] = components;
                    LinkedList<Integer> queue = new LinkedList<>();
                    queue.add(i);
                    verticesComponent[components]++;
                    for (int u; !queue.isEmpty(); ) {
                        u = queue.poll();
                        for (int v : lAdy[u]) {
                            if (component[v] == -1) {
                                component[v] = components;
                                queue.add(v);
                                verticesComponent[components]++;
                            }
                        }
                    }
                    components++;
                }
            for (int i = 0; i < M; i++)
                edgesComponent[component[edges[i][0]]]++;
            boolean ws = true;
            for (int i = 0; i < components && ws; i++)
                if (edgesComponent[i] < (verticesComponent[i] * (verticesComponent[i] - 1)) / 2)
                    ws = false;
            System.out.println(ws ? "YES" : "NO");
        }
    }
}
