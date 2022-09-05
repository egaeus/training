package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1365/C>
 * @category implementation
 * @date 7/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1365C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[N];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                int v = parseInt(st.nextToken()) - 1;
                A[v] = i;
            }
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                int v = parseInt(st.nextToken()) - 1;
                B[v] = i;
            }
            int[] dif = new int[N];
            for (int i = 0; i < N; i++) {
                dif[B[i] >= A[i] ? B[i] - A[i] : N - A[i] + B[i]]++;
            }
            Arrays.sort(dif);
            System.out.println(dif[N - 1]);
        }
    }
}
