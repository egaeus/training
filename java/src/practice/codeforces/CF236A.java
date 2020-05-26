package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/236/A>
 * @category strings
 * @date 26/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF236A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            TreeSet<Character> set = new TreeSet<>();
            for (int i = 0; i < ln.length(); i++)
                set.add(ln.charAt(i));
            System.out.println(set.size()%2==0?"CHAT WITH HER!":"IGNORE HIM!");
        }
    }
}
