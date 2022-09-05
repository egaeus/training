package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1249/E>
 * @category dp
 * @date 22/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class CF1249E {
    static int N;
    static long C;
    static long[] A;
    static long[] B;
    static long[][] M;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            N = parseInt(st.nextToken());
            C = parseInt(st.nextToken());
            A = new long[N - 1];
            B = new long[N - 1];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N - 1; i++)
                A[i] = parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N - 1; i++)
                B[i] = parseInt(st.nextToken());
            M = new long[N][2];
            for(int i=0;i<N;i++)
                f(i,false);
            System.out.println(Arrays.stream(M).map(a -> a[1]+"").collect(Collectors.joining(" ")));
        }
    }

    public static long f(int p, boolean e) {
        if (p == 0) return 0;
        if (M[p][e ? 0 : 1] != 0)
            return M[p][e ? 0 : 1];
        return M[p][e ? 0 : 1] = Math.min(f(p - 1, false) + A[p - 1], f(p - 1, true) + B[p - 1] + (e ? 0 : C));
    }
}
