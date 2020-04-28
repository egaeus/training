package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict TLE
 * @url https://codeforces.com/problemset/problem/1234/F
 * @category bitmasks
 * @date 03/10/2019
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CF1234F {

    static boolean arr[] = new boolean[1 << 20];
    static char[] s;
    static Map<Long, Integer> map;

    public static void main(String args[]) throws Throwable {
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader("in.in"));
        for (String ln; (ln = in.readLine()) != null; ) {
            s = ln.toCharArray();
            arr = new boolean[1 << 20];
            map = new HashMap<>();
            for (int i = 0; i < s.length; i++) {
                int t = 0;
                for (int j = i; j < s.length; j++)
                    if ((t & (1 << (s[j] - 'a'))) == 0) {
                        t |= (1 << (s[j] - 'a'));
                        arr[t] = true;
                    } else break;
            }
            int max = f(0, 0);
            System.out.println(max);
        }
    }

    static int f(int u, int v) {
        long t = (u | v) ^ (u & v);
        Integer res = map.get(t);
        if (res != null)
            return res;
        int max = 0;
        for (int p = 0; p < 20; p++) {
            if ((u & (1 << p)) == 0 && (v & (1 << p)) == 0) {
                if (arr[u | (1 << p)])
                    max = Math.max(max, f(u | (1 << p), v) + 1);
                if (arr[v | (1 << p)])
                    max = Math.max(max, f(u, v | (1 << p)) + 1);
            }
        }
        map.put(t, max);
        return max;
    }
}
