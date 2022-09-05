package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1355/C>
 * @category implementation
 * @date 20/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1355C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int A = parseInt(st.nextToken()), B = parseInt(st.nextToken()),
                    C = parseInt(st.nextToken()), D = parseInt(st.nextToken());
            long[] Q = new long[B + C + 1];
            int[] open = new int[B + C + 1];
            int[] close = new int[B + C + 1];
            for (int i = A; i <= B; i++) {
                open[i + B]++;
                close[i + C]++;
            }
            for (int i = 1; i < Q.length; i++)
                Q[i] += Q[i - 1] + open[i] - close[i - 1];
            for (int i = Q.length - 2; i >= 0; i--)
                Q[i] += Q[i + 1];
            long result = 0;
            for (int i = C; i <= D; i++)
                if (i + 1 < Q.length)
                    result += Q[i+1];
            System.out.println(result);
        }
    }
}
