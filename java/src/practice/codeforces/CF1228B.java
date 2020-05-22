package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1228/B>
 * @category implementation
 * @date 30/09/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1228B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            int H = parseInt(st.nextToken()), W = parseInt(st.nextToken());
            int[][] T = new int[H][W];
            int[] h = new int[H];
            int[] w = new int[W];
            st = new StringTokenizer(in.readLine());
            boolean ws = true;
            for (int i = 0, j; i < H; i++) {
                for (j = 0, h[i] = parseInt(st.nextToken()); j < h[i]; j++)
                    T[i][j] = 1;
                if (h[i] < W)
                    T[i][h[i]] = 2;
            }
            st = new StringTokenizer(in.readLine());
            for (int j = 0, i; j < W; j++) {
                for (i = 0, w[j] = parseInt(st.nextToken()); i < w[j]; i++) {
                    if (T[i][j] == 2)
                        ws = false;
                    T[i][j] = 1;
                }
                if (w[j] < H) {
                    if(T[w[j]][j]==1)
                        ws=false;
                    T[w[j]][j] = 2;
                }
            }
            if (!ws)
                System.out.println(0);
            else {
                int s = 0;
                for (int i = 0; i < H; i++)
                    for (int j = 0; j < W; j++)
                        if (T[i][j] == 0)
                            s++;
                System.out.println(BigInteger.valueOf(2).modPow(BigInteger.valueOf(s), BigInteger.valueOf(1000000007)));
            }
        }
    }

}
