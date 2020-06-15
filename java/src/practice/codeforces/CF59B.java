package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/59/B>
 * @category implementation
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF59B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            int[] arr = new int[N];
            int sum = 0;
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                sum += (arr[i] = parseInt(st.nextToken()));
            if (sum % 2 == 1)
                System.out.println(sum);
            else {
                boolean ws = false;
                Arrays.sort(arr);
                for (int i = 0; i < N && !ws; i++)
                    if (arr[i] % 2 == 1) {
                        System.out.println(sum - arr[i]);
                        ws = true;
                    }
                if (!ws)
                    System.out.println(0);
            }
        }
    }
}
