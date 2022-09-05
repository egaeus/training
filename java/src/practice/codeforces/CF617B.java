package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Not sended
 * @url <https://codeforces.com/problemset/problem/617/B>
 * @category ?
 * @date 5/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF617B {
    static int[] arr;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = parseInt(st.nextToken());
            mem = new long[N][2];
            for (long[] a : mem)
                Arrays.fill(a, -1);
            System.out.println(f(0, 0));
        }
    }

    static long mem[][];

    static long f(int p, int one) {
        if (p == arr.length)
            return 0;
        if (mem[p][one] >= 0)
            return mem[p][one];
        if (arr[p] == 1)
            return mem[p][one] = (one == 1 ? f(p + 1, 1) : f(p + 1, 1) + 1);
        return mem[p][one] = (f(p + 1, one) + (one == 1 ? f(p + 1, 0) : 0));
    }
}
