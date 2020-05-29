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

public class CF148A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int K = parseInt(ln),
                    L = parseInt(in.readLine()),
                    M = parseInt(in.readLine()),
                    N = parseInt(in.readLine()),
                    D = parseInt(in.readLine());
            int s = 0;
            for (int i = 1; i <= D; i++)
                if (i % K != 0 && i % L != 0 && i % M != 0 && i % N != 0)
                    s++;
            System.out.println(D-s);
        }
    }
}
