package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1363/B>
 * @category implementation
 * @date 31/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1363B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            char[] str = in.readLine().toCharArray();
            int N = str.length;
            int[] ones = new int[N];
            ones[0] = str[0] - '0';
            for (int i = 1; i < N; i++)
                ones[i] = ones[i - 1] + str[i] - '0';
            int min = MAX_VALUE;
            for (int i = 0; i <= N; i++) {
                int onesLeft = i > 0 ? ones[i - 1] : 0;
                int zeroLeft = i - onesLeft;
                int onesRight = ones[N - 1] - onesLeft;
                int zeroRight = N - i - onesRight;
                min = Math.min(min, onesLeft + zeroRight);
                min = Math.min(min, zeroLeft + onesRight);
            }
            System.out.println(min);
        }
    }
}
