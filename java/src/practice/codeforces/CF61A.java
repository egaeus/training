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

public class CF61A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            char[] a = ln.toCharArray();
            char[] b = in.readLine().toCharArray();
            for (int i = 0; i < a.length; i++)
                if (a[i] != b[i]) b[i] = '1';
                else b[i] = '0';
            System.out.println(new String(b));
        }
    }
}
