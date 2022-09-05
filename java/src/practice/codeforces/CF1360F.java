package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1360/F>
 * @category dp
 * @date 24/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1360F {

    static int N, M;
    static char[][] A;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            A = new char[N][];
            mem = new int[M][1 << N][];
            for (int i = 0; i < N; i++)
                A[i] = in.readLine().toCharArray();
            if (!f(0, 0))
                System.out.println(-1);
            else {
                char[] solution = new char[M];
                int p = 0, diff = 0;
                for (; p < M; p++) {
                    solution[p] = (char) (mem[p][diff][1]+'a');
                    int k = 0;
                    for (int i = 0; i < N; i++)
                        if (A[i][p] - 'a' == mem[p][diff][1])
                            k |= (1 << i);
                    diff = ((diff | (~k)) & ((1 << N) - 1));
                }
                System.out.println(new String(solution));
            }

        }
    }

    static int mem[][][];

    static boolean f(int p, int diff) {
        if (p == M)
            return true;
        if (mem[p][diff] != null)
            return mem[p][diff][0] == 1;
        int[] arr = new int[26];
        for (int i = 0; i < N; i++)
            arr[A[i][p] - 'a'] |= (1 << i);
        boolean ws = false;
        int[] s = new int[]{0, 0};
        for (int i = 0; i < arr.length && !ws; i++)
            if (arr[i] > 0 && (diff & (~arr[i])) == 0)
                if (f(p + 1, (diff | (~arr[i])) & ((1 << N) - 1))) {
                    ws = true;
                    s[0] = 1;
                    s[1] = i;
                }
        mem[p][diff] = s;
        return ws;
    }
}
