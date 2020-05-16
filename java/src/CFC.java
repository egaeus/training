/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1353/C
 * @category math
 * @date 14/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class CFC {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            long N = parseInt(in.readLine()) / 2;
            long result = 4 * ((N * (N + 1)) / 2);
            for (long i = N; i > 0; i--) {
                long from = i + N;
                long to = from - N;
                result += 4 * ((from * (from + 1)) / 2 - (to * (to + 1)) / 2);
            }
            System.out.println(2*(result/3));
        }
    }
}
