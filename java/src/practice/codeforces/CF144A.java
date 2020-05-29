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

public class CF144A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            int N = parseInt(ln);
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            int pMin = 0, pMax = 0;
            for (int i = 0; i < N; i++) {
                int v = parseInt(st.nextToken());
                arr[i] = v;
                if (arr[i] <= arr[pMin])
                    pMin = i;
                if (arr[i] > arr[pMax])
                    pMax = i;
            }
            int s = pMax + (N - pMin - 1);
            if (pMin < pMax) s--;
            System.out.println(s);
        }
    }
}
