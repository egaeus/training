package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1154/A
 * @category math
 * @date 5/09/2022
 **/

import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class CF1154A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int[] arr = new int[]{parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken())};
            Arrays.sort(arr);
            System.out.println((arr[3]-arr[0])+" "+(arr[3]-arr[1])+" "+(arr[3]-arr[2]));
        }
    }
}
