package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1352/F>
 * @category greedy
 * @date 09/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1352F {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n0 = parseInt(st.nextToken()), n1 = parseInt(st.nextToken()), n2 = parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            sb.append(n0 > 0 || n1 > 0 ? "0" : "1");
            for (int i = 0; i < n0; i++) sb.append("0");
            for (int i = 0; i < n1; i++) {
                sb.append(i % 2 == 0 ? "1" : "0");
                if(i==0)
                    for (int j = 0; j < n2; j++) sb.append("1");
            }
            if(n1 == 0)
                for (int i = 0; i < n2; i++) sb.append("1");
            System.out.println(new String(sb));
        }
    }
}
