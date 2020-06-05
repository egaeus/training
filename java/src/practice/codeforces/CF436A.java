package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/436/A>
 * @category implementation
 * @date 3/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF436A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), S = parseInt(st.nextToken());
            int max = -1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                int A = parseInt(st.nextToken()), B = parseInt(st.nextToken());
                if (A < S || (A == S && B == 0))
                    max = Math.max(max, B == 0 ? 0 : 100 - B);
            }
            System.out.println(max);
        }
    }
}
