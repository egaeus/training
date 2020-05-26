package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1358/B>
 * @category implementation
 * @date 26/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1358B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                int v = parseInt(st.nextToken());
                Integer a = map.get(v);
                if (a == null)
                    a = 0;
                a++;
                map.put(v, a);
            }
            int max = 1;
            int s = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                s += entry.getValue();
                max = Math.max(max, s >= entry.getKey() ? s + 1 : 0);
            }
            System.out.println(max);
        }
    }
}
