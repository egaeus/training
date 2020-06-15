package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/544/B>
 * @category implemetation
 * @date 6/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF544B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            if (K <= (N*N) / 2 + (N*N) % 2) {
                System.out.println("YES");
                char[][] s = new char[N][N];
                for (char[] a : s) Arrays.fill(a, 'S');
                for (int i = 0; i < N; i++)
                    for (int j = 0; j < N; j++)
                        if (K > 0 && i % 2 == j % 2) {
                            K--;
                            s[i][j] = 'L';
                        }
                for(char[] a:s)
                    System.out.println(new String(a));
            } else
                System.out.println("NO");

        }
    }
}
