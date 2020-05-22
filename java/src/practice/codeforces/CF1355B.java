package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1355/C>
 * @category greedy
 * @date 16/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

import static java.lang.Integer.parseInt;

public class CF1355B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                int key = parseInt(st.nextToken());
                Integer q = map.get(key);
                if (q == null) q = 0;
                q++;
                map.put(key, q);
            }
            long sol = 0;
            int ws = 0;
            for (int key: map.keySet()) {
                int q = map.get(key);
                sol += (ws + q) / key;
                ws = (ws + q) % key;
            }
            sb.append(sol).append("\n");
        }
        System.out.print(new String(sb));
    }
}
