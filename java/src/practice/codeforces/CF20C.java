package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/20/C
 * @category graph
 * @date 23/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class CF20C {

    static TreeMap<Integer, Integer> mAdy[];
    static long inf = 1000000000000L;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            mAdy = new TreeMap[N];
            for (int i = 0; i < N; i++)
                mAdy[i] = new TreeMap<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int u = parseInt(st.nextToken()) - 1;
                int v = parseInt(st.nextToken()) - 1;
                int h = parseInt(st.nextToken());
                Integer val = mAdy[u].get(v);
                if (val == null) val = h;
                else val = Math.min(val, h);
                mAdy[u].put(v, val);
                mAdy[v].put(u, val);
            }
            LinkedList<Integer> sol = dijkstra(N);
            if(sol==null)
                System.out.println(-1);
            else
                System.out.println(sol.stream().map(a -> (a+1)+"").collect(Collectors.joining(" ")));
        }
    }

    public static LinkedList<Integer> dijkstra(int N) {
        TreeSet<long[]> queue = new TreeSet<>((a, b) -> a[0] < b[0] ? -1 : a[0] > b[0] ? 1 : a[1] < b[1] ? -1 : a[1] > b[1] ? 1 : 0);
        int[] ants = new int[N];
        long[] dist = new long[N];
        boolean[] vis = new boolean[N];
        Arrays.fill(dist, inf);
        Arrays.fill(ants, -1);
        queue.add(new long[]{0, 0});
        dist[0] = 0;
        vis[0] = true;
        while (!queue.isEmpty()) {
            long[] A = queue.pollFirst();
            int u = (int) A[1];
            vis[u] = true;
            for (int v : mAdy[u].keySet()) {
                long val = mAdy[u].get(v);
                if (dist[v] > dist[u] + val && !vis[v]) {
                    dist[v] = dist[u] + val;
                    queue.add(new long[]{dist[v], v});
                    ants[v] = u;
                }
            }
        }
        if (dist[N - 1] < inf) {
            LinkedList<Integer> list = new LinkedList<>();
            for(int u=N-1;u>=0;u=ants[u])
                list.addFirst(u);
            return list;
        }
        return null;
    }
}
