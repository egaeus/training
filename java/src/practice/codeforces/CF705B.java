package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/705/B>
 * @category implementation
 * @date 5/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF705B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            StringBuilder sb = new StringBuilder();
            int N = parseInt(st.nextToken());
            int s = 0;
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                s += parseInt(st.nextToken()) - 1;
                if (s % 2 == 0)
                    sb.append("2");
                else
                    sb.append("1");
                sb.append("\n");
            }
            System.out.print(new String(sb));
        }
    }
}
