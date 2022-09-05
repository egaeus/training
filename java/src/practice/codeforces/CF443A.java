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

public class CF443A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            String a = ln.replaceAll("[^a-z]", "");
            TreeSet<Character> set = new TreeSet<>();
            for(char b:a.toCharArray())
                set.add(b);
            System.out.println(set.size());

        }
    }
}
