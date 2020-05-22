package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1354/A>
 * @category math
 * @date 17/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1354A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long A = parseInt(st.nextToken()), B = parseInt(st.nextToken()),
                    C = parseInt(st.nextToken()), D = parseInt(st.nextToken());
            if(B>=A)
                System.out.println(B);
            else if(C<=D)
                System.out.println(-1);
            else
                System.out.println(B+(long)Math.ceil(1.*(A-B)/(C-D))*C);
        }
    }
}
