package practice.codeforces; /**
 * @author egaeus
 * * @mail jsbeltran.valhalla@gmail.com
 * * @veredict Accepted
 * * @url <https://codeforces.com/problemset/problem/1348/B>
 * * @category adhoc
 * * @date 01/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

public class CF1348B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t++ < T; ) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(in.readLine());
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < N; i++) {
                arr[i] = parseInt(st.nextToken());
                set.add(arr[i]);
            }
            if (set.size() > K)
                sb.append(-1).append("\n");
            else {
                for (int i = 1; i <= N && set.size() < K; i++)
                    set.add(i);
                sb.append(set.size()*N).append("\n");
                boolean first = true;
                for(int i = 0; i < N; i++)
                    for(int number: set) {
                        sb.append(first?"":" ").append(number);
                        first = false;
                    }
                sb.append("\n");
            }
        }
        System.out.print(new String(sb));
    }
}
