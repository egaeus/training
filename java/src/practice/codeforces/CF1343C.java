package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1343/C>
 * @category two pointers
 * @date 11/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1343C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            long[] arr = new long[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = parseInt(st.nextToken());
            int sign = arr[0] < 0 ? -1 : 1;
            long max = arr[0];
            long sum = 0;
            for (int i = 1; i < N; i++) {
                int nSign = arr[i] < 0 ? -1 : 1;
                if (sign == nSign)
                    max = Math.max(max, arr[i]);
                else {
                    sum += max;
                    sign *= -1;
                    max = arr[i];
                }
            }
            sum += max;
            System.out.println(sum);
        }
    }
}
