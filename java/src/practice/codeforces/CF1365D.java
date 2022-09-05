package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1365/D>
 * @category graph
 * @date 7/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1365D {
    static int[][] neigh = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            mat = new char[N][M];
            mem = new int[N][M];
            for (int i = 0; i < N; i++)
                mat[i] = in.readLine().toCharArray();
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++) {
                    if (mat[i][j] == 'B') {
                        for (int[] n : neigh)
                            if (i + n[0] >= 0 && i + n[0] < N && j + n[1] >= 0 && j + n[1] < M) {
                                if (mat[i + n[0]][j + n[1]] == '.')
                                    mat[i + n[0]][j + n[1]] = '#';
                            }
                    }
                }
            boolean ws = true;
            f(N - 1, M - 1);
            for (int i = 0; i < N && ws; i++)
                for (int j = 0; j < M && ws; j++) {
                    if (mat[i][j] == 'G' && mem[i][j] == 0)
                        ws = false;
                    if (mat[i][j] == 'B' && mem[i][j] != 0)
                        ws = false;
                }
            System.out.println(ws ? "Yes" : "No");
        }
    }

    static int[][] mem;
    static char[][] mat;

    static void f(int I, int J) {
        if (mat[I][J] == '#') {
            return;
        }
        if (mem[I][J] == 0) {
            mem[I][J] = -1;
            for (int[] n : neigh)
                if (I + n[0] >= 0 && I + n[0] < mem.length && J + n[1] >= 0 && J + n[1] < mem[0].length) {
                    f(I + n[0], J + n[1]);
                    if (mem[I + n[0]][J + n[1]] == 1)
                        mem[I][J] = 1;
                }
        }
    }
}
