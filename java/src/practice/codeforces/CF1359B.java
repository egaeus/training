package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1359/B>
 * @category implementation
 * @date 28/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1359B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken()),
                    A = parseInt(st.nextToken()), B = parseInt(st.nextToken());
            char[][] mat = new char[N][];
            int s = 0;
            for (int i = 0; i < N; i++) {
                mat[i] = in.readLine().toCharArray();
                char a = 'q';
                int q = 0;
                for (int j = 0; j < M; j++)
                    if (mat[i][j] != a) {
                        if(a=='.')
                            s += (q / 2) * (Math.min(A + A, B)) + (q % 2) * A;
                        q = 1;
                        a = mat[i][j];
                    } else q++;
                if (a == '.')
                    s += (q / 2) * (Math.min(A + A, B)) + (q % 2) * A;
            }
            System.out.println(s);
        }
    }
}
