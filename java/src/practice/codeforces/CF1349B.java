package practice.codeforces;

/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict W.A.
 * @url https://codeforces.com/problemset/problem/1349/B
 * @category arrays
 * @date 12/05/2020
 **/

import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1349B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(in.readLine());
            boolean ws = N == 1;
            boolean contains = false;
            for (int i = 0; i < N; i++) {
                arr[i] = parseInt(st.nextToken());
                if (arr[i] == K)
                    contains = true;
                if (i > 0 && Math.min(arr[i], arr[i - 1]) >= K && Math.max(arr[i], arr[i - 1]) >= Math.min(arr[i], arr[i - 1]))
                    ws = true;
                if (i > 2) {
                    int[] a = new int[]{arr[i - 2], arr[i - 1], arr[i]};
                    Arrays.sort(a);
                    if (a[1] >= K)
                        ws = true;
                }
            }
            if (ws && contains)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

}
