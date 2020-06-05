package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/548/A>
 * @category implementation
 * @date 3/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF548A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            char[] s = st.nextToken().toCharArray();
            int K = parseInt(in.readLine());
            if (s.length % K == 0) {
                char[][] arr = new char[K][s.length / K];
                for (int i = 0; i < s.length; i++)
                    arr[i / arr[0].length][i % arr[0].length] = s[i];
                boolean ws = true;
                for (char[] p : arr) {
                    boolean isP = true;
                    for (int i = 0; i < p.length / 2; i++)
                        isP &= p[i] == p[p.length - i - 1];
                    if (!isP)
                        ws = false;
                }
                if (ws) System.out.println("YES");
                else System.out.println("NO");
            } else System.out.println("NO");
        }
    }
}
