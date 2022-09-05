package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/276/B>
 * @category implementation
 * @date 10/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF276B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            char[] a = ln.toCharArray();
            int[] q = new int[26];
            for (char b : a)
                q[b - 'a']++;
            int s = 0;
            for (int i = 0; i < 26; i++)
                s += q[i] % 2;
            if(s==0) System.out.println("First");
            else {
                s--;
                if(s%2==0) System.out.println("First");
                else System.out.println("Second");
            }
        }
    }
}
