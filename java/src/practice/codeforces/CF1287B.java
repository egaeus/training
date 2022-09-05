package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1287/B>
 * @category implementation, bitwise
 * @date 17/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

public class CF1287B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            char[][] arr = new char[N][];
            for (int i = 0; i < N; i++)
                arr[i] = in.readLine().toCharArray();
            long[] bitwise = new long[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < K; j++) {
                    long v = arr[i][j] == 'S' ? 0 : arr[i][j] == 'E' ? 1 : 2;
                    bitwise[i] |= (v << (2 * j));
                }
            }
            int res = 0;
            for (int i = 0; i < N; i++) {
                TreeMap<Long, Integer> set = new TreeMap<>();
                for (int j = N - 1; j > i; j--) {
                    long value = 0;
                    for (int k = 0; k < K; k++) {
                        long V = arr[i][k] == 'S' ? 0 : arr[i][k] == 'E' ? 1 : 2;
                        if (arr[i][k] != arr[j][k]) {
                            boolean[] letter = new boolean[3];
                            letter[arr[i][k] == 'S' ? 0 : arr[i][k] == 'E' ? 1 : 2] = true;
                            letter[arr[j][k] == 'S' ? 0 : arr[j][k] == 'E' ? 1 : 2] = true;
                            for (int v = 0; v < 3; v++)
                                if (!letter[v])
                                    V = v;
                        }
                        value |= (V << (2 * k));
                    }
                    Integer m = set.get(value);
                    if (m != null)
                        res += m;
                    Integer v = set.get(bitwise[j]);
                    if (v == null)
                        v = 0;
                    v++;
                    set.put(bitwise[j], v);
                }
            }
            System.out.println(res);
        }
    }
}
