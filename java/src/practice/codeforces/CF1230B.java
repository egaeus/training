package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1230/B
 * @category adhoc
 * @date 30/09/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1230B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            char[] A = in.readLine().toCharArray();
            if (N == 1 && K >= 1)
                System.out.println(0);
            else {
                for (int i = 0, j = 0; i < K && j < N; j++)
                    if (j == 0 && A[j] != '1') {
                        i++;
                        A[j] = '1';
                    } else if (j > 0 && A[j] != '0') {
                        i++;
                        A[j] = '0';
                    }
                System.out.println(new String(A));
            }
        }
    }
}
