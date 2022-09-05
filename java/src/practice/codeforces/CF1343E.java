package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1343/E>
 * @category graph
 * @date 11/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class CF1343E {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken()),
                    A = parseInt(st.nextToken()) - 1, B = parseInt(st.nextToken()) - 1,
                    C = parseInt(st.nextToken()) - 1;
            TreeSet<Integer> lAdy[] = new TreeSet[N];
            for (int i = 0; i < N; i++)
                lAdy[i] = new TreeSet<>();
            long[] arr = new long[M];
            long[] sums = new long[M + 1];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < M; i++) {
                StringTokenizer st1 = new StringTokenizer(in.readLine());
                arr[i] = parseInt(st.nextToken());
                int u = parseInt(st1.nextToken()) - 1;
                int v = parseInt(st1.nextToken()) - 1;
                lAdy[u].add(v);
                lAdy[v].add(u);
            }
            Arrays.sort(arr);
            for (int i = 0; i < M; i++) {
                sums[i + 1] = sums[i];
                sums[i + 1] += arr[i];
            }
            int[] toA = f(N, lAdy, A);
            int[] toB = f(N, lAdy, B);
            int[] toC = f(N, lAdy, C);
            long min = Long.MAX_VALUE;
            for (int p = 0; p < N; p++) {
                if (toB[p] + toA[p] + toC[p] <= M) {
                    long sum = sums[toB[p]] + sums[toB[p] + toA[p] + toC[p]];
                    min = Math.min(min, sum);
                }
            }
            System.out.println(min);
        }
    }

    static int[] f(int N, TreeSet<Integer> lAdy[], int u) {
        int[] arr = new int[N];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[u] = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(u);
        for (; !queue.isEmpty(); ) {
            u = queue.removeFirst();
            for (int v : lAdy[u]) {
                if (arr[v] == Integer.MAX_VALUE) {
                    queue.add(v);
                    arr[v] = arr[u] + 1;
                }
            }
        }
        return arr;
    }
}
