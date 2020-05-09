package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1352/C
 * @category math
 * @date 09/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1352C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            long q = K / (N - 1);
            System.out.println(q * N + K % (N - 1) - (K % (N -1) == 0 ? 1 : 0));
        }
    }
}
