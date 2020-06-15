package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/344/B>
 * @category math
 * @date 9/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF344B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int Va = parseInt(st.nextToken()), Vb = parseInt(st.nextToken()), Vc = parseInt(st.nextToken());
            int sa, sb, sc;
            if(Vc-Vb+Va>=0&&(Vc-Vb+Va)%2==0) {
                sc = (Vc-Vb+Va)/2;
                sb = Vc-sc;
                sa = Vb-sb;
                if(sa>=0&&sb>=0&&sc>=0)
                    System.out.println(sa+" "+sb+" "+sc);
                else
                    System.out.println("Impossible");
            }
            else
                System.out.println("Impossible");
        }
    }
}
