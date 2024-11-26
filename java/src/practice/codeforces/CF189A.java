package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url implementation, math
 * @category
 * @date 5/09/2022
 **/

import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class CF189A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), A = parseInt(st.nextToken()), B = parseInt(st.nextToken()), C = parseInt(st.nextToken());
            int max = 0;
            for(int a = 0; a * A <= N; a++) {
                for (int b = 0; a * A + b * B <= N; b++) {
                    int v = N - a * A - b * B;
                    if (v % C == 0)
                        max = Math.max(max, a + b + v / C);
                }
            }
            System.out.println(max);
        }
    }
}
