package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/118/B>
 * @category implementation
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF118B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            int spaces = N * 2;
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j < spaces; j++)
                    sb.append(" ");
                for (int j = 0; j <= i; j++)
                    sb.append(j).append(i > 0 ? " " : "");
                for (int j = i - 1; j >= 0; j--)
                    sb.append(j).append(j > 0 ? " " : "");
                sb.append("\n");
                spaces -= 2;
            }
            spaces = 2;
            for (int i = N - 1; i>=0; i--) {
                for (int j = 0; j < spaces; j++)
                    sb.append(" ");
                for (int j = 0; j <= i; j++)
                    sb.append(j).append(i > 0 ? " " : "");
                for (int j = i - 1; j >= 0; j--)
                    sb.append(j).append(j > 0 ? " " : "");
                sb.append("\n");
                spaces += 2;
            }
            System.out.print(new String(sb));
        }
    }
}
