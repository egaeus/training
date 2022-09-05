package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1352/G>
 * @category constructive algorithms
 * @date 09/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class CF1352G {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            if (N > 4) {
                ArrayList<Integer> result = new ArrayList<>();
                for (int i = N - N % 2; i > 0; i -= 2)
                    result.add(i);
                result.add(5);
                result.add(1);
                result.add(3);
                for (int i = 7; i <= N; i += 2)
                    result.add(i);
                System.out.println(result.stream().map(a -> a + "").collect(Collectors.joining(" ")));
            } else if (N == 4)
                System.out.println("3 1 4 2");
            else
                System.out.println(-1);
        }
    }
}
