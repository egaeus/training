package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/750/A
 * @category adhoc
 * @date 5/09/2022
 **/

import static java.lang.Integer.*;
import java.io.*;
import java.util.*;

public class CF750A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), K = 240 - parseInt(st.nextToken());
            int res = 0;
            while((res + 1) * 5 <= K && res < N) {
                res++;
                K -= res * 5;
            }
            System.out.println(res);
        }
    }
}
