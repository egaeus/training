package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/723/A
 * @category adhoc
 * @date 6/09/2022
 **/

import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class CF723A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int arr[] = new int[3];
            arr[0] = parseInt(st.nextToken());
            arr[1] = parseInt(st.nextToken());
            arr[2] = parseInt(st.nextToken());
            Arrays.sort(arr);
            System.out.println(arr[2] - arr[0]);
        }
    }
}
