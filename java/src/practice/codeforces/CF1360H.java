package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1360/H>
 * @category implementation
 * @date 24/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1360H {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            long[] arr = new long[N + 2];
            for (int i = 0; i < N; i++)
                arr[i] = Long.parseLong(in.readLine(), 2);
            arr[N] = -1;
            arr[N + 1] = (1L << M);
            Arrays.sort(arr);
            long mid = ((1L << M) - N + 1) / 2;
            for (int i = 1; i < arr.length; i++) {
                long Q = arr[i] - arr[i - 1] - 1;
                if (mid > Q) {
                    mid -= Q;
                } else {
                    String s = Long.toBinaryString(arr[i - 1] + mid);
                    for (; s.length() < M; ) s = "0" + s;
                    System.out.println(s);
                    break;
                }
            }
        }
    }
}
