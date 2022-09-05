package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/534/A>
 * @category implementation
 * @date 3/06/2020
 **/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF534A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            int[] result = null;
            if (N == 2)
                result = new int[]{1};
            else if (N == 3) result = new int[]{1, 3};
            else if (N == 4) result = new int[]{3, 1, 4, 2};
            else {
                result = new int[N];
                for (int i = 0; i < N / 2 + N % 2; i++)
                    result[i] = 2 * i + 1;
                for (int i = 0; i < N / 2; i++)
                    result[i + N / 2 + N % 2] = 2 * (i + 1);
            }
            System.out.println(result.length);
            System.out.println(IntStream.of(result).mapToObj(a -> a + "").collect(Collectors.joining(" ")));
        }
    }
}
