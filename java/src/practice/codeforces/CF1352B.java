package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1352/B
 * @category constructive algorithms
 * @date 09/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class CF1352B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken());
            int K = parseInt(st.nextToken());
            ArrayList<Integer> odd = new ArrayList<>();
            ArrayList<Integer> even = new ArrayList<>();
            for (int i = 0; i < K - 1; i++) {
                odd.add(1);
                even.add(2);
            }
            if ((N - odd.size()) % 2 == 1 && N > odd.size()) {
                odd.add(N - odd.size());
                System.out.println("YES");
                System.out.println(odd.stream().map(a -> a + "").collect(Collectors.joining(" ")));
            } else if (N > even.size() * 2 && (N - 2 * odd.size()) % 2 == 0) {
                even.add(N - 2 * odd.size());
                System.out.println("YES");
                System.out.println(even.stream().map(a -> a + "").collect(Collectors.joining(" ")));
            } else
                System.out.println("no");
        }
    }
}
