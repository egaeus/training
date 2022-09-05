package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/771/B>
 * @category implementation
 * @date 14/06/2020
 **/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF771B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            String[] result = new String[N];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N - K + 1; i++) {
                if (st.nextToken().equals("YES")) {
                    for (int j = i; j < i + K; j++)
                        if (result[j] == null)
                            result[j] = getName(j);
                } else {
                    if (result[i] == null) {
                        result[i] = getName(i);
                        result[i + K - 1] = getName(i);
                    } else result[i + K - 1] = result[i];
                }
            }
            for (int i = 0; i < N; i++)
                if (result[i] == null)
                    result[i] = getName(i);
            System.out.println(Stream.of(result).collect(Collectors.joining(" ")));
        }
    }

    static String getName(int p) {
        if (p < 26)
            return (char) (p + 'A') + "";
        return (char) (p / 26 + 'A') +"" + (char) (p % 26 + 'a');
    }
}
