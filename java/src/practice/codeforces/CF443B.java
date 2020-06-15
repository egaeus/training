package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/443/B>
 * @category strings
 * @date 9/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF443B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            char[] A = ln.toCharArray();
            int N = parseInt(in.readLine());
            int max = 0;
            for (int i = 2; i <= A.length + N; i += 2)
                if (f(A, N, i))
                    max = i;
            System.out.println(max);
        }
    }

    static boolean f(char[] A, int N, int K) {
        for (int i = 0; i < A.length + N - K + 1; i++) {
            boolean ws = true;
            for (int j = 0; j < K / 2; j++)
                if (i + j < A.length && i + j + K / 2 < A.length && A[i + j] != A[i + j + K / 2])
                    ws = false;
            if (ws) {
                return true;
            }
        }
        return false;
    }
}
