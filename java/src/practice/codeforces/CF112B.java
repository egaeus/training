package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/112/B>
 * @category implementation
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF112B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), X = parseInt(st.nextToken()) - 1, Y = parseInt(st.nextToken()) - 1;
            int x1 = N / 2 - 1, y1 = N / 2 - 1;
            int[][] pts = new int[][]{{x1, y1}, {x1 + 1, y1}, {x1, y1 + 1}, {x1 + 1, y1 + 1}};
            boolean ws = false;
            for (int[] a : pts) {
                if (a[0] == X && a[1] == Y)
                    ws = true;
            }
            System.out.println(ws ? "NO" : "YES");
        }
    }
}
