package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1323/C>
 * @category arrays
 * @date 21/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1323C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int N = parseInt(ln);
            char[] str = in.readLine().toCharArray();
            int[] numbers = new int[N];
            ArrayList<Integer> zeros = new ArrayList<>();
            zeros.add(-1);
            for (int i = 0; i < N; i++) {
                if (str[i] == '(')
                    numbers[i]--;
                else numbers[i]++;
                if (i > 0)
                    numbers[i] += numbers[i - 1];
                if (numbers[i] == 0)
                    zeros.add(i);
            }
            long s = 0;
            if (N % 2 == 0 && numbers[N - 1] == 0) {
                for (int i = 1; i < zeros.size(); i++) {
                    if (numbers[zeros.get(i - 1) + 1] > 0)
                        s += zeros.get(i) - zeros.get(i - 1);
                }
                System.out.println(s);
            } else
                System.out.println(-1);
        }
    }
}
