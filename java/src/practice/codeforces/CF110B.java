package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/110/B>
 * @category implementation
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF110B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            char[] result = new char[N];
            for (int i = 0; i < 4; i++)
                for (int j = 0; i + 4 * j < N; j++)
                    result[i + 4 * j] = (char) (i + 'a');
            System.out.println(new String(result));
        }
    }
}
