package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/977/B>
 * @category implementation
 * @date 5/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF977B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            char[] str = in.readLine().toCharArray();
            int max = 0;
            String result = "";
            for (int i = 0; i < 26; i++)
                for (int j = 0; j < 26; j++) {
                    int s = 0;
                    for (int k = 0; k < N - 1; k++) {
                        if (str[k] - 'A' == i && str[k + 1] - 'A' == j)
                            s++;
                    }
                    if (s > max) {
                        max = s;
                        result = (char) (i + 'A') + "" + (char) (j + 'A');
                    }
                }
            System.out.println(result);
        }
    }
}
