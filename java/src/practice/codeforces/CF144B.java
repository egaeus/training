package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/144/B>
 * @category math
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF144B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int XA = parseInt(st.nextToken()), YA = parseInt(st.nextToken()),
                    XB = parseInt(st.nextToken()), YB = parseInt(st.nextToken());
            int N = parseInt(in.readLine());
            int[][] cirulos = new int[N][];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                cirulos[i] = new int[]{parseInt(st.nextToken()), parseInt(st.nextToken()), parseInt(st.nextToken())};
            }
            int s = 0;
            for (int i = Math.min(XA, XB); i <= Math.max(XA, XB); i++) {
                boolean ws1 = false, ws2= false;
                for (int j = 0; j < N; j++) {
                    if ((cirulos[j][0] - i) * (cirulos[j][0] - i) + (cirulos[j][1] - YA) * (cirulos[j][1] - YA) <= cirulos[j][2] * cirulos[j][2]) {
                        ws1 = true;
                    }
                    if ((cirulos[j][0] - i) * (cirulos[j][0] - i) + (cirulos[j][1] - YB) * (cirulos[j][1] - YB) <= cirulos[j][2] * cirulos[j][2]) {
                        ws2 = true;
                    }
                }
                if (!ws1)
                    s++;
                if (!ws2)
                    s++;
            }
            for (int i = Math.min(YA, YB) + 1; i < Math.max(YA, YB); i++) {
                boolean ws1 = false, ws2 = false;
                for (int j = 0; j < N; j++) {
                    if ((cirulos[j][0] - XA) * (cirulos[j][0] - XA) + (cirulos[j][1] - i) * (cirulos[j][1] - i) <= cirulos[j][2] * cirulos[j][2])
                        ws1 = true;
                    if ((cirulos[j][0] - XB) * (cirulos[j][0] - XB) + (cirulos[j][1] - i) * (cirulos[j][1] - i) <= cirulos[j][2] * cirulos[j][2])
                        ws2 = true;
                }
                if (!ws1)
                    s++;
                if (!ws2)
                    s++;
            }
            System.out.println(s);
        }
    }
}
