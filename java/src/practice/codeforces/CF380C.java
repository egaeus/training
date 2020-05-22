package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/380/C>
 * @category rmq
 * @date 23/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF380C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringBuilder sb = new StringBuilder();
            char[] s = ln.toCharArray();
            int[] arr = new int[s.length];
            arr[0] = s[0] == ')' ? -1 : 1;
            for (int i = 1; i < arr.length; i++)
                arr[i] = arr[i - 1] + (s[i] == ')' ? -1 : 1);
            RMQ rmq = new RMQ(arr);
            int M = parseInt(in.readLine());
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                int l = parseInt(st.nextToken()) - 1, r = parseInt(st.nextToken()) - 1;
                int min = rmq.get(l, r) - (l > 0 ? arr[l - 1] : 0);
                int sol = r - l + 1 - Math.abs(min) - (arr[r] - (l > 0 ? arr[l - 1] : 0)) + min;
                sb.append(sol).append("\n");
            }
            System.out.print(new String(sb));
        }
    }

    static class RMQ {
        private int[] arr;
        private int[] mins;
        private int sqrt;
        private int N;

        RMQ(int[] arr) {
            this.arr = arr;
            N = arr.length;
            sqrt = (int) Math.sqrt(N);
            mins = new int[(int) Math.ceil(1. * N / sqrt)];
            Arrays.fill(mins, Integer.MAX_VALUE);
            for (int i = 0; i < N; i++)
                mins[i / sqrt] = Math.min(mins[i / sqrt], arr[i]);
        }

        int get(int l, int r) {
            int min = arr[l];
            if (l % sqrt == 0) l++;
            for (; l % sqrt != 0 && l < N && l <= r; l++)
                min = Math.min(min, arr[l]);
            for (; r % sqrt != sqrt - 1 && r >= 0 && l <= r; r--)
                min = Math.min(min, arr[r]);
            for (; l < r; l += sqrt)
                min = Math.min(min, mins[l / sqrt]);
            return min;
        }
    }
}
