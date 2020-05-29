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

public class CF271A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int N = parseInt(ln);
            for (int i = N + 1; ; i++) {
                boolean[] digits = new boolean[10];
                boolean ws = true;
                for (int q = i; q > 0; q /= 10) {
                    if (digits[q % 10]) ws = false;
                    digits[q % 10] = true;
                }
                if (ws) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
