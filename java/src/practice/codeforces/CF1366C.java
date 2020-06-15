package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1366/C>
 * @category implementation
 * @date 11/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1366C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            int[][] arr = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < M; j++) {
                    arr[i][j] = parseInt(st.nextToken());
                }
            }
            ArrayList<Integer> diagonales[] = new ArrayList[N + M - 1];
            ArrayList<int[]> delete[] = new ArrayList[N + M - 1];
            for (int d = 0; d < M; d++) {
                diagonales[d] = new ArrayList<>();
                delete[d] = new ArrayList<>();
                for (int i = 0, j = d; i < N && j >= 0; i++, j--) {
                    diagonales[d].add(arr[i][j]);
                    delete[d].add(new int[]{i, j});
                }
            }
            for (int d = 1; d < N; d++) {
                diagonales[d + M - 1] = new ArrayList<>();
                delete[d + M - 1] = new ArrayList<>();
                for (int i = d, j = M - 1; i < N && j >= 0; i++, j--) {
                    diagonales[d + M - 1].add(arr[i][j]);
                    delete[d + M - 1].add(new int[]{i, j});
                }
            }
            int solution = 0;
            for (int i = 0; i < diagonales.length / 2; i++) {
                int ones = 0, zeros = 0;
                for (int a : diagonales[i])
                    if (a == 0) zeros++;
                    else ones++;
                for (int a : diagonales[diagonales.length - i - 1])
                    if (a == 0) zeros++;
                    else ones++;
                int total = diagonales[i].size() + diagonales[diagonales.length - i - 1].size();
                if(total - ones > total - zeros)
                    solution += total - zeros;
                else
                    solution += total - ones;
            }
            System.out.println(solution);
        }
    }
}
