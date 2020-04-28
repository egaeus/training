package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict W.A.
 * @url https://codeforces.com/problemset/problem/1239/B
 * @category dp
 * @date 21/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

public class CF1239B {
    static int[] arr;
    static int N, MIN = -1000000;
    static char[] str;
    static long[][][][] mem;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            N = parseInt(ln);
            str = in.readLine().toCharArray();
            char[] S = new char[N * 2];
            for (int i = 0; i < N; i++)
                S[i] = S[i + N] = str[i];
            arr = new int[2 * N];
            arr[0] = S[0] == ')' ? -1 : 1;
            for (int i = 1; i < 2*N; i++)
                arr[i] = arr[i - 1] + (S[i] == ')' ? -1 : 1);
            for(int i=N;i<2*N;i++)
                arr[i] -= arr[i-N];
            System.out.println(Arrays.toString(arr));
            mem = new long[N][2][2][];
            for(int i=N;i>=0;i--)
                f(i,0,0);
            long res = f(0, 0, 0);
            if (res > 0) {
                System.out.println(res);
                int p1 = -1, p2 = -1;
                for (int p = 0, s = 0, r = 0; (p1 == -1 || p2 == -1) && p < N; p++) {
                    if (mem[p][s][r][1] == 1) {
                        s++;
                        p1 = p + 1;
                    } else if (mem[p][s][r][1] == 2) {
                        r++;
                        p2 = p + 1;
                    }
                }
                if(p1==-1||p2==-1)
                    p1=p2=1;
                System.out.println(p1 + " " + p2);
            } else {
                System.out.println(0);
                System.out.println("1 1");
            }
        }
    }

    static long f(int p, int s, int r) {
        if (p == N) return (s + r) % 2 == 0 ? 0 : MIN;
        if (mem[p][s][r] != null)
            return mem[p][s][r][0];
        long c = f(p + 1, s, r);
        int mov = 0;
        if (s == 0 && str[p] == ')') {
            long a = f(p + 1, 1, r);
            if (a > c) {
                c = a;
                mov = 1;
            }
        }
        if (r == 0 && str[p] == '(') {
            long a = f(p + 1, s, 1);
            if (a > c) {
                c = a;
                mov = 2;
            }
        }
        mem[p][s][r] = new long[]{c, mov};
        return c;
    }
}
