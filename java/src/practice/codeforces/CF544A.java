package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/544/A>
 * @category implementation
 * @date 3/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF544A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            char[] a = in.readLine().toCharArray();
            boolean[] chars = new boolean[26];
            int q = 0;
            for (char A : a) {
                if (!chars[A - 'a']) q++;
                chars[A - 'a'] = true;
            }
            if (q >= N) {
                System.out.print("YES");
                for (int i = 0; i < a.length; i++)
                    if (chars[a[i] - 'a'] && N > 0) {
                        System.out.println();
                        System.out.print(a[i]);
                        chars[a[i] - 'a'] = false;
                        N--;
                    } else
                        System.out.print(a[i]);
                System.out.println();
            } else
                System.out.println("NO");
        }
    }
}
