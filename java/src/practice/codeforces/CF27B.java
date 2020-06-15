package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/27/B>
 * @category implementation
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF27B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            int[] arr = new int[N];
            int[][] input = new int[N][N];
            for (int i = 0; i < (N * (N - 1)) / 2 - 1; i++) {
                st = new StringTokenizer(in.readLine());
                int u = parseInt(st.nextToken()) - 1, v = parseInt(st.nextToken()) - 1;
                arr[u]++;
                arr[v]++;
                input[u][v] = input[v][u] = u;
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < N; i++)
                if (arr[i] != N - 1)
                    list.add(i);
            for (int i = 0; i < N; i++) {
                if (i != list.get(0) && i != list.get(1)) {
                    int a = list.get(0), b = list.get(1);
                    if (input[b][i] == b && input[a][i] == i) {
                        list.remove(0);
                        list.add(a);
                        break;
                    }
                }
            }
            System.out.println(list.stream().limit(2).map(noName -> (noName + 1) + "").collect(Collectors.joining(" ")));
        }
    }
}
