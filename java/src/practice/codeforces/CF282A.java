package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/282/A>
 * @category implementation
 * @date 26/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF282A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int N = parseInt(ln);
            int X = 0;
            for(int i=0;i<N;i++) {
                ln = in.readLine();
                if(ln.equals("X++")) {
                    X++;
                }
                else if(ln.equals("++X")) {
                    X++;
                }else if(ln.equals("X--")) {
                    X--;
                }
                else if(ln.equals("--X")) {
                    X--;
                }
            }
            System.out.println(X);
        }
    }
}
