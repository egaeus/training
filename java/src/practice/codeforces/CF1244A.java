package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1244/A>
 * @category math
 * @date 15/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1244A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int T = parseInt(in.readLine()), t = 0; t++ < T; ) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int A = parseInt(st.nextToken()),
                    B = parseInt(st.nextToken()),
                    C = parseInt(st.nextToken()),
                    D = parseInt(st.nextToken()),
                    K = parseInt(st.nextToken());
            int x = (int) Math.ceil(1. * A / C),
                    y = (int) Math.ceil(1. * B / D);
            if(x+y<=K)
                System.out.println(x+" "+y);
            else
                System.out.println(-1);
        }
    }
}
