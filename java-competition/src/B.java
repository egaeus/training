
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Not sended
 * @problemId 
 * @problemName 
 * @judge http://codeforces.com/
 * @category 
 * @level
 * @date Mon Mar 28 2022
 */

import java.io.*;
import static java.lang.Integer.*;
import java.util.*;

public class B {
  public static void main(String args[]) throws Throwable {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    for (String ln; (ln = in.readLine()) != null;) {
      StringTokenizer st = new StringTokenizer(ln);
      int T = parseInt(st.nextToken());
      long fact[] = new long[1001];
      long mod = 998244353;
      long[][] comb = new long[1001][1001];
      for (int n = 0; n < 1001; n++) {
        comb[n][0] = comb[n][n] = 1;
        for (int i = 1, t = n >>> 1; i <= t; i++)
          comb[n][i] = comb[n][n - i] = (comb[n - 1][i - 1] + comb[n - 1][i]) % mod;
      }
      fact[0] = 1;
      for (int i = 1; i < 1001; i++)
        fact[i] = (fact[i - 1] * i) % mod;
      for (int t = 0; t < T; t++) {
        int N = parseInt(in.readLine().trim());
        boolean[] prime = new boolean[N + 1];
        int q = 0;
        prime[0] = prime[1] = true;
        for (int i = 0; i <= N; i++) {
          if (!prime[i]) {
            q++;
            for (int j = i + i; j <= N; j += i)
              prime[j] = true;
          }
        }
        long solution = 0;
        for (int i = 2; i <= N; i++) {
          if (N / i >= q && !prime[i]) {
            int S = N / i;
            System.out.println(S + " " + q + " " + comb[S][q]);
            solution = (solution + (((comb[S][q] * fact[N - q]) % mod) * fact[q]) % mod) % mod;
          }
        }
        System.out.println("-------------");
        sb.append(solution).append("\n");
      }
    }
    System.out.print(new String(sb));
  }
}