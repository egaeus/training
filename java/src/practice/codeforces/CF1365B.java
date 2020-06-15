package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1365/B>
 * @category implementation
 * @date 7/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1365B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            int c = 0;
            for (int i = 0; i < N; i++)
                c += parseInt(st.nextToken());
            boolean ws = true;
            for (int i = 1; i < N; i++)
                if (arr[i] < arr[i - 1])
                    ws = false;
            System.out.println(ws || (c > 0 && c < N) ? "Yes" : "No");
        }
    }
}
