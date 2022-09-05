package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/608/B>
 * @category two pointers
 * @date 6/06/2020
 **/

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF608B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            char[] A = ln.toCharArray();
            char[] B = in.readLine().toCharArray();
            long[] ones = new long[B.length];
            long[] zeros = new long[B.length];
            for (int i = 0; i < B.length; i++) {
                ones[i] = i > 0 ? ones[i - 1] : 0;
                zeros[i] = i > 0 ? zeros[i - 1] : 0;
                if (B[i] == '0')
                    zeros[i]++;
                else
                    ones[i]++;
            }
            long s = 0;
            for (int i = 0; i < A.length; i++) {
                int from = i, to = B.length - A.length + i;
                if (A[i] == '0')
                    s += ones[to] - (from > 0 ? ones[from - 1] : 0);
                else
                    s += zeros[to] - (from > 0 ? zeros[from - 1] : 0);
            }
            System.out.println(s);
        }
    }
}
