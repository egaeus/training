package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/41/A>
 * @category strings
 * @date 26/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF41A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            String a = in.readLine();
            boolean ws = a.length()==ln.length();
            for(int i=0;i<a.length() && ws;i++)
                ws = a.charAt(i)==ln.charAt(a.length()-i-1);
            System.out.println(ws?"YES":"NO");
        }
    }
}
