package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/492/B
 * @category adhoc
 * @date 5/09/2022
 **/

import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class CF492B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), L = parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(in.readLine());
            for(int i=0;i<N;i++)
                arr[i] = parseInt(st.nextToken());
            Arrays.sort(arr);
            double max = Math.max(arr[0], L - arr[N-1]);
            for(int i=1;i<N;i++)
                max = Math.max(max, (arr[i] - arr[i-1])/2.);
            System.out.println(max);
        }
    }
}
