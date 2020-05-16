/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1353/B
 * @category implementation
 * @date 14/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CFB {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[N];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                A[i] = parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                B[i] = parseInt(st.nextToken());
            Arrays.sort(A);
            Arrays.sort(B);
            int result = 0;
            int i = N - 1, j = N - 1, I = 0;
            for (; I < N && K > 0; I++) {
                //System.out.println(i + " " + j + " " + K + " " + B[j] + " " + A[i]);
                if (j >= 0 && B[j] > A[i]) {
                    result += B[j];
                    j--;
                    K--;
                } else {
                    result += A[i];
                    i--;
                }
            }
            for (; I < N; I++, i--) result += A[i];
            System.out.println(result);
        }
    }
}
