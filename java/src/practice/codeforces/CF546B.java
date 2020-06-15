package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/546/B>
 * @category greedy
 * @date 6/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF546B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            int[] arr = new int[N];
            boolean[] used = new boolean[2 * N + 1];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = parseInt(st.nextToken());
                used[arr[i]] = true;
            }
            Arrays.sort(arr);
            int s = 0;
            for (int i = 1, j = 0; i < N; i++) {
                j = Math.max(j, arr[i]);
                if (arr[i] == arr[i - 1]) {
                    for (; used[j]; j++) ;
                    used[j] = true;
                    s += j - arr[i];
                }
            }
            System.out.println(s);
        }
    }
}
