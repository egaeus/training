package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1350/B
 * @category math
 * @date 12/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1350B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = parseInt(st.nextToken());
            int[] better = new int[N];
            for (int i = N - 1; i >= 0; i--) {
                better[i] = 1;
                for (int p = 2; (i + 1) * p <= N; p++)
                    if (arr[i] < arr[(i + 1) * p - 1])
                        better[i] = Math.max(better[(i + 1) * p - 1] + 1, better[i]);
            }
            for (int i = 1; i < N; i++)
                if (arr[0] < arr[i])
                    better[0] = Math.max(better[0], better[i] + 1);
            Arrays.sort(better);
            System.out.println(better[N - 1]);
        }
    }

    static int[] arr;

}
