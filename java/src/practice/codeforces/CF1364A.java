package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1364/A>
 * @category implementation
 * @date 13/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1364A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(in.readLine());
            long sum = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = parseInt(st.nextToken());
                sum += arr[i];
            }
            if (sum % K != 0)
                System.out.println(N);
            else {
                int max = 0;
                for (int i = 0; i < N; i++)
                    if (arr[i] % K != 0) {
                        max = N - i - 1;
                        break;
                    }
                for (int i = N - 1; i >= 0; i--)
                    if (arr[i] % K != 0) {
                        max = Math.max(max, i);
                        break;
                    }
                if (max > 0)
                    System.out.println(max);
                else
                    System.out.println(-1);
            }
        }
    }

    static boolean f(int N, int k, int[] arr, int M) {
        long s = 0;
        for (int i = 0; i < k; i++)
            s += arr[i];
        if (s % M != 0) return true;
        for (int i = k; i < N; i++) {
            s += arr[i];
            s -= arr[i - k];
            if (s % M != 0)
                return true;
        }
        return s % M != 0;
    }
}
