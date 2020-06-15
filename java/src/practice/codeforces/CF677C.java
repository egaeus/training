package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/677/C>
 * @category bitwise
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF677C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] q = new int[7];
        q[0] = 1;
        for (int i = 1; i < q.length; i++) {
            for (int k = 0; k < (1 << i); k++)
                for (int j = 0; j < (1 << i); j++)
                    if ((k & j) == 0)
                        q[i]++;
        }
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            char[] s = ln.toCharArray();
            int N, a[] = new int[N = s.length];
            for (int i = 0; i < N; i++)
                if (Character.isDigit(s[i]))
                    a[i] = s[i] - '0';
                else if (s[i] == '-')
                    a[i] = 62;
                else if (s[i] == '_')
                    a[i] = 63;
                else if (Character.isLowerCase(s[i]))
                    a[i] = 36 + s[i] - 'a';
                else a[i] = 10 + s[i] - 'A';
            long multiplication = 1;
            for (int i = 0; i < N; i++) {
                multiplication = (q[(6 - bitCount(a[i]))] * multiplication) % 1000000007;
            }
            System.out.println(multiplication);
        }
    }
}
