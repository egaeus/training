package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1358/D>
 * @category search
 * @date 26/05/2020
 **/

import java.io.*;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1358D {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            long X = Long.parseLong(st.nextToken());
            BigInteger[] D = new BigInteger[2 * N];
            long[] arr = new long[2 * N];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                arr[i + N] = arr[i] = parseInt(st.nextToken());
                D[i + N] = D[i] = BigInteger.valueOf(((arr[i + N]) * (arr[i + N] + 1)) / 2);
            }
            for (int i = 1; i < 2 * N; i++) {
                D[i] = D[i - 1].add(D[i]);
                arr[i] += arr[i - 1];
            }
            //System.out.println(Arrays.toString(arr));
            //System.out.println(Arrays.toString(D));
            long s = Long.MIN_VALUE;
            for (int i = 2 * N - 1; i >= N; i--) {
                long v = arr[i] - arr[i - 1];
                long search = arr[i] - X;
                if (search >= 0) {
                    int bs = Arrays.binarySearch(arr, search);
                    if (bs >= 0) {
                        s = Math.max(s, D[i].subtract(D[bs]).longValue());
                        //System.out.println("<<<<--->>>>>"+i+" "+(D[i] - D[bs]));
                    } else {
                        bs = -bs;
                        BigInteger S = D[i].subtract(bs > 0 ? D[bs - 1] : BigInteger.ZERO);
                        search = X - (arr[i] - (bs > 0 ? arr[bs - 1] : 0));
                        long x = bs > 0 ? arr[bs - 1] - (bs > 1 ? arr[bs - 2] : 0) : search;
                        S = S.add(BigInteger.valueOf((x * (x + 1)) / 2 - ((x - search) * (x - search + 1)) / 2));
                        s = Math.max(s, S.longValue());
                    }
                }
            }
            System.out.println(s);
        }
    }
}

