package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/467/B>
 * @category bitwise
 * @date 9/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF467B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            int[] arr = new int[M];
            for (int i = 0; i < M; i++)
                arr[i] = parseInt(in.readLine());
            int m = parseInt(in.readLine());
            int s = 0;
            for(int i=0;i<M;i++)
                if(bitCount(arr[i]^m)<=K)
                    s++;
            System.out.println(s);
        }
    }
}
