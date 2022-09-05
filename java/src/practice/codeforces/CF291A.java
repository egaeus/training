package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/291/A>
 * @category implementation
 * @date 29/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

import static java.lang.Integer.parseInt;

public class CF291A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            int N = parseInt(ln);
            TreeMap<Integer, Integer> map = new TreeMap<>();
            StringTokenizer st = new StringTokenizer(in.readLine());
            boolean ws = true;
            int c=0;
            for (int i = 0; i < N; i++) {
                int a = parseInt(st.nextToken());
                if(a>0) {
                    Integer v = map.get(a);
                    if(v==null)v=0;
                    v++;
                    map.put(a, v);
                    if(v>2)ws = false;
                    if(v==2)c++;
                }
            }
            System.out.println(ws?c:-1);
        }
    }
}
