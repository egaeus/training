package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/546/A>
 * @category implementation
 * @date 26/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF546A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int K = parseInt(st.nextToken()), N = parseInt(st.nextToken()), W = parseInt(st.nextToken());
            long cost = 0;
            for (int i = 0; i < W; i++)
                cost += (i + 1) * K;
            System.out.println(Math.max(0,cost - N));
        }
    }
}
