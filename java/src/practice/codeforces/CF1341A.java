package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1341/A>
 * @category math
 * @date 8/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1341A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), A = parseInt(st.nextToken()),
                    B = parseInt(st.nextToken()), C = parseInt(st.nextToken()),
                    D = parseInt(st.nextToken());
            boolean ws = false;
            for (int i = C - D; i <= C + D; i++) {
                int a = i / N, b = i / N + (i % N == 0 ? 0 : 1);
                if (a >= A - B && a <= A + B && b >= A - B && b <= A + B)
                    ws = true;
            }
            System.out.println(ws ? "Yes" : "No");
        }
    }
}
