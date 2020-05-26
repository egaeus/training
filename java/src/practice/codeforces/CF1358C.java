package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1358/C>
 * @category math
 * @date 26/05/2020
 **/

import java.io.*;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1358C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long X1 = parseInt(st.nextToken()), Y1 = parseInt(st.nextToken()),
                    X2 = parseInt(st.nextToken()), Y2 = parseInt(st.nextToken());
            long A = X2 - X1 + 1, B = Y2 - Y1 + 1;
            System.out.println(A * B - A - B + 2);
        }
    }
}
