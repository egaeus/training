package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/116/A>
 * @category implementation
 * @date 26/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF116A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int N = parseInt(ln);
            int c = 0;
            int max = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                c -= parseInt(st.nextToken());
                c += parseInt(st.nextToken());
                max = Math.max(max, c);
            }
            System.out.println(max);
        }
    }
}
