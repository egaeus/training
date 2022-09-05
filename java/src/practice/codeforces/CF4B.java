package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/4/B>
 * @category dp
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF4B {
    static int[][] arr;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), sum = parseInt(st.nextToken());
            arr = new int[N][];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                arr[i] = new int[]{parseInt(st.nextToken()), parseInt(st.nextToken())};
            }
            mem = new int[N][sum + 1];
            if (f(0, sum)) {
                System.out.println("YES");
                int[] result = new int[N];
                for (int p = 0; p < N; p++) {
                    result[p] = mem[p][sum] - 1;
                    sum -= result[p];
                }
                System.out.println(IntStream.of(result).mapToObj(noName -> noName + "").collect(Collectors.joining(" ")));
            } else System.out.println("NO");
        }
    }

    static int[][] mem;

    static boolean f(int p, int sum) {
        if (sum < 0)
            return false;
        if (p == arr.length)
            return sum == 0;
        if (mem[p][sum] != 0)
            return mem[p][sum] > 0;
        for (int i = arr[p][0]; i <= arr[p][1]; i++)
            if (f(p + 1, sum - i)) {
                mem[p][sum] = i + 1;
                return true;
            }
        mem[p][sum] = -1;
        return false;
    }
}
