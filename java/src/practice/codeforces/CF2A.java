package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/2/A>
 * @category implementation
 * @date 3/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF2A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            String[] names = new String[N];
            int[] points = new int[N];
            TreeMap<String, Integer> map = new TreeMap<>();
            String winner = null;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                String name = st.nextToken();
                int point = parseInt(st.nextToken());
                if (map.containsKey(name))
                    map.put(name, map.get(name) + point);
                else
                    map.put(name, point);
                names[i] = name;
                points[i] = point;
            }
            int max = MIN_VALUE;
            TreeSet<String> winners = new TreeSet<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                int a = entry.getValue();
                if (max < a) {
                    max = Math.max(a, max);
                    winners.clear();
                    winners.add(entry.getKey());
                } else if (max == a)
                    winners.add(entry.getKey());
            }
            map = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                String name = names[i];
                int point = points[i];
                if (map.containsKey(name))
                    map.put(name, map.get(name) + point);
                else
                    map.put(name, point);
                if (map.get(name) >= max && winner == null && winners.contains(name))
                    winner = name;
            }
            System.out.println(winner);
        }
    }
}
