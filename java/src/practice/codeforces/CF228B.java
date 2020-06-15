package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/228/B>
 * @category implementation
 * @date 10/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF228B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int NA = parseInt(st.nextToken()), MA = parseInt(st.nextToken());
            int[][] A = new int[NA][MA];
            for (int i = 0; i < NA; i++) {
                char[] a = in.readLine().toCharArray();
                for (int j = 0; j < MA; j++) {
                    A[i][j] = a[j] - '0';
                }
            }
            st = new StringTokenizer(in.readLine());
            int NB = parseInt(st.nextToken()), MB = parseInt(st.nextToken());
            int[][] B = new int[NB][MB];
            for (int i = 0; i < NB; i++) {
                char[] a = in.readLine().toCharArray();
                for (int j = 0; j < MB; j++) {
                    B[i][j] = a[j] - '0';
                }
            }
            int max = 0;
            int[] s = new int[]{0, 0};
            int N = Math.max(NB,NA), M = Math.max(MB,MA);
            for (int x = -N; x <= N; x++) {
                for (int y = -M; y <= M; y++) {
                    int sum = 0;
                    for (int i = 0; i < NA; i++) {
                        for (int j = 0; j < MA; j++) {
                            sum += i + x < NB && i + x >= 0 && j + y >= 0 && j + y < MB ? A[i][j] * B[i + x][j + y] : 0;
                        }
                    }
                    if (sum > max) {
                        max = sum;
                        s[0] = x;
                        s[1] = y;
                    }
                }
            }
            System.out.println(s[0] + " " + s[1]);
        }
    }
}
