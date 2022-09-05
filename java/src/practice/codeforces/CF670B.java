package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/670/B>
 * @category math
 * @date 5/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF670B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            long K = Long.parseLong(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = parseInt(st.nextToken());
            int k = (int) Math.floor((-1 + Math.sqrt(1 + 8 * K)) / 2.);
            if ((k * (k + 1L)) / 2 == K)
                System.out.println(arr[k - 1]);
            else
                System.out.println(arr[(int) (K - (k * (k + 1L)) / 2 - 1)]);
        }
    }
}
