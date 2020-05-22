package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1355/F>
 * @category math
 * @date 20/05/2020
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
        long[] c = new long[168];
        int P = 0;
        for (int i = 0; i < primos.length; i++)
            if (!primos[i]) {
                c[P++] = i;
                for (int j = i + i; j < primos.length; j += i)
                    primos[j] = true;
            }
        ArrayList<ArrayList<Long>> numbers = new ArrayList<>();
        for (int i = 0; i < P; ) {
            ArrayList<Long> list = new ArrayList<>();
            for (long a = 1; i < P && a * c[i] <= 1000000000000000000L && a * c[i] > 0; a *= c[i++])
                list.add(c[i]);
            numbers.add(list);
        }
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            long X1 = 1;
            long solution = -1;
            for (int i = 0; i < numbers.size() && solution < 0; i++) {
                long Q = 1;
                for (long j : numbers.get(i))
                    Q *= j;
                System.out.println("? " + Q);
                System.out.flush();
                long gcd = Long.parseLong(in.readLine());
                X1 *= gcd;
                if (numbers.get(i + 1).get(0) * numbers.get(i + 1).get(0) * numbers.get(i + 1).get(0) * X1 > 1000000000) {
                    ArrayList<Long> divs = new ArrayList<>();
                    for (int j = 0; j < P; j++)
                        if (X1 % c[j] == 0)
                            divs.add(c[j]);
                    X1 = 1;
                    for (int j = 0; j < divs.size(); j += 2) {
                        Q = 1;
                        for (; Q * divs.get(j) <= 1000000000; )
                            Q *= divs.get(j);
                        long Q1 = 1;
                        for (;j + 1 < divs.size() && Q1 * divs.get(j + 1) <= 1000000000; )
                            Q1 *= divs.get(j + 1);
                        System.out.println("? " + Q*Q1);
                        System.out.flush();
                        gcd = Long.parseLong(in.readLine());
                        X1 *= gcd;
                        solution = numDivisores(X1, c) * 2;
                    }
                } else if (X1 == 1 && numbers.get(i + 1).get(0) * numbers.get(i + 1).get(0) * numbers.get(i + 1).get(0) * numbers.get(i + 1).get(0) > 1000000000)
                    solution = 4;
            }
            System.out.println("! " + solution);
            System.out.flush();
        }
    }

    static long numDivisores(long N, long[] p) {
        long res = 0;
        long resAnt = 0;
        for (int i = 0; i < p.length && N > 1; i++) {
            for (; N % p[i] == 0; N /= p[i])
                res += resAnt + 1;
            resAnt = res;
        }
        return res + 1;
    }

}
