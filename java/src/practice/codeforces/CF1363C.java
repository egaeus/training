package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1363/C>
 * @category trees
 * @date 31/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1363C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), X = parseInt(st.nextToken()) - 1;
            ArrayList<Integer> lAdy[] = new ArrayList[N];
            for (int i = 0; i < N; i++)
                lAdy[i] = new ArrayList<>();
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(in.readLine());
                int u = parseInt(st.nextToken()) - 1;
                int v = parseInt(st.nextToken()) - 1;
                lAdy[u].add(v);
                lAdy[v].add(u);
            }
            if (lAdy[X].size() <= 1) {
                System.out.println("Ayush");
            } else {
                boolean[] vis = new boolean[N];
                vis[X] = true;
                int[] level = new int[N];
                level[0]++;
                LinkedList<int[]> queue = new LinkedList<>();
                queue.add(new int[]{X, 0});
                for (; !queue.isEmpty(); ) {
                    int[] u = queue.poll();
                    for (int v : lAdy[u[0]]) {
                        if (!vis[v]) {
                            vis[v] = true;
                            queue.add(new int[]{v, u[1] + 1});
                            level[u[1] + 1]++;
                        }
                    }
                }
                int begin = 0;
                for (int i = level.length - 1; i > 1; i--)
                    begin = (begin + level[i]) % 2;
                if ((begin + (level[1] - 1)) % 2 == 1)
                    System.out.println("Ashish");
                else
                    System.out.println("Ayush");
            }
        }
    }
}
