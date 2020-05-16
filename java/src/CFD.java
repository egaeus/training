/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1353/D
 * @category implementation
 * @date 14/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class CFD {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            int[] result = new int[N];
            TreeSet<int[]> set = new TreeSet<>((a, b) -> a[1] - a[0] < b[1] - b[0] ? 1 : a[1] - a[0] > b[1] - b[0] ? -1 : a[0] - b[0]);
            set.add(new int[]{0, N});
            int i = 1;
            while (!set.isEmpty()) {
                int[] first = set.pollFirst();
                int v = first[0] + (first[1] - first[0] - 1) / 2;
                result[v] = i;
                if (first[0] < v)
                    set.add(new int[]{first[0], v});
                if (first[1] > v + 1)
                    set.add(new int[]{v + 1, first[1]});
                i++;
            }
            sb.append(IntStream.of(result).mapToObj(a-> a+"").collect(Collectors.joining(" "))).append("\n");
        }
        System.out.print(new String(sb));
    }
}
