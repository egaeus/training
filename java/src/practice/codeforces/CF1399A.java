package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1399/A
 * @category array
 * @date 6/09/2022
 **/

import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class CF1399A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());
            int[] arr = new int[N];
            for(int i=0;i<N;i++)
                arr[i] = parseInt(st.nextToken());
            Arrays.sort(arr);
            boolean ws = true;
            for(int i=1;i<N;i++) {
                if(arr[i]-arr[i-1] > 1)
                    ws = false;
            }
            System.out.println(ws?"YES":"NO");
        }
    }
}
