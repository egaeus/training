package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1328/B
 * @category math
 * @date 13/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1328B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            char[] solution = new char[(int) N];
            Arrays.fill(solution, 'a');
            long x = (long) Math.ceil((-1 + Math.sqrt(1 + 8 * K)) / 2);
            long floor = x - 1;
            solution[(int)N - (int) x - 1] = 'b';
            solution[(int)N - (int) (K - floor * (floor + 1) / 2)]='b';
            sb.append(new String(solution)).append("\n");
        }
        System.out.print(new String(sb));
    }
}
