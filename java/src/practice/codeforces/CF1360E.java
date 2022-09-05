package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1360/E>
 * @category greedy
 * @date 24/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1360E {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            char[][] seq = new char[N][];
            for (int i = 0; i < N; i++)
                seq[i] = in.readLine().toCharArray();
            boolean ws = true;
            for (int i = 0; i < N && ws; i++)
                for (int j = 0; j < N && ws; j++)
                    if (seq[i][j] == '1')
                        ws = i == N - 1 || j == N - 1 || seq[i + 1][j] == '1' || seq[i][j + 1] == '1';
            System.out.println(ws?"YES":"NO");
        }
    }
}
