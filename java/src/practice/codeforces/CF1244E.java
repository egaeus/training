package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1244/E>
 * @category math
 * @date 16/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Long.parseLong;

public class CF1244E {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = Integer.parseInt(st.nextToken());
            long K = parseLong(st.nextToken());
            long[] arr = new long[N];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = parseLong(st.nextToken());
            System.out.println(f(arr, K, N));
        }
    }

    static long f(long[] arr, long K, int N) {
        Arrays.sort(arr);
        long median = arr.length % 2 == 0 ? (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2 : arr[arr.length / 2];
        for (int i = 0; i < arr.length / 2 - 1 && K > 0; i++) {
            int j = arr.length - 1 - i;
            long mov = (arr[i + 1] - arr[i] + arr[j] - arr[j - 1]) * (i + 1);
            if (mov > K) {
                return arr[j] - arr[i] - (K / (i + 1));
            } else
                K -= mov;
        }
        int left = arr.length / 2 - 1, right = arr.length - 1 - left;
        long moveToMedian = (median - arr[left] + arr[right] - median) * (left + 1);
        if (K >= moveToMedian) return 0;
        return arr[right] - arr[left] - (K / ((left + 1)));
    }
}
