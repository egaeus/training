package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/785/B>
 * @category implementation
 * @date 5/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF785B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            int[][] arr = new int[N][];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                arr[i] = new int[]{parseInt(st.nextToken()), parseInt(st.nextToken())};
            }
            int M = parseInt(in.readLine());
            int[][] arr1 = new int[M][];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                arr1[i] = new int[]{parseInt(st.nextToken()), parseInt(st.nextToken())};
            }
            System.out.println(Math.max(f(arr, arr1), f(arr1, arr)));
        }
    }

    static int f(int[][] arr, int[][] arr1) {
        int maxT = 0;
        for(int i=0;i<arr1.length;i++)
            maxT = Math.max(maxT, arr1[i][0]);
        int max = 0;
        for (int i = 0; i < arr.length; i++)
            max = Math.max(max, maxT - arr[i][1]);
        return max;
    }
}
