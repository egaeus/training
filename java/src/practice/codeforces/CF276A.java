package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/276/A>
 * @category implementation
 * @date 3/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF276A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            long s = Long.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                long f = parseInt(st.nextToken()), t = parseInt(st.nextToken());
                if (t > K)
                    s = Math.max(s, f - (t - K));
                else s = Math.max(s, f);
            }
            System.out.println(s);
        }
    }
}
