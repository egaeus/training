package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/898/B>
 * @category
 * @date 16/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class CF898B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            long N = parseInt(ln);
            long A = parseInt(in.readLine());
            long B = parseInt(in.readLine());

            long X = 0;
            long Y = -1;

            for (; N - A * X >= 0; X++)
                if ((N - A * X) % B == 0) {
                    Y = (N - A * X) / B;
                    break;
                }
            if (Y >= 0) {
                System.out.println("YES");
                System.out.println(X + " " + Y);
            } else
                System.out.println("NO");
        }
    }
}
