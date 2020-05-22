package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1352/A>
 * @category math, implementation
 * @date 09/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class CF1352A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            for (int pot = 1; N > 0; N /= 10, pot *= 10) {
                if (N % 10 > 0)
                    list.add(pot * (N % 10));
            }
            System.out.println(list.size());
            System.out.println(list.stream().map(a -> a + "").collect(Collectors.joining(" ")));
        }
    }
}
