package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1341/B>
 * @category implementation
 * @date 8/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1341B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = parseInt(st.nextToken());
            }
            int[] peak = new int[N];
            for (int i = 1; i < N - 1; i++)
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
                    peak[i]++;
            for (int i = 1; i < N; i++)
                peak[i] += peak[i - 1];
            int max = 0;
            int p = 1;
            //System.out.println(Arrays.toString(peak));
            for (int i = 0; i < N - K + 1; i++) {
                if (max < peak[i + K - 2] - peak[i]) {
                    max = peak[i + K - 2] - peak[i];
                    p = i + 1;
                }
            }
            System.out.println(max+1+" "+p);
        }
    }
}
