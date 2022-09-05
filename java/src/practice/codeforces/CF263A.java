package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/263/A>
 * @category implementation
 * @date 26/05/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF263A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int p[] = null;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 5; j++)
                if (parseInt(st.nextToken()) == 1)
                    p = new int[]{i, j};
        }
        System.out.println(abs(2-p[1])+abs(2-p[0]));
    }
}
