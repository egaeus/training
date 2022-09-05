package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Not sended
 * @url <https://codeforces.com/problemset/problem/>
 * @category ?
 * @date 27/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF734A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int N = parseInt(ln);
            char[] a = in.readLine().toCharArray();
            int A = 0, D = 0;
            for (char b : a)
                if (b == 'A') A++;
                else D++;
            if (A > D) System.out.println("Anton");
            else if (D > A) System.out.println("Danik");
            else System.out.println("Friendship");
        }
    }
}
