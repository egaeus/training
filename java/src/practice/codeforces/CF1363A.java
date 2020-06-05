package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1363/A>
 * @category implementation
 * @date 31/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1363A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), X = parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            int odd = 0, even = 0;
            for (int i = 0; i < N; i++)
                if (parseInt(st.nextToken()) % 2 == 0)
                    even++;
                else
                    odd++;
            boolean ws = false;
            for (int i = 0; i <= X && i <= odd; i++)
                if (i % 2 != 0 && X - i <= even)
                    ws = true;
            System.out.println(ws ? "YES" : "NO");
        }
    }
}
