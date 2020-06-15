package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Not sended
 * @url <https://codeforces.com/problemset/problem/486/A>
 * @category ?
 * @date 27/05/2020
 **/

import java.io.*;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF486A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            long N = Long.parseLong(ln);
            BigInteger v = BigInteger.valueOf(N / 2).multiply(BigInteger.valueOf(N / 2 + 1));
            v = v.subtract(BigInteger.valueOf(N / 2 + N % 2).pow(2));
            System.out.println(v);
        }
    }
}
