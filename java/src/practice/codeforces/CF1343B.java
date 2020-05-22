package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1343/B>
 * @category math
 * @date 11/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class CF1343B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            int half = N/2;
            if(half%2==0) {
                int sum = 0;
                sb.append("YES\n");
                for(int i=0;i<half;i++) {
                    sum += 2 * (i + 1);
                    sb.append(2*(i+1));
                    sb.append(" ");
                }
                for(int i=0;i<half-1;i++) {
                    sum -= 2*i+1;
                    sb.append(2*i+1);
                    sb.append(" ");
                }
                sb.append(sum);
                sb.append("\n");
            }
            else
                sb.append("NO\n");
        }
        System.out.print(new String(sb));
    }
}
