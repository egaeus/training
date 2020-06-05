package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict W.A.
 * @url <https://codeforces.com/problemset/problem/200/A>
 * @category ?
 * @date 3/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF200A {
    static boolean[][] mat;

    static void generateCase() {
        int N = 2000, M = 2000, K = 100000;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        sb.append(N + " " + M + " " + K).append("\n");
        for (int i = 0; i < K; i++)
            sb.append(1000).append(" ").append(1000).append("\n");
        System.out.print(new String(sb));
    }

    public static void main(String args[]) throws Throwable {
        //generateCase();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            long time = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            mat = new boolean[N][M];
            for (int t = 0; t < K; t++) {
                st = new StringTokenizer(in.readLine());
                int x = parseInt(st.nextToken()) - 1, y = parseInt(st.nextToken()) - 1;
                if (!mat[x][y]) {
                    sb.append((x + 1) + " " + (y + 1)).append("\n");
                    mat[x][y] = true;
                } else {
                    int a = 1, b = Math.max(Math.max(x, N - x), Math.max(y, M - y));
                    while (a < b) {
                        int p = (a + b) / 2;
                        if (f(x, y, p))
                            b = p;
                        else
                            a = p + 1;
                    }
                    //System.out.println(x+" "+y+" "+a);
                    int[] p = getResult(a, x, y);
                    x = p[0];
                    y = p[1];
                    sb.append(x + 1).append(" ").append(y + 1).append("\n");
                    mat[x][y] = true;
                }
            }
            System.out.print(new String(sb));
            //System.out.println(System.currentTimeMillis() - time);
        }
    }

    static boolean f(int x, int y) {
        return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && !mat[x][y];
    }

    static boolean f(int x, int y, int i) {
        for (int I = Math.max(x - i, 0), t = x - i < 0 ? i - x : 0; I <= x && y - t >= 0; I++, t++)
            if (f(I, y - t))
                return true;
        for (int I = Math.max(x - i, 0), t = x - i < 0 ? i - x : 0; I <= x && y + t < mat[0].length; I++, t++)
            if (f(I, y + t))
                return true;
        for (int I = Math.min(x + i, mat.length - 1), t = x + i >= mat.length ? x + i - mat.length + 1 : 0; I >= x && y - t >= 0; I--, t++)
            if (f(I, y - t))
                return true;
        for (int I = Math.min(x + i, mat.length - 1), t = x + i >= mat.length ? x + i - mat.length + 1 : 0; I >= x && y + t < mat[0].length; I--, t++)
            if (f(I, y + t))
                return true;
        return false;
    }

    static int[] change(int[] p, int a[]) {
        if (f(a[0], a[1]) && (p == null || (a[0] < p[0] || (a[0] == p[0] && a[1] < p[1]))))
            return a;
        return null;
    }

    static int[] getResult(int i, int x, int y) {
        int p[] = null;
        for (int j = 0; j <= i; j++) {
            int[] r = change(p, new int[]{x - i + j, y - j});
            if (r != null)
                p = r;
            r = change(p, new int[]{x - i + j, y + j});
            if (r != null)
                p = r;
            r = change(p, new int[]{x + i - j, y + j});
            if (r != null)
                p = r;
            r = change(p, new int[]{x + i - j, y - j});
            if (r != null)
                p = r;
        }
        return p;
    }
}

