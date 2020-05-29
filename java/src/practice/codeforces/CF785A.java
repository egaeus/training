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

public class CF785A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int N = parseInt(ln);
            int s = 0;
            for (int i = 0; i < N; i++) {
                String a = in.readLine();
                if (a.equals("Tetrahedron")) s += 4;
                if (a.equals("Cube")) s += 6;
                if (a.equals("Octahedron")) s += 8;
                if (a.equals("Dodecahedron")) s += 12;
                if (a.equals("Icosahedron")) s += 20;
            }
            System.out.println(s);
        }
    }
}
