package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1355/E>
 * @category ternary search
 * @date 16/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1355E {

    static int N;
    static long A, R, M;
    static long[] arr;
    static long sum;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            N = parseInt(st.nextToken());
            A = parseInt(st.nextToken());
            R = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            arr = new long[N];
            long[] cp = new long[N];
            st = new StringTokenizer(in.readLine());
            sum = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = parseInt(st.nextToken());
                sum = Math.max(arr[i], sum);
            }
            Arrays.sort(arr);
            for (int i = 0; i < N; i++)
                cp[N - i - 1] = arr[i];
            arr = cp;
            long result = busquedaTernaria(0, sum);
            System.out.println(f(result));
        }
    }

    static long busquedaTernaria(long l, long r) {
        if (l == r) {
            return l;
        }
        if (r - l <= 2) {
            if (f(l + 1) < f(l) && f(l + 1) < f(r))
                return l + 1;
            if (f(l) < f(l + 1) && f(l) < f(r))
                return l;
            return r;
        } else {
            long m1 = (2 * l + r) / 3;
            long m2 = (l + 2 * r) / 3;
            if (f(m1) > f(m2)) {
                return busquedaTernaria(m1, r);
            } else {
                return busquedaTernaria(l, m2);
            }
        }
    }

    static long f(long B) {
        long replace = 0;
        long result = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > B) {
                result += (arr[i] - B) * R;
                replace += arr[i] - B;
            } else if (arr[i] < B) {
                if (replace > 0 && M < R + A) {
                    long move = Math.min(replace, B - arr[i]);
                    replace -= move;
                    result -= move * R;
                    result += move * M;
                    if (B > arr[i] + move)
                        result += (B - (arr[i] + move)) * A;
                } else {
                    result += (B - arr[i]) * A;
                }
            }
        }
        return result;
    }
}
