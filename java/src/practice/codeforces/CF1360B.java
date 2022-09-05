package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1360/B>
 * @category sort
 * @date 24/05/2020
 **/


import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1360B {

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = parseInt(st.nextToken());
            Arrays.sort(arr);
            int s = 1000000000;
            for (int i = 1; i < N; i++)
                s = Math.min(s, arr[i] - arr[i - 1]);
            System.out.println(s);
        }
    }
}
