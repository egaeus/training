package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/20/B>
 * @category math
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF20B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            long A = parseInt(st.nextToken()), B = parseInt(st.nextToken()), C = parseInt(st.nextToken());
            double s1 = (-B + Math.sqrt(B * B - 4 * A * C)) / (2 * A);
            double s2 = (-B - Math.sqrt(B * B - 4 * A * C)) / (2 * A);
            boolean have1 = B * B - 4 * A * C >= 0 && A != 0;
            boolean have2 = B * B - 4 * A * C >= 0 && A != 0;
            if (A == 0) {
                if (B == 0)
                    System.out.println(C == 0 ? -1 : 0);
                else {
                    System.out.println(1);
                    System.out.printf(Locale.US, "%.10f\n", -1. * C / B);
                }
            } else if (!have1 && !have2) {
                System.out.println(0);
            } else if (have1 && have2) {
                if (Math.abs(s1 - s2) <= 1e-10) {
                    System.out.println(1);
                    System.out.printf(Locale.US, "%.10f\n", s1);
                } else {
                    System.out.println(2);
                    System.out.printf(Locale.US, "%.10f\n", Math.min(s1, s2));
                    System.out.printf(Locale.US, "%.10f\n", Math.max(s1, s2));
                }
            } else if (have1) {
                System.out.println(1);
                System.out.printf(Locale.US, "%.10f\n", s1);
            } else {
                System.out.println(1);
                System.out.printf(Locale.US, "%.10f\n", s2);
            }
        }
    }
}
