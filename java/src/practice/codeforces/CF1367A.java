package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1367/A
 * @category chars
 * @date 6/09/2022
 **/

import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class CF1367A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            char[] A = in.readLine().toCharArray();
            for (int i = 0; i < A.length; i+=2)
                sb.append(A[i]);
            sb.append(A[A.length - 1] + "\n");
        }
        System.out.print(new String(sb));
    }
}
