package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @judge https://codeforces.com/problemset/problem/996/A
 * @category adhoc
 * @date 5/09/2022
 **/

import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class CF996A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] coins = new int[]{100, 20, 10, 5, 1};
        for(String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            int solution = 0;
            for(int c: coins) {
                int sum = N / c;
                solution += sum;
                N -= sum * c;
            }
            System.out.println(solution);
        }
    }
}
