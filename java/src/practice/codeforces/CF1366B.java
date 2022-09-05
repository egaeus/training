package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1366/B>
 * @category implementation
 * @date 11/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1366B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), X = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            int[] range = new int[]{X, X};
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int a = parseInt(st.nextToken()), b = parseInt(st.nextToken());
                if ((a >= range[0] && a <= range[1]) ||
                        (b >= range[0] && b <= range[1]) ||
                        (range[0] >= a && range[0] <= b) ||
                        (range[1] >= a && range[1] <= b)) {
                    range[0] = Math.min(a, range[0]);
                    range[1] = Math.max(b, range[1]);
                }
            }
            System.out.println(range[1]-range[0]+1);
        }
    }
}
