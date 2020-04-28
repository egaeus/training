package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1130/B
 * @category
 * @date 20/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1130B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            int N = parseInt(ln);
            long[][] tiers = new long[N][2];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int house = 1; house <= 2 * N; house++) {
                int tier = parseInt(st.nextToken());
                if (tiers[tier - 1][1] > 0)
                    tiers[tier - 1][0] = house;
                else
                    tiers[tier - 1][1] = house;
            }
            long result = tiers[0][0] - 1 + tiers[0][1] - 1;
            for (int i = 0; i < N - 1; i++) {
                long s = tiers[i][0],
                        d = tiers[i][1],
                        A = tiers[i + 1][0],
                        B = tiers[i + 1][1];
                result += Math.min(Math.abs(s - A) + Math.abs(d - B), Math.abs(s - B) + Math.abs(d - A));
            }
            System.out.println(result);
        }
    }
}
