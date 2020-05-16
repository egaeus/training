/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1353/A
 * @category greedy
 * @date 14/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CFA {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            if (N == 1) System.out.println(0);
            else if(N==2) System.out.println(M);
            else {
                System.out.println(2*M);
            }
        }
    }
}
