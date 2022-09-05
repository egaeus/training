package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1130/A>
 * @category math
 * @date 3/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1130A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = parseInt(st.nextToken());
            boolean ws = false;
            for (int i = -1; i <= 1; i += 2) {
                int q = 0;
                for (int j = 0; j < N; j++)
                    if (arr[j] * i > 0)
                        q++;
                if (q >= N / 2 + N % 2) {
                    System.out.println(i);
                    ws = true;
                    break;
                }
            }
            if(!ws)
                System.out.println(0);
        }
    }
}
