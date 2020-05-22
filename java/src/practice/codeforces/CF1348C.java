package practice.codeforces; /**
 * @author egaeus
 * * @mail sebegaeusprogram@gmail.com
 * * @veredict Accepted
 * * @url <https://codeforces.com/problemset/problem/1348/C>
 * * @category strings
 * * @date 01/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

public class CF1348C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            char[] str = in.readLine().toCharArray();
            Arrays.sort(str);
            if (str[K - 1] != str[0])
                sb.append(str[K - 1]).append("\n");
            else {
                if (K < N && str[K] != str[N - 1]) {
                    sb.append(str[0]);
                    for (int i = K; i < N; i++)
                        sb.append(str[i]);
                    sb.append("\n");
                } else {
                    sb.append(str[0]);
                    for(int i = K; i < N; i+= K)
                        sb.append(str[N-1]);
                    sb.append("\n");
                }
            }
        }
        System.out.print(new String(sb));
    }
}
