package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/608/A>
 * @category implementation
 * @date 3/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF608A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), S = parseInt(st.nextToken());
            int[] maxs = new int[S + 1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                int f = parseInt(st.nextToken()), t = parseInt(st.nextToken());
                maxs[f] = Math.max(maxs[f], t);
            }
            int t = 0;
            for (int i = S; i >= 0; i--)
                if (t > maxs[i]) t++;
                else t = maxs[i] + 1;
            System.out.println(t-1);
        }
    }
}
