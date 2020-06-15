package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/281/B>
 * @category math
 * @date 10/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF281B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int X = parseInt(st.nextToken()), Y = parseInt(st.nextToken()), N = parseInt(st.nextToken());
            double A = 1. * X / Y;
            double min = Double.POSITIVE_INFINITY;
            int[] result = null;
            for (int i = 1; i <= N; i++) {
                int a = (int) Math.floor(A * i), b = (int) Math.ceil(A * i);
                double sa = 1. * a / i, sb = 1. * b / i;
                if (Math.abs(Math.abs(A - sa) - min) > 1e-15 && Math.abs(A - sa) < min) {
                    result = new int[]{a, i};
                    min = Math.abs(A - sa);
                }
                if (Math.abs(Math.abs(A - sb) - min) > 1e-15 && Math.abs(A - sb) < min) {
                    result = new int[]{b, i};
                    min = Math.abs(A - sb);
                }
            }
            System.out.println(result[0] + "/" + result[1]);
        }
    }
}
