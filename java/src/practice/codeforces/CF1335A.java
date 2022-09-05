package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1335/A
 * @category math
 * @date 5/09/2022
 **/

import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class CF1335A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for(int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            System.out.println(N%2==0?N/2-1:N/2);
        }
    }
}
