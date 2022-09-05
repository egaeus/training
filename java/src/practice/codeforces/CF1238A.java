package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1238/A>
 * @category math
 * @date 09/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Long.parseLong;

public class CF1238A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (long Q=parseLong(in.readLine()), q=0; q++<Q; ) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long A=parseLong(st.nextToken()), B=parseLong(st.nextToken());
            System.out.println(A-B>1?"YES":"NO");
        }
    }
}
