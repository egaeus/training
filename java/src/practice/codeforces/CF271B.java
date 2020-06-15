package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/271/B>
 * @category math
 * @date 10/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF271B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            boolean[] primes = new boolean[200000];
            primes[0] = primes[1] = true;
            TreeSet<Integer> P = new TreeSet<>();
            for (int i = 0; i < primes.length; i++)
                if (!primes[i]) {
                    P.add(i);
                    for (int j = i + i; j < primes.length; j += i)
                        primes[j] = true;
                }
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            long[] rows = new long[N];
            long[] cols = new long[M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < M; j++) {
                    int v = parseInt(st.nextToken());
                    int u = P.ceiling(v);
                    rows[i] += u - v;
                    cols[j] += u - v;
                }
            }
            long min = Long.MAX_VALUE;
            for(int i=0;i<N;i++)
                min = Math.min(rows[i], min);
            for (int i = 0; i < M; i++) {
                min = Math.min(cols[i], min);
            }
            System.out.println(min);
        }
    }
}
