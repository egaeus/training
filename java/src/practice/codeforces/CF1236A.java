package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1236/A>
 * @category greedy
 * @date 17/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1236A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0, T = parseInt(in.readLine()); t++ < T; ) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int A = parseInt(st.nextToken()), B = parseInt(st.nextToken()), C = parseInt(st.nextToken());
            int S = Math.min(C/2, B);
            B-=S;
            int R = Math.min(B/2, A);
            System.out.println((R+R*2+S+S*2));
        }
    }
}
