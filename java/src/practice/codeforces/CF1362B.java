package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1362/B>
 * @category implementation, bitwise
 * @date 4/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1362B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = parseInt(st.nextToken());
            Arrays.sort(arr);
            if (arr.length == 1)
                System.out.println(-1);
            else if (arr.length == 2 && arr[0] == 0)
                System.out.println(arr[1]);
            else {
                int result = -1;
                for (int test = 1; test < 1<<10 && result == -1; test++) {
                    boolean[] ws = new boolean[1024];
                    for (int j = 0; j < N; j++)
                        ws[arr[j]] = true;
                    boolean sol = true;
                    for (int j = 0; j < N; j++)
                        if (!ws[test ^ arr[j]])
                            sol = false;
                        else
                            ws[test ^ arr[j]] = false;
                    if (sol) result = test;
                }
                System.out.println(result);
            }
        }
    }
}
