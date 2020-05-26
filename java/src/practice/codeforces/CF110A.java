package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/110/A>
 * @category strings
 * @date 26/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF110A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            char[] a = ln.toCharArray();
            int c = 0;
            for(int i=0;i<a.length;i++)
                if(a[i]=='4'||a[i]=='7')
                    c++;
            System.out.println((c+"").matches("[74]+")?"YES":"NO");
        }
    }
}
