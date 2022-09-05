package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1360/D>
 * @category math
 * @date 24/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1360D {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            int max = 1;
            for (int i = 1; i <= Math.sqrt(N) && i <= K; i++)
                if (N % i == 0) {
                    max = Math.max(i, max);
                    if (N / i <= K)
                        max = Math.max(N / i, max);
                }
            System.out.println(N / max);
        }
    }
}
