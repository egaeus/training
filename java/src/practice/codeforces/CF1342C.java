package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1342/C
 * @category math
 * @date 27/04/2012
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1342C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t++ < T;) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long A = parseInt(st.nextToken()), B = parseInt(st.nextToken()), Q = parseInt(st.nextToken()), MOD = A*B;
            long s = 0;
            long[] values = new long[(int)MOD];
            for(long i = 0; i < MOD; i++) {
                if ((i % A) % B != (i % B) % A) {
                    s++;
                }
                values[(int)i]=s;
            }

            for(int q = 0; q < Q; q++) {
                st = new StringTokenizer(in.readLine());
                long L = Long.parseLong(st.nextToken()), R = Long.parseLong(st.nextToken());
                if(q>0)sb.append(" ");
                sb.append(f(s, MOD, R, A, B, values)-f(s, MOD, L-1, A, B, values));
            }
            sb.append("\n");
        }
        System.out.print(new String(sb));
    }

    static long f(long s, long MOD, long I, long A, long B, long[] values) {
        long result = (I / MOD) * s;
        return result + values[(int)(I%MOD)];
    }
}
