package practice.codeforces;

/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1157/A>
 * @category implementation
 * @date Marzo, 2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

public class CF1157A {
    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(String ln;(ln=in.readLine())!=null;) {
            int N=parseInt(ln);
            S=new TreeSet<>();
            f(N);
            System.out.println(S.size());
        }
    }

    static TreeSet<Integer> S;

    static void f(int N) {
        S.add(N);
        N++;
        for(;N%10==0;N/=10);
        if(S.contains(N))return;
        f(N);
    }
}
