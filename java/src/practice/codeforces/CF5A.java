package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/5/A>
 * @category implementation
 * @date 3/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF5A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> names = new TreeSet<>();
        int s = 0;
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            if (ln.startsWith("+"))
                names.add(ln.substring(1));
            else if (ln.startsWith("-"))
                names.remove(ln.substring(1));
            else {
                StringTokenizer st = new StringTokenizer(ln, ":");
                st.nextToken();
                if(st.hasMoreTokens())
                    s += st.nextToken().length() * names.size();
            }
        }
        System.out.println(s);
    }
}
