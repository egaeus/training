package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1339/C>
 * @category math
 * @date 10/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1339C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            long[] arr = new long[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < arr.length; i++)
                arr[i] = parseInt(st.nextToken());
            long last = arr[0];
            int time = 0;
            for (int i = 1; i < arr.length; i++)
                if (arr[i] < last) {
                    long v = last - arr[i];
                    if ((time == 0 && v > 0) || time < Long.toBinaryString(v).length())
                        time = Long.toBinaryString(v).length();
                } else last = arr[i];
            System.out.println(time);
        }
    }
}
