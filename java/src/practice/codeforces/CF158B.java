package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/158/B>
 * @category implementation
 * @date 10/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF158B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            int[] arr = new int[5];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                arr[parseInt(st.nextToken())]++;
            int s = arr[2] / 2 + arr[4] + arr[3] + arr[2] % 2;
            arr[4] = 0;
            arr[2] = arr[2] % 2;
            arr[1] = Math.max(0, arr[1] - arr[3]);
            arr[1] = Math.max(0, arr[1] - arr[2] * 2);
            s += arr[1] / 4 + (arr[1] % 4 == 0 ? 0 : 1);
            System.out.println(s);
        }
    }
}
