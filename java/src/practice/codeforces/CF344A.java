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

public class CF344A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int N = parseInt(ln);
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = parseInt(in.readLine());
            int b = 0;
            int c = 0;
            for (int i = 0; i < N; i++)
                if (arr[i] != b) {
                    c++;
                    b = arr[i];
                }
            System.out.println(c);
        }
    }
}
