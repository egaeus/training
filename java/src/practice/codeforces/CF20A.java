package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/20/A>
 * @category strings
 * @date 3/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF20A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            ln = ln.replaceAll("[/]+", "/");
            if (ln.charAt(ln.length() - 1) == '/' && ln.length() > 1)
                ln = ln.substring(0, ln.length() - 1);
            System.out.println(ln);
        }
    }
}
