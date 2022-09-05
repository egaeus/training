package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/448/A>
 * @category implementation
 * @date 3/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF448A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int A = parseInt(st.nextToken()) + parseInt(st.nextToken()) + parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            int B = parseInt(st.nextToken()) + parseInt(st.nextToken()) + parseInt(st.nextToken());
            int N = parseInt(in.readLine());
            System.out.println(A / 5 + (A % 5 == 0 ? 0 : 1) + B / 10 + (B % 10 == 0 ? 0 : 1) <= N ? "YES" : "NO");
        }
    }
}
