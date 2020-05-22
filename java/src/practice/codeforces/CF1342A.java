package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1342/A
 * @category math
 * @date 27/04/2012
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1342A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t++ < T; ) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long X = parseInt(st.nextToken()), Y = parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            long A = parseInt(st.nextToken()), B = parseInt(st.nextToken());
            long min = Math.min(X, Y), max = Math.max(X, Y);
            long firstSolution = min * B + (max - min) * A;
            long secondSolution = min * A + max * A;
            System.out.println(Math.min(firstSolution, secondSolution));
        }
    }
}
