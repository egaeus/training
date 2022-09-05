package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1350/A>
 * @category math
 * @date 12/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1350A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            int D = f(N);
            while (D > 2) {
                N += D;
                D = f(N);
                K--;
            }
            System.out.println(N + 2 * K);
        }
    }

    static int f(int a) {
        for (int i = 2; i <= Math.sqrt(a); i++)
            if (a % i == 0)
                return i;
        return a;
    }
}
