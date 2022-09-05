package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1362/A>
 * @category math
 * @date 4/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1362A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken());
            long min = Math.min(A, B), max = Math.max(A, B);
            int q = 0;
            for (; max > min && max % 2 == 0; max /= 2) q++;
            if (max == min) {
                long s = q / 3 + (q % 3 == 0 ? 0 : 1);
                System.out.println(s);
            } else System.out.println(-1);
        }
    }
}
