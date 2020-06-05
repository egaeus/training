package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/296/A>
 * @category implementation
 * @date 3/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF296A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            int[] numbers = new int[1001];
            for (int i = 0; i < N; i++)
                numbers[parseInt(st.nextToken())]++;
            boolean ws = true;
            for (int i = 0; i < numbers.length; i++)
                if (numbers[i] > N / 2 + N % 2)
                    ws = false;
            System.out.println(ws ? "YES" : "NO");
        }
    }
}
