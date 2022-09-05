package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/230/B
 * @category math
 * @date 5/09/2022
 **/

import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class CF230B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean[] primes = new boolean[1000001];
        primes[0] = primes[1] = true;
        for(int i=0;i<primes.length;i++) {
            if(!primes[i]) {
                for(int j=2*i;j<primes.length;j+=i)
                    primes[j] = true;
            }
        }
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            StringBuilder sb = new StringBuilder();
            int N = parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            for(int i=0;i<N;i++) {
                boolean yes = false;
                long A = Long.parseLong(st.nextToken());
                double sqrt = Math.sqrt(A);
                if(!primes[(int)Math.round(sqrt)] && Math.abs(sqrt - Math.round(sqrt)) < 1e-10)
                    yes = true;
                sb.append((yes?"YES":"NO") + "\n");
            }
            System.out.print(new String(sb));
        }
    }
}
