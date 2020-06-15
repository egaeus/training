package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/61/B>
 * @category implementation
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF61B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            String A = ln.replaceAll("[;_-]", "").toLowerCase();
            String B = in.readLine().replaceAll("[;_-]", "").toLowerCase();
            String C = in.readLine().replaceAll("[;_-]", "").toLowerCase();
            String[] array = new String[]{A + B + C, A + C + B, B + A + C, B + C + A, C + A + B, C + B + A};
            int N = parseInt(in.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                boolean ws = false;
                String t = in.readLine().replaceAll("[;_-]", "").toLowerCase();
                for (int j = 0; j < array.length && !ws; j++)
                    if (t.equals(array[j]))
                        ws = true;
                sb.append(ws?"ACC":"WA").append("\n");
            }
            System.out.print(new String(sb));
        }
    }
}
