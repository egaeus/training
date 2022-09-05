package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1365/A>
 * @category implementation
 * @date 7/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1365A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            int[][] mat = new int[N][M];
            boolean[] rows = new boolean[N];
            boolean[] cols = new boolean[M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < M; j++) {
                    mat[i][j] = parseInt(st.nextToken());
                    if (mat[i][j] == 1) {
                        rows[i] = true;
                        cols[j] = true;
                    }
                }
            }
            int r = 0, c = 0;
            for (int i = 0; i < N; i++)
                if (!rows[i]) r++;
            for (int i = 0; i < M; i++)
                if (!cols[i])
                    c++;
            System.out.println(Math.min(r, c) % 2 == 0 ? "Vivek" : "Ashish");
        }
    }
}
