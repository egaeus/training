package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/448/D
 * @category binary search
 * @date 28/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF448D {
    static long N, M, K;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            K = Long.parseLong(st.nextToken());
            long a = 1, b = N * M;
            for (; a < b; ) {
                long p = (a+b)/2+(a+b)%2;
                if(check(p))
                    a=p;
                else b = p-1;
            }
            System.out.println(a);
        }
    }

    static boolean check(long p) {
        long sum = 0;
        for (int i = 1; i <= N && sum <= K; i++)
            sum += Math.min(p / i, M) - (Math.min(p / i, M)*i==p?1:0);
        return sum < K;
    }
}
