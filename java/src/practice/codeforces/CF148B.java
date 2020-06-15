package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/148/B>
 * @category implementation
 * @date 10/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF148B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int Vp = parseInt(ln), Vd = parseInt(in.readLine()),
                    t = parseInt(in.readLine()), f = parseInt(in.readLine()),
                    c = parseInt(in.readLine());
            double P = t * Vp, D = 0;
            int s = 0;
            while (P < c && Vd > Vp) {
                double T = (D - P) / (Vp - Vd), d = P + Vp * T;
                if (Math.abs(d - c) <= 1e-6)
                    break;
                if (d < c)
                    s++;
                P = d;
                P += Vp * (d / Vd);
                D = d - Vd * (d / Vd + f);
            }
            System.out.println(s);
        }
    }
}
