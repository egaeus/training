package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/231/B>
 * @category dp
 * @date 10/06/2020
 **/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF231B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            N = parseInt(st.nextToken());
            D = parseInt(st.nextToken());
            L = parseInt(st.nextToken());
            mem = new int[N][40000];
            if (!f(0, D))
                System.out.println(-1);
            else {
                int[] solution = new int[N];
                int p = 0, d = D;
                for (; p < N - 1; p++) {
                    solution[p] = mem[p][d + 20000];
                    d = solution[p] - d;
                }
                solution[N - 1] = d;
                System.out.println(IntStream.of(solution).mapToObj(a -> a + "").collect(Collectors.joining(" ")));
            }
        }
    }

    static int N, D, L;
    static int[][] mem;

    static boolean f(int p, int d) {
        if (p == N - 1)
            return d > 0 && d <= L;
        if (mem[p][d + 20000] != 0)
            return mem[p][d + 20000] > 0;
        for (int i = 1; i <= L; i++)
            if (f(p + 1, i - d)) {
                mem[p][d + 20000] = i;
                return true;
            }
        mem[p][d + 20000] = -1;
        return false;
    }
}
