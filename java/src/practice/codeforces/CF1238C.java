package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1238/C>
 * @category dp
 * @date 11/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1238C {

    static int[] arr;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int q = 0, Q = parseInt(in.readLine()); q++ < Q; ) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int H = parseInt(st.nextToken()), N = parseInt(st.nextToken());
            arr = new int[N+1];
            st = new StringTokenizer(in.readLine());
            for(int i = 0; i < N; i++)
                arr[i] = parseInt(st.nextToken());
            mem = new int[N][2];
            for(int[] a:mem)
                Arrays.fill(a, -1);
            System.out.println(f(0, true));
        }
    }

    static int[][] mem;

    static int f(int p, boolean visible) {
        if(p>=arr.length-1)
            return 0;
        if(mem[p][visible?0:1]>=0)
            return mem[p][visible?0:1];
        int I = arr[p]-arr[p+1]-1;
        int min;
        if(visible)
            min = Math.min(f(p+1, false),f(p+1, true)+1);
        else {
            min = f(p, true) + 1;
            if(I==0)
                min = Math.min(min, f(p+1, true));
            else
                min = Math.min(min, f(p+1, false) + 1);
        }
        return mem[p][visible?0:1]=min;
    }
}
