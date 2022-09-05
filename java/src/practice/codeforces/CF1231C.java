package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1231/C>
 * @category implementation
 * @date 30/09/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1231C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            int[][] T = new int[N][M];
            int[][] TT = new int[M][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < M; j++) {
                    T[i][j] = parseInt(st.nextToken());
                    TT[j][i] = T[i][j];
                }
            }
            boolean ws = true;
            for (int i = N - 1; i >= 0 && ws; i--)
                for (int j = M - 1; j >= 0 && ws; j--)
                    if (T[i][j] == 0) {
                        int[] R = getRange(i, j, T);
                        int[] RT = getRange(j, i, TT);
                        int v = -1;
                        for (int k = R[0]; k <= R[1]; k++)
                            if (k >= RT[0] && k <= RT[1])
                                v = k;
                        if (v > 0)
                            T[i][j] = TT[j][i] = v;
                        else
                            ws = false;
                    }
            int sum = -1;
            //for(int[]a:T) System.out.println(Arrays.toString(a));
            if (check(T) && ws) {
                sum = 0;
                for (int i = 0; i < N; i++)
                    for (int j = 0; j < M; j++)
                        sum += T[i][j];
            }
            System.out.println(sum);
        }
    }

    static int[] getRange(int I, int J, int[][] T) {
        int R[] = new int[2];
        for (int j = 0; j <= J; j++)
            if (T[I][j] == 0)
                R[0]++;
            else R[0] = T[I][j];
        for (int j = T[I].length - 1; j >= J; j--)
            if (T[I][j] == 0)
                R[1]--;
            else R[1] = T[I][j];
        return R;
    }

    static boolean check(int[][] T) {
        for (int i = 0; i < T.length; i++)
            for (int j = 0; j < T[i].length; j++)
                if ((i > 0 && T[i - 1][j] >= T[i][j]) || (j > 0 && T[i][j - 1] >= T[i][j]))
                    return false;
        return true;
    }
}
