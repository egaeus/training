package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1343/D
 * @category two pointers
 * @date 11/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1343D {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            int[] values = new int[N];
            int[][] ranges = new int[N / 2][];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                values[i] = parseInt(st.nextToken());
            int[] sums = new int[2 * K + 1];
            for (int i = 0; i < N / 2; i++) {
                ranges[i] = new int[]{Math.min(values[i], values[N - i - 1]) + 1, Math.max(values[i], values[N - i - 1]) + K};
                sums[values[i] + values[N - i - 1]]++;
            }
            int[] arr = f(2 * K + 1, ranges);
            int min = N;
            for (int x = 0; x < arr.length; x++) {
               min = Math.min(min, 2 * (N / 2 - arr[x]) + arr[x] - sums[x]);
            }
            System.out.println(min);
        }
    }

    static int[] f(int N, int[][] ranges) {
        int[] beginRange = new int[N];
        int[] endRange = new int[N];
        int[] result = new int[N];
        for (int[] range : ranges) {
            beginRange[range[0]]++;
            endRange[range[1]]++;
        }
        for (int i = 0; i < N; i++) {
            if (i > 0)
                result[i] = result[i - 1] + beginRange[i] - endRange[i - 1];
            else
                result[i] = beginRange[i] - endRange[i];
        }
        return result;
    }
}
