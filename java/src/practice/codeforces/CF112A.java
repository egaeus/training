package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/112/A>
 * @category strings
 * @date 26/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF112A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            String a = ln.toLowerCase();
            String b = in.readLine().toLowerCase();
            System.out.println(a.compareTo(b) < 0 ? -1 : a.compareTo(b) > 0 ? 1 : 0);
        }
    }
}
