package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1030/A
 * @category adhoc
 * @date 27/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1030A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int N = parseInt(ln);
            int c = 0;
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                c += parseInt(st.nextToken());
            if (c > 0)
                System.out.println("HARD");
            else System.out.println("EASY");
        }
    }
}
