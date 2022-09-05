package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1339/B>
 * @category implementation
 * @date 10/06/2020
 **/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1339B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            long[] arr = new long[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            long[] solution = new long[N];
            int i = N / 2 - (N % 2 == 0 ? 1 : 0), j = N / 2 + 1 - (N % 2 == 0 ? 1 : 0);
            int k = 0;
            for (; k < N && i >= 0 && j < N; k++)
                if (k % 2 == 0) solution[k] = arr[i--];
                else solution[k] = arr[j++];
            for (; i >= 0; i--)
                solution[k++] = arr[i];
            for (; j < N; j++)
                solution[k++] = arr[j];
            System.out.println(LongStream.of(solution).mapToObj(a -> a + "").collect(Collectors.joining(" ")));
        }
    }
}
