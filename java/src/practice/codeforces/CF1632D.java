package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1362/D>
 * @category implementation
 * @date 4/06/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class CF1632D {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null && !ln.equals(""); ) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
            TreeSet<Integer> lAdy[] = new TreeSet[N];
            int[][] arr = new int[M][];
            for (int i = 0; i < N; i++) {
                lAdy[i] = new TreeSet<>();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int u = parseInt(st.nextToken()) - 1, v = parseInt(st.nextToken()) - 1;
                arr[i] = new int[]{u, v};
            }
            st = new StringTokenizer(in.readLine());
            int[] c = new int[N];
            int[][] solution = new int[N][];
            for (int i = 0; i < N; i++) {
                c[i] = parseInt(st.nextToken()) - 1;
                solution[i] = new int[]{i + 1, c[i]};
            }
            Arrays.sort(solution, Comparator.comparingInt(a -> a[1]));
            boolean ws = true;
            for (int i = 0; i < M; i++) {
                if (c[arr[i][0]] >= c[arr[i][1]])
                    lAdy[arr[i][0]].add(c[arr[i][1]]);
                if (c[arr[i][0]] <= c[arr[i][1]])
                    lAdy[arr[i][1]].add(c[arr[i][0]]);
            }
            for (int i = 0; i < N && ws; i++)
                ws = lAdy[i].size() == c[i] && !lAdy[i].contains(c[i]);
            if (!ws)
                sb.append(-1).append("\n");
            else {
                for(int i=0;i<N;i++)
                    sb.append(i>0?" ":"").append(solution[i][0]);
                sb.append("\n");
            }
            System.out.print(new String(sb));
        }
    }
}
