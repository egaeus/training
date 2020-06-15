package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/534/B>
 * @category implementation
 * @date 6/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF534B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int V1 = parseInt(st.nextToken()), V2 = parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            int T = parseInt(st.nextToken()), D = parseInt(st.nextToken());
            int s = V1;
            for (int t = 1; t < T; t++) {
                V1 = Math.min(V1 + D, V2 + D * (T - t - 1));
                s += V1;
            }
            System.out.println(s);
        }
    }
}
