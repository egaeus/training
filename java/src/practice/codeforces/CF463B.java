package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/463/B>
 * @category implementation
 * @date 9/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF463B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            int E = 0;
            int p = parseInt(st.nextToken());
            int last = p;
            for (int i = 0; i < N - 1; i++) {
                int v = parseInt(st.nextToken());
                E += last - v;
                if (E < 0) {
                    p += -E;
                    E = 0;
                }
                last = v;
            }
            System.out.println(p);
        }
    }
}
