package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1349/A
 * @category math
 * @date 12/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1349A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(in.readLine());
        boolean[] primos = new boolean[200000];
        primos[0] = primos[1] = true;
        ArrayList<Integer> P = new ArrayList<>();
        for (int i = 0; i < primos.length; i++)
            if (!primos[i]) {
                P.add(i);
                for (int j = i + i; j < primos.length; j += i)
                    primos[j] = true;
            }
        long[] r = new long[P.size()];
        for (int i = 0; i < P.size(); i++)
            r[i] = P.get(i);
        StringTokenizer st = new StringTokenizer(in.readLine());
        long[] numbers = new long[N];
        long[][][] desc = new long[N][][];
        long[][] O = new long[200000][2];
        for (long[] a : O) Arrays.fill(a, Integer.MAX_VALUE);
        int[] Q = new int[200000];
        for (int t = 0; t < N; t++) {
            numbers[t] = parseInt(st.nextToken());
            desc[t] = factoresPrimos(numbers[t], r);
            for (long[] a : desc[t]) {
                Q[(int) a[0]]++;
                if (O[(int) a[0]][0] > a[1]) {
                    long y = O[(int) a[0]][0];
                    O[(int) a[0]][0] = a[1];
                    O[(int) a[0]][1] = y;
                } else if (O[(int) a[0]][1] > a[1]) {
                    O[(int) a[0]][1] = a[1];
                }
            }
        }
        if(N>2) {
            long result = 1;
            for (int i = 0; i < Q.length; i++)
                if (Q[i] == N - 1) {
                    result *= Math.pow(i, O[i][0]);
                }
                else if (Q[i] == N) {
                    //System.out.println(i+" "+Arrays.toString(O[i]));
                    result *= Math.pow(i, O[i][1]);
                }
            System.out.println(result);
        } else {
            System.out.println(mcm(numbers[0],numbers[1]));
        }
    }

    static long[][] factoresPrimos(long x, long[] primos) {
        List<long[]> res = new ArrayList<>();
        double R = (long) (Math.sqrt(x) + 1 + 1e-5);
        long p, c;
        for (int i = 0, n = primos.length; i < n && (p = primos[i]) <= R; i++) {
            for (c = 0; x % p == 0; x /= p, c++) ;
            if (c > 0) res.add(new long[]{p, c});
        }
        if (x > 1) res.add(new long[]{x, 1});
        return res.toArray(new long[0][]);
    }

    static long mcm(long a, long b){
        return a*(b/mcd(a,b));
    }

    static long mcd(long a, long b){
        for(long t;b!=0;t=a%b,a=b,b=t);
        return a;
    }



}
