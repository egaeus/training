package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/50/B>
 * @category implementation
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF50B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            TreeMap<Character, Long> map = new TreeMap<>();
            char[] a = ln.toCharArray();
            for (char A : a) {
                Long v = map.get(A);
                if (v == null)
                    v = 0L;
                v++;
                map.put(A, v);
            }
            long s = 0;
            for (long A : map.values())
                s += A * A;
            System.out.println(s);
        }
    }
}
