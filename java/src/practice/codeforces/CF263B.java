package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/263/B>
 * @category sorting
 * @date 10/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF263B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = parseInt(st.nextToken());
            Arrays.sort(arr);
            if (K > arr.length)
                System.out.println(-1);
            else
                System.out.println(arr[N - K]+" 0");
        }
    }
}
