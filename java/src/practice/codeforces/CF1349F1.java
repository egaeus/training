package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Not sended
 * @url <https://codeforces.com/problemset/problem/1349/F1>
 * @category dp
 * @date 27/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1349F1 {
    static int N;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            N = parseInt(ln);
            System.out.println(f(1, 1));
        }
    }

    static long f(int p, int k) {
        if(p==N) {

        }
        return f(p + 1, k + 1) + k * f(p + 1, k);
    }
}
