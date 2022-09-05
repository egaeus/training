package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1358/E>
 * @category implementation
 * @date 26/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1358E {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int N = parseInt(ln);
            long sum = 0, X;
            long[] arr = new long[N / 2 + N % 2];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N / 2 + N % 2; i++) {
                arr[i] = parseInt(st.nextToken());
                sum += arr[i];
            }
            X = parseInt(in.readLine());
            long[] search = new long[N - arr.length];
            for (int i = 0; i < search.length; i++) {
                search[i] = X - arr[i];
                if (i > 0)
                    search[i] += search[i - 1];
            }
            for (int i = 1; i < search.length; i++)
                search[i] = Math.min(search[i], search[i-1]);
            int K = X * search.length + sum > 0 ? N : -1;
            for (int i = 0; i < search.length; i++) {
                long v = sum + X * i + search[search.length - i - 1];
                if (v > 0 && sum + X * i > 0)
                    K = i + N / 2 + N % 2;
            }
            System.out.println(K);
        }
    }
}
