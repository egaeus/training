package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1348/A
 * @category math
 * @date 01/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class CF1348A {

    static long[] pows;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for(int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            int p = 2;
            int res = 0;
            for(int i = 0; i < N/2 - 1; i++, p*=2)
                res += p;
            for(int i = 0; i < N/2; i++, p*=2)
                res -= p;
            res += p;
            System.out.println(res);
        }
    }
}
