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

public class CF59A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int a = 0, b = 0;
            for (int i = 0; i < ln.length(); i++)
                if (Character.isLowerCase(ln.charAt(i)))
                    a++;
                else b++;
            if (a >= b)
                System.out.println(ln.toLowerCase());
            else
                System.out.println(ln.toUpperCase());
        }
    }
}
