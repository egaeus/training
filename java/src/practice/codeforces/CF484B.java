package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/484/B>
 * @category math
 * @date 25/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF484B {

    static int[] arr;
    static int[] arr1;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader in = new BufferedReader(new FileReader("in.in"));
        long T = System.currentTimeMillis();
        for (String ln; (ln = in.readLine()) != null; ) {
            int N = parseInt(ln);
            StringTokenizer st = new StringTokenizer(in.readLine());
            int[] numbers = new int[N];
            int withOutRepeat = 0;
            int M = 1000001;
            arr = new int[M];
            arr1 = new int[M];
            boolean[] vis = new boolean[M];
            for (int i = 0; i < N; i++) {
                int n = parseInt(st.nextToken());
                if (!vis[n]) {
                    vis[n] = true;
                    numbers[withOutRepeat++] = n;
                }
            }
            Arrays.sort(numbers, 0, withOutRepeat);
            Arrays.fill(arr, -1);
            Arrays.fill(arr1, -1);

            for (int i = withOutRepeat - 2; i >= 0; i--)
                for (int j = numbers[i]; j <= numbers[i + 1]; j++)
                    arr[j] = numbers[i + 1];

            for (int i = 1; i < withOutRepeat; i++)
                for (int j = numbers[i - 1]; j <= numbers[i]; j++)
                    arr1[j] = numbers[i - 1];

            for (int j = numbers[withOutRepeat - 1]; j < M; j++)
                arr1[j] = numbers[withOutRepeat - 1];

            for (int j = 0; j <= numbers[0]; j++)
                arr[j] = numbers[0];

            int max = 0;

            for (int i = withOutRepeat - 1; i >= 0; i--)
                if (numbers[i] > max) {
                    max = Math.max(max, f(numbers[i], max));
                } else break;

            System.out.println(max);
            //System.out.println(System.currentTimeMillis() - T);
        }
    }

    static int f(int T, int max) {
        int N = (int) Math.sqrt(T);
        for (int i = 2; i <= N + 1; i++) {
            if (T / i + 1 < max) break;
            for (int j = -1; j < 2; j++) {
                if (T / i + j >= 0) {
                    int a = arr[T / i + j];
                    if (a != -1) max = Math.max(max, T % a);
                    a = arr1[T / i + j];
                    if (a != -1) max = Math.max(max, T % a);
                }
            }
        }
        return max;

    }
}
