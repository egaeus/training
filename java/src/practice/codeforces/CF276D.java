package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/276/D
 * @category bitwise
 * @date 17/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF276D {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken());
            long res = 0;
            for(int i = 60; i >= 0 && res <= 0; i--) {
                long a = (1L << i) & A;
                long b = (1L << i) & B;
                if(a != b)
                    res = (1L << (i + 1)) - 1;
            }
            System.out.println(res);
        }
    }
}
