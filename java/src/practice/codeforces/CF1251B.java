package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1251/B
 * @category dp
 * @date 24/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class CF1251B {
    static int N;
    static int[] sizes;
    static int[] sumsizes;
    static int unos, zeros;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int Q = parseInt(in.readLine()), q = 0; q++ < Q; ) {
            N = parseInt(in.readLine());
            sumsizes = new int[N];
            sizes = new int[N];
            unos = 0;
            zeros = 0;
            for (int i = 0; i < N; i++) {
                char[] a = in.readLine().toCharArray();
                sizes[i] = a.length;
                for (int j = 0; j < a.length; j++)
                    if (a[j] == '0') zeros++;
                    else unos++;
            }
            for(int i=1;i<N;i++)
                sumsizes[i]=sumsizes[i-1]+sizes[i-1];
            mem = new int[unos+1][N];
            for(int[] a:mem)Arrays.fill(a,-1);
            System.out.println(f(0, 0));
        }
    }

    static int[][] mem;

    static int f(int u, int p) {
        if (p == N) return 0;
        if(mem[u][p]>=0)
            return mem[u][p];
        int z = sumsizes[p] - u;
        int max = 0;
        for (int i = 0; i <= sizes[p] && u + i <= unos; i++) {
            int U = i, Z = sizes[p] - U;
            if(U+u<=unos&&Z+z<=zeros)
                max = Math.max(max, f(U+u, p+1) + (isPal(sizes[p], U, Z)?1:0));
        }
        return mem[u][p]=max;
    }

    static boolean isPal(int size, int u, int z) {
        if(u==size)return true;
        if(z==size)return true;
        if(u%2==0)return true;
        if(z%2==0)return true;
        return false;
    }
}
