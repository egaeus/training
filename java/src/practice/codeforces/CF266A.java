package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/266/A>
 * @category implementation
 * @date 26/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF266A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int N = parseInt(ln);
            char[] a = in.readLine().toCharArray();
            int b = 1;
            int c = 0;
            for (int i = 1; i < N; i++) {
                if (a[i] == a[i - 1]) b++;
                else {
                    c += b - 1;
                    b = 1;
                }
            }
            c += b - 1;
            System.out.println(c);
        }
    }
}
