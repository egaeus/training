package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/4/C
 * @category adhoc
 * @date 5/09/2022
 **/

import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class CF4C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            TreeMap<String, Integer> map = new TreeMap<>();
            for(int i=0;i<N;i++) {
                String name = in.readLine();
                Integer number = map.get(name);
                if(number == null) {
                    map.put(name, 1);
                    sb.append("OK\n");
                } else {
                    map.put(name, number + 1);
                    name = name + number;
                    map.put(name, 1);
                    sb.append(name+"\n");
                }
            }
            System.out.print(new String(sb));
        }
    }
}
