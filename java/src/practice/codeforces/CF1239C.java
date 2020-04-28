package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict
 * @url
 * @category
 * @date
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.lang.Integer.parseInt;

public class CF1239C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            long P = parseInt(st.nextToken());
            int[][] arr = new int[N][];
            long[] vals = new long[N];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = new int[]{parseInt(st.nextToken()), i};
                vals[i] = arr[i][0];
            }
            TreeSet<Integer> set = new TreeSet<>();
            Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            long[] R = new long[N];
            long S = 0;
            int p = 0;
            for (int i = 0; i < N; i++) {
                for (; p < N && arr[p][0] <= S; )
                    if (arr[p][0] <= S)
                        set.add(arr[p++][1]);
                if (set.isEmpty())
                    set.add(arr[p++][1]);
                int q = set.pollFirst();
                S = Math.max(S, vals[q]) + P;
                R[q] = S;
            }
            System.out.println(LongStream.of(R).mapToObj(a -> a + "").collect(Collectors.joining(" ")));
        }
    }
}