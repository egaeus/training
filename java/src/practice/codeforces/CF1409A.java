package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1409/A
 * @category adhoc
 * @date 6/09/2022
 **/

import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class CF1409A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long abs = Math.abs(Long.parseLong(st.nextToken()) - Long.parseLong(st.nextToken()));
            System.out.println(abs/10 + (abs%10==0?0:1));
        }
    }

}
