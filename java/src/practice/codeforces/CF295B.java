package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/295/B>
 * @category graph
 * @date 28/10/2019
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.lang.Integer.parseInt;

public class CF295B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader in = new BufferedReader(new FileReader("in.in"));
        long T = System.currentTimeMillis();
        for (String ln; (ln = in.readLine()) != null; ) {
            int N = parseInt(ln);
            long[][] solution = new long[N][N];
            long[] res = new long[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++)
                    solution[i][j] = parseInt(st.nextToken());
            }
            StringTokenizer st = new StringTokenizer(in.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = parseInt(st.nextToken()) - 1;
            boolean[] v = new boolean[N];
            for (int I = N - 1; I >= 0; I--) {
                int k = arr[I];
                v[k] = true;
                res[I] = 0;
                for (int i = 0; i < N; i++)
                    if (v[i])
                        for (int j = 0; j < N; j++)
                            if (v[j]) {
                                if (solution[i][k] > solution[i][j] + solution[j][k])
                                    solution[i][k] = solution[i][j] + solution[j][k];
                                if (solution[k][j] > solution[k][i] + solution[i][j])
                                    solution[k][j] = solution[k][i] + solution[i][j];
                            }
                for (int i = 0; i < N; i++)
                    for (int j = 0; j < N; j++) {
                        if ((v[i] || v[j]) && solution[i][k] + solution[k][j] < solution[i][j]) {
                            solution[i][j] = solution[i][k] + solution[k][j];
                        }
                        if (v[i] && v[j])
                            res[I] += solution[i][j];
                    }

            }
            System.out.println(LongStream.of(res).mapToObj(a -> a + "").collect(Collectors.joining(" ")));
        }
        //System.out.println(T - System.currentTimeMillis());
    }
}
