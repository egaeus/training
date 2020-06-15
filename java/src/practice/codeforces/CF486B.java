package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/486/B>
 * @category implementation
 * @date 6/06/2020
 **/

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF486B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            int[] rows = new int[N];
            int[] cols = new int[M];
            int[][] mat = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < M; j++) {
                    int v = parseInt(st.nextToken());
                    rows[i] += v;
                    cols[j] += v;
                    mat[i][j] = v;
                }
            }
            int[][] solution = new int[N][M];
            boolean[] row = new boolean[N];
            boolean[] col = new boolean[M];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++) {
                    if (rows[i] == M && cols[j] == N) {
                        solution[i][j] = 1;
                        row[i] = true;
                        col[j] = true;
                    }
                }
            boolean ws = true;
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++) {
                    if (mat[i][j] == 1 && !row[i] && !col[j])
                        ws = false;
                    if (mat[i][j] == 0 && (row[i] || col[j]))
                        ws = false;
                }
            if (ws) {
                System.out.println("YES");
                for (int[] a : solution)
                    System.out.println(IntStream.of(a).mapToObj(c -> c + "").collect(Collectors.joining(" ")));
            } else System.out.println("NO");
        }
    }
}
