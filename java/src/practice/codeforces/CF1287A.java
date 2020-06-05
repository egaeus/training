package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1287/A>
 * @category implementation
 * @date 3/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1287A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            char[] A = in.readLine().toCharArray();
            int steps = 0;
            boolean change = true;
            for (; change; ) {
                change = false;
                for (int i = 0; i < N - 1; i++)
                    if (A[i] == 'A' && A[i + 1] == 'P') {
                        change = true;
                        A[i + 1] = 'A';
                        i++;
                    }
                if (change)
                    steps++;
            }
            System.out.println(steps);
        }
    }
}
