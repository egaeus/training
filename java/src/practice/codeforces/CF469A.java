package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Not sended
 * @url <https://codeforces.com/problemset/problem/>
 * @category ?
 * @date 27/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF469A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int N = parseInt(ln);
            boolean[] arr = new boolean[N];
            for (int K = 0; K < 2; K++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                int A = parseInt(st.nextToken());
                for (int i = 0; i < A; i++)
                    arr[parseInt(st.nextToken()) - 1] = true;
            }
            boolean ws = true;
            for(int i=0;i<N;i++)
                ws &= arr[i];
            System.out.println(ws?"I become the guy.":"Oh, my keyboard!");
        }
    }
}
