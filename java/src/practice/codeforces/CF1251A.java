package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1251/A>
 * @category implementation
 * @date 24/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class CF1251A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int Q = parseInt(in.readLine()), q = 0; q++ < Q; ) {
            char[] a = in.readLine().toCharArray();
            boolean[] A = new boolean[26];
            int c = 1;
            for (int i = 1; i < a.length; i++) {

                if (a[i] == a[i - 1]) c++;
                else {
                    if (c % 2 == 1) {
                        A[a[i - 1] - 'a'] = true;

                    }
                    c = 1;
                }
            }
            if (c % 2 == 1) A[a[a.length - 1] - 'a'] = true;
            String s = "";
            for (int i = 0; i < 26; i++)
                if (A[i]) s += (char) (i + 'a');
            System.out.println(s);
        }
    }
}
