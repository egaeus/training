package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/485/B>
 * @category math
 * @date 9/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF485B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            long maxX = MIN_VALUE, maxY = MIN_VALUE, minX = MAX_VALUE, minY = MAX_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                int x = parseInt(st.nextToken()), y = parseInt(st.nextToken());
                maxX = Math.max(maxX, x);
                minX = Math.min(minX, x);
                maxY = Math.max(maxY, y);
                minY = Math.min(minY, y);
            }
            System.out.println(Math.max(maxX - minX, maxY - minY) * Math.max(maxX - minX, maxY - minY));
        }
    }
}
