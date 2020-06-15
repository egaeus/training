package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/677/B>
 * @category implementation
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF677B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            long H = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            long[] arr = new long[N];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = parseInt(st.nextToken());
            long s = 0;
            long result = 0;
            for (int i = 0; i < N; i++) {
                if (s + arr[i] <= H) {
                    s += arr[i];
                } else {
                    s = arr[i];
                    result++;
                }
                result += s / K;
                s = s % K;
            }
            if (s > 0)
                result++;
            System.out.println(result);
        }
    }
}
