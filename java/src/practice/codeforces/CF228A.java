package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Not sended
 * @url <https://codeforces.com/problemset/problem/>
 * @category ?
 * @date 27/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF228A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            TreeSet<Integer> set = new TreeSet<>();
            int s = 0;
            for (int i = 0; i < 4; i++) {
                int A = parseInt(st.nextToken());
                if (set.contains(A)) s++;
                set.add(A);
            }
            System.out.println(s);
        }
    }
}
