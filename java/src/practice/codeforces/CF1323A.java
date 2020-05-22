package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1323/A>
 * @category math
 * @date 21/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1323A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());
            TreeSet<Integer> even = new TreeSet<>();
            TreeSet<Integer> odd = new TreeSet<>();
            for (int i = 0; i < N; i++) {
                int u = parseInt(st.nextToken());
                if (u % 2 == 0) even.add(i + 1);
                else odd.add(i + 1);
                if (odd.size() == 2 || even.size() == 1)
                    break;
            }
            if (odd.size() == 2) {
                System.out.println(2);
                System.out.println(odd.first() + " " + odd.last());
            } else if (even.size() == 1) {
                System.out.println(1);
                System.out.println(even.first());
            } else System.out.println(-1);
        }
    }
}
