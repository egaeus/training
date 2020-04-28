package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1238/B
 * @category greedy
 * @date 09/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

public class CF1238B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int Q = parseInt(in.readLine()), q = 0; q++ < Q; ) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), R = parseInt(st.nextToken());
            TreeSet<Integer> set = new TreeSet<>();
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                set.add(parseInt(st.nextToken()));
            int S = 0;
            for (int s : set.descendingSet()) {
                if (s - S * R <= 0) break;
                else S++;
            }
            System.out.println(S);
        }
    }
}
