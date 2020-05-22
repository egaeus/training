package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1234/A>
 * @category math
 * @date 01/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1234A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0, T = parseInt(in.readLine()); t++ < T; ) {
            int N = parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());
            int sum = 0;
            for (int i = 0; i < N; i++)
                sum += parseInt(st.nextToken());
            System.out.println(sum/N+Math.min(1, sum%N));
        }
    }
}
