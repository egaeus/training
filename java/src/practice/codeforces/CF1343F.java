package practice.codeforces;

/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict
 * @url https://codeforces.com/problemset/problem/1343/F
 * @category graph
 * @date 11/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class CF1343F {
    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t++ < T; ) {
            int N = parseInt(in.readLine());
            int[][] mAdy = new int[N * 2 + 2][N * 2 + 2];
            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                int K = parseInt(st.nextToken());
                int[] arr = new int[K];
                for (int j = 0; j < K; j++)
                    arr[j] = parseInt(st.nextToken()) - 1;
                for (int j = 0; j < K; j++)
                    for (int k = j + 1; k < K; k++)
                        mAdy[arr[k]][N + arr[j]] = mAdy[arr[j]][N + arr[k]] = 1;
            }
            ArrayList<Integer>[] lAdy = new ArrayList[2 * N + 2];
            for (int i = 0; i < N; i++) {
                lAdy[i] = new ArrayList<>();
                mAdy[2 * N][i] = 1;
                mAdy[N + i][2 * N + 1] = 1;
            }
            for (int i = 0; i < lAdy.length; i++) {
                lAdy[i] = new ArrayList<>();
                for (int j = 0; j < lAdy.length; j++)
                    if (mAdy[i][j] > 0)
                        lAdy[i].add(j);
            }
            int[][] r = maxFlow(mAdy, 2 * N, 2 * N + 1, lAdy.length, lAdy);
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (r[i][j+N] == 1)
                        System.out.println((i + 1) + " " + (j + 1));
            System.out.println(".........");
        }
    }

    static int[][] maxFlow(int[][] cap, int s, int t, int N, ArrayList<Integer>[] lAdy) {
        int flow = 0, r[][] = new int[N][N];
        for (int f; (f = maxFlow(cap, s, t, N, r, lAdy)) > 0; flow += f) ;
        return r;
    }

    static int maxFlow(int[][] cap, int s, int t, int N, int[][] r, ArrayList<Integer> lAdy[]) {
        LinkedList<Integer> cola = new LinkedList<Integer>();
        boolean[] visitados = new boolean[N];
        int[] ants = new int[N];
        int[] val = new int[N];
        val[s] = MAX_VALUE;
        visitados[s] = true;
        cola.add(s);
        Arrays.fill(ants, -1);
        for (; !cola.isEmpty(); ) {
            int u = cola.pollFirst();
            for (int v : lAdy[u])
                if (!visitados[v] && cap[u][v] - r[u][v] > 0) {
                    cola.add(v);
                    visitados[v] = true;
                    val[v] = min(val[u], cap[u][v] - r[u][v]);
                    ants[v] = u;
                }
        }
        int f = val[t];
        if (f > 0)
            for (; ants[t] > -1; t = ants[t]) {
                r[ants[t]][t] += f;
                r[t][ants[t]] -= f;
            }
        return f;
    }
}
