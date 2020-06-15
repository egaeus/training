package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/734/B>
 * @category implementation
 * @date 5/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF734B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            long K2 = parseInt(st.nextToken()), K3 = parseInt(st.nextToken()),
                    K5 = parseInt(st.nextToken()), K6 = parseInt(st.nextToken());
            long A = Math.min(K2, Math.min(K5, K6));
            K2 -= A;
            A *= 256;
            System.out.println(A + Math.min(K2, K3) * 32);
        }
    }
}
