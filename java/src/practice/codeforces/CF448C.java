package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/448/C>
 * @category dp
 * @date 31/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF448C {
    static long[] arr;
    static int N;
    static int[][] mem;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader in = new BufferedReader(new FileReader("in.in"));
        for (String ln; (ln = in.readLine()) != null; ) {
            long T = System.currentTimeMillis();
            N = parseInt(ln);
            arr = new long[N];
            mem = new int[N + 1][N + 1];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = parseInt(st.nextToken());
                Arrays.fill(mem[i], -1);
            }
            /*for (int i = N - 1; i >= 0; i--)
                for (int j = N - 1; j >= -1; j--)
                    f(i, j);*/
            System.out.println(f(0, -1));
            //System.out.println(System.currentTimeMillis()-T);
        }
    }

    static long f(int p, int max) {
        if (p == N) return 0;
        if (mem[p][max + 1] >= 0)
            return mem[p][max + 1];
        long min = N;
        if (max == -1) {
            long v = f(p + 1, p) + arr[p];
            if(v<min)
                min = v;
            v = f(p + 1, -1) + 1;
            if(v<min)
                min = v;
        } else {
            if (arr[p] > arr[max]) {
                long v = f(p + 1, p) + arr[p] - arr[max];
                if(v < min)
                    min = v;
                v = f(p + 1, max) + 1;
                if(v < min)
                    min = v;
            } else {
                long v = f(p + 1, p);
                if (v < min)
                    min = v;
            }
        }
        return mem[p][max + 1] = (int) min;
    }
}
