package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1340/B>
 * @category dp
 * @date 8/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1340B {
    static char[][] numbers = new char[][]{
            "1110111".toCharArray(),
            "0010010".toCharArray(),
            "1011101".toCharArray(),
            "1011011".toCharArray(),
            "0111010".toCharArray(),
            "1101011".toCharArray(),
            "1101111".toCharArray(),
            "1010010".toCharArray(),
            "1111111".toCharArray(),
            "1111011".toCharArray()
    };

    static int N;
    static char[][] n;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(ln);
            N = parseInt(st.nextToken());
            int K = parseInt(st.nextToken());
            n = new char[N][];
            for (int i = 0; i < N; i++)
                n[i] = in.readLine().toCharArray();
            mem = new int[N][K + 1];
            for (int i = N; i >= 0; i--)
                for (int k = 0; k <= K; k++)
                    f(i, k);
            boolean ws = f(0, K);
            if (ws) {
                int p = 0;
                for (; p < N; p++) {
                    int v = mem[p][K] - 1;
                    sb.append(v);
                    int diff = 0;
                    for (int j = 0; j < 7; j++)
                        if (numbers[v][j] == '1' && n[p][j] == '0')
                            diff++;
                    K -= diff;
                }
                sb.append("\n");
            } else sb.append(-1).append("\n");
            System.out.print(new String(sb));
        }
    }

    static int mem[][];

    static boolean f(int p, int K) {
        if (K < 0)
            return false;
        if (p == N)
            return K == 0;
        if (mem[p][K] != 0)
            return mem[p][K] > 0;
        for (int i = 9; i >= 0; i--) {
            boolean can = true;
            int diff = 0;
            for (int j = 0; j < 7 && can; j++) {
                if (numbers[i][j] == '1' && n[p][j] == '0')
                    diff++;
                if (numbers[i][j] == '0' && n[p][j] == '1')
                    can = false;
            }
            if (can && f(p + 1, K - diff)) {
                mem[p][K] = i + 1;
                return true;
            }
        }
        mem[p][K] = -1;
        return false;
    }
}
