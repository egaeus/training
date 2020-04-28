package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1244/B
 * @category implementation
 * @date 15/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class CF1244B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int T = parseInt(in.readLine()), t = 0; t++ < T; ) {
            int N = parseInt(in.readLine());
            str = in.readLine().toCharArray();
            int max = f();
            for(int i=0;i<str.length/2;i++) {
                char a = str[i];
                str[i] = str[str.length-1-i];
                str[str.length-1-i] = a;
            }
            max = Math.max(max, f());
            System.out.println(max);
        }
    }

    static char[] str;

    static int f() {
        int one = -1;
        for(int i=0;i<str.length;i++)
            if(str[i]=='1')
                one = i;
        return Math.max(2*(one+1),str.length);
    }
}
