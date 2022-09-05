package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1293/A>
 * @category binary search
 * @date 9/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1293A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), S = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            int[] arr = new int[K];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < K; i++)
                arr[i] = parseInt(st.nextToken());
            Arrays.sort(arr);
            int min = -1;
            for (int i = S, j = S; i >= S - 2000 && min < 0; i--, j++) {
                if (j <= N && Arrays.binarySearch(arr, j) < 0)
                    min = j - S;
                if (i > 0 && Arrays.binarySearch(arr, i) < 0)
                    min = S - i;
            }
            System.out.println(min);
        }
    }
}
