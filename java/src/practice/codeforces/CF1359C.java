package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1359/C>
 * @category math
 * @date 28/05/2020
 **/

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1359C {
    static int H, C,K;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            H = parseInt(st.nextToken());
            C = parseInt(st.nextToken());
            K = parseInt(st.nextToken());
            BigDecimal k = BigDecimal.valueOf(K);
            double search = 1. * (H - K) / (2 * K - H - C);
            long a = Math.max(1, (long) (2 * Math.ceil(search) - 1)),
                    b = Math.max(1, (long) Math.ceil(2 * Math.ceil(search) + 1));
            BigDecimal[][] arr = new BigDecimal[][]{{BigDecimal.valueOf(a), f1(a)}, {BigDecimal.valueOf(b), f1(b)}, {BigDecimal.valueOf(2), f1(2)}};
            Arrays.sort(arr, (A, B) -> A[1].subtract(k).abs().compareTo(B[1].subtract(k).abs()) != 0?A[1].subtract(k).abs().compareTo(B[1].subtract(k).abs()):A[0].compareTo(B[0]));
            System.out.println(arr[0][0].longValue());
        }
    }

    static BigDecimal f1(long x) {
        return BigDecimal.valueOf(1. * ((x / 2) * C + ((x / 2) + (x % 2)) * H)).divide(BigDecimal.valueOf(x), MathContext.DECIMAL128);
    }
}

