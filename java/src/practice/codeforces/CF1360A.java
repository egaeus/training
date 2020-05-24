package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1360/A>
 * @category math
 * @date 24/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1360A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int[] A = new int[]{parseInt(st.nextToken()), parseInt(st.nextToken())};
            int s = 1000000000;
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 2; j++)
                    s = Math.min(s, Math.max(Math.max(A[(i + 2) % 2], A[(j + 1) % 2]), A[i] + A[j]) *
                            Math.max(Math.max(A[(i + 2) % 2], A[(j + 1) % 2]), A[i] + A[j]));
            System.out.println(s);
        }
    }
}

