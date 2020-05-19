package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict W.A.
 * @url https://codeforces.com/problemset/problem/1355/F
 * @category math
 * @date 16/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class CF1355F {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean[] primos = new boolean[1000];
        primos[0] = primos[1] = true;
        ArrayList<Long> P = new ArrayList<>();
        long[] c = new long[26];
        for (int i = 0; i < primos.length && P.size() < c.length; i++)
            if (!primos[i]) {
                long p = 1;
                c[P.size()] = i;
                int log = (int) Math.floor(Math.log(1000000000000000000L) / Math.log(i));
                for (int k = 0; k < log; k++)
                    p *= i;
                P.add(p);
                for (int j = i + i; j < primos.length; j += i)
                    primos[j] = true;
            }
        System.out.println(Arrays.toString(c));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int[] number = new int[P.size() + 1];
            long N = 1;
            for (int i = 0; i < P.size(); i++) {
                System.out.println("? " + P.get(i));
                System.out.flush();
                long gcd = Long.parseLong(in.readLine());
                N *= gcd;
                number[i] = (int) Math.floor(Math.log(gcd) / Math.log(c[i]));
            }
            System.out.println("! " + numDivisores(number));
            System.out.flush();
        }
    }

    static long numDivisores(int[] N) {
        long res = 0;
        long resAnt = 0;
        for (int i = N.length - 1; i >= 0; i--) {
            for (int j = 0; j < N[i]; j++)
                res += resAnt + 1;
            resAnt = res;
        }
        return res + 1;
    }

}
