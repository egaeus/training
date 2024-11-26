package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Not sended
 * @url
 * @category
 * @date 6/09/2022
 **/

import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class CF117E {
    static TreeSet<Integer> lAdy[];
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            lAdy = new TreeSet[N];
            for(int i=0;i<N;i++)
                lAdy[i] = new TreeSet<>();
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(in.readLine());
                int u = parseInt(st.nextToken()) - 1, v = parseInt(st.nextToken()) - 1;
                lAdy[u].add(v);
                lAdy[v].add(u);
            }
        }
    }

}
