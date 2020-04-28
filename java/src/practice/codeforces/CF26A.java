package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/26/A
 * @category math
 * @date 23/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class CF26A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            int N = parseInt(ln);
            int s = 0;
            for (int i = 0; i <= N; i++) {
                s += f(i) ? 1 : 0;
            }
            System.out.println(s);
        }
    }

    static boolean f(int a) {
        int div = 0, p = a;
        for (int i = 2; i <= Math.sqrt(a); i++)
            if (p % i == 0) {
                div++;
                for (; p % i == 0 && p > 1; p /= i) ;
            }
        if (p != 1) div++;
        return div == 2;
    }
}
