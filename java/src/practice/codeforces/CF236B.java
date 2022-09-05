package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/236/B>
 * @category math
 * @date 10/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF236B {

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            long[] primos = getPrimos(1000001);
            int I = parseInt(st.nextToken()), J = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            long solution = 0, MOD = 1073741824;
            for (int i = 1; i <= I; i++) {
                for (int j = 1; j <= J; j++) {
                    for (int k = 1; k <= K; k++) {
                        solution = (solution + numDivisores(i * j * k, primos)) % MOD;
                    }
                }
            }
            System.out.println(solution);
        }
    }

    static long[] getPrimos(int cota) {
        boolean[] arr = new boolean[cota + 1];
        long[] res = new long[cota];
        arr[0] = arr[1] = true;
        int K = 0;
        for (int i = 0; i < arr.length; i++)
            if (!arr[i]) {
                res[K++] = i;
                for (int j = 2 * i; j < arr.length; j += i) arr[j] = true;
            }
        return Arrays.copyOfRange(res, 0, K);
    }


    static long numDivisores(long N, long[] primos) {
        long res = 0;
        long resAnt = 0;
        int sqrt = (int) Math.sqrt(N);
        for (int i = 0; N > 1; i++) {
            if (primos[i] > sqrt) N = 0;
            if (N % primos[i] == 0) {
                res += resAnt + 1;
                N /= primos[i--];
            } else resAnt = res;
        }
        return res + 1;
    }

}
