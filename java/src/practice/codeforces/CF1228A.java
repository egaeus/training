package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1228/A>
 * @category adhoc
 * @date 30/09/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1228A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            int a = parseInt(st.nextToken()), b = parseInt(st.nextToken());
            boolean ws = false;
            for (int i = a; i <= b; i++)
                if (check(i)) {
                    System.out.println(i);
                    ws = true;
                    break;
                }
            if (!ws) System.out.println(-1);
        }
    }

    private static boolean check(int a) {
        boolean[] v = new boolean[10];
        for (; a > 0; a /= 10)
            if (v[a % 10]) return false;
            else v[a % 10] = true;
        return true;
    }
}
