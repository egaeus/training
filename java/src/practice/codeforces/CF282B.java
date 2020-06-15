package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/282/B>
 * @category implementation
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF282B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            int[][] arr = new int[N][];
            int s = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                arr[i] = new int[]{parseInt(st.nextToken()), parseInt(st.nextToken())};
                if (s + arr[i][0] > 500) {
                    s -= arr[i][1];
                    sb.append("G");
                } else {
                    s += arr[i][0];
                    sb.append("A");
                }
            }
            if (s > 500 || s < -500)
                System.out.println(-1);
            else {
                System.out.println(new String(sb));
            }
        }
    }
}
