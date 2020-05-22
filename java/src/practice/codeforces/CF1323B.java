package practice.codeforces; 

/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <<https://codeforces.com/problemset/problem/1323/B>
 * @category arrays
 * @date 21/05/2020
 **/

import java.io.*;
import java.util.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1323B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            int A[] = new int[N];
            int B[] = new int[M];
            long QA[] = new long[N + 1];
            long QB[] = new long[M + 1];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = parseInt(st.nextToken());
            }
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = parseInt(st.nextToken());
            }
            f(A, QA);
            f(B, QB);
            long s = 0;
            for (int i = 1; i < QA.length; i++)
                if (K % i == 0 && K / i < QB.length)
                    s += QA[i] * QB[K / i];
            System.out.println(s);
        }
    }

    static void f(int[] A, long[] Q) {
        int s = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                s++;
            } else if (s > 0) {
                Q[s]++;
                s = 0;
            }
        }
        if (s > 0) Q[s]++;
        for (int i = Q.length - 2; i > 0; i--)
            Q[i] += Q[i + 1] * 2 - (i < Q.length - 2 ? Q[i + 2] : 0);
    }
}

