package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/339/B>
 * @category implementation
 * @date 9/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF339B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            int p = 0;
            long move = 0;
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < M; i++) {
                int v = parseInt(st.nextToken()) - 1;
                if (p <= v) move += v - p;
                else move += v + N - p;
                p = v;
            }
            System.out.println(move);
        }
    }
}
