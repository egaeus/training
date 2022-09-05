package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/158/D>
 * @category implementation
 * @date 28/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF158D {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            int N = parseInt(ln);
            int[] arr = new int[N];
            int max = Integer.MIN_VALUE;
            int[] sums = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = parseInt(st.nextToken());
            for (int i = 1; i <= N / 3; i++) {
                if(N%i==0) {
                    for (int j = 0; j < N; j++) {
                        if (j < i) sums[j] = arr[j];
                        else sums[j] = sums[j - i] + arr[j];
                        if (j + i >= N) max = Math.max(sums[j], max);
                    }
                }
            }
            System.out.println(max);
        }
    }
}
