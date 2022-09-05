package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/41/B>
 * @category implementation
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF41B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            long B = parseInt(st.nextToken());
            long s = B;
            long[] arr = new long[N];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = parseInt(st.nextToken());
            }
            for (int i = 0; i < N; i++)
                for (int j = i + 1; j < N; j++) {
                    s = Math.max(s, (B / arr[i]) * arr[j] + B % arr[i]);
                }
            System.out.println(s);
        }
    }
}
