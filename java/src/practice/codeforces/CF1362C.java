package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1362/C>
 * @category math
 * @date 4/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1362C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            long N = Long.parseLong(in.readLine());
            long total = 0;
            while (N > 0) {
                long pot = 1, sum = 1;
                for (; pot * 2 <= N; pot *= 2) {
                    sum = 2 * sum + 1;
                }
                N -= pot;
                total += sum;
            }
            System.out.println(total);
        }
    }
}
