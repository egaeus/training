package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/266/B>
 * @category implementation
 * @date 26/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF266B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), T = parseInt(st.nextToken());
            char[] a = in.readLine().toCharArray();
            for (int i = 0; i < T; i++)
                for (int j = 0; j < N - 1; j++)
                    if (a[j] == 'B' && a[j + 1] == 'G') {
                        a[j] = 'G';
                        a[j + 1] = 'B';
                        j++;
                    }
            System.out.println(new String(a));
        }
    }
}
