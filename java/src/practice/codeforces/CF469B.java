package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/469/B>
 * @category implementation
 * @date 9/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF469B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int P = parseInt(st.nextToken()), Q = parseInt(st.nextToken()),
                    L = parseInt(st.nextToken()), R = parseInt(st.nextToken());
            int[][] A = new int[P][2];
            int[][] B = new int[Q][2];
            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(in.readLine());
                A[i][0] = parseInt(st.nextToken());
                A[i][1] = parseInt(st.nextToken());
            }
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(in.readLine());
                B[i][0] = parseInt(st.nextToken());
                B[i][1] = parseInt(st.nextToken());
            }
            int s = 0;
            for (int i = L; i <= R; i++) {
                boolean ws = false;
                for (int q = 0; q < Q; q++) {
                    for (int p = 0; p < P; p++) {
                        int a = A[p][0], b = A[p][1], c = B[q][0] + i, d = B[q][1] + i;
                        if ((a <= c && c <= b) ||
                                (a <= d && d <= b) ||
                                (c <= a && a <= d) ||
                                (c <= b && b <= d))
                            ws = true;

                    }
                }
                if (ws)
                    s++;
            }
            System.out.println(s);
        }
    }
}
