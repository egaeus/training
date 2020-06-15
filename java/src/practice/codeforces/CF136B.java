package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/136/B>
 * @category implementation
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF136B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int a = parseInt(st.nextToken()), c = parseInt(st.nextToken());
            int N = Math.max(Integer.toString(a, 3).length(), Integer.toString(c, 3).length());
            char[] A = fill(Integer.toString(a, 3), N).toCharArray(), C = fill(Integer.toString(c, 3), N).toCharArray();
            char[] B = new char[N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < 3 && B[i] == '\0'; j++)
                    if ((A[i] - '0' + j) % 3 == (C[i] - '0'))
                        B[i] = (char) (j + '0');
            System.out.println(parseInt(new String(B), 3));
        }
    }

    static String fill(String a, int s) {
        while (a.length() < s)
            a = "0" + a;
        return a;
    }
}
