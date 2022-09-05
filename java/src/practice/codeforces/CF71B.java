package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/71/B>
 * @category implementation
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF71B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken()), T = parseInt(st.nextToken());
            int[] result = new int[N];
            double v = T * N * K / 100.;
            for (int i = 0; i < N; i++) {
                if (v - K >= 0) {
                    result[i] = K;
                    v -= K;
                } else if (v == 0)
                    result[i] = 0;
                else {
                    result[i] = (int)Math.floor(v);
                    v = 0;
                }
            }
            System.out.println(IntStream.of(result).mapToObj(noName -> noName + "").collect(Collectors.joining(" ")));
        }
    }
}
