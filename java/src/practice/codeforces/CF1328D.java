package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1328/D
 * @category dp
 * @date 13/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class CF1328D {

    static int arr[];

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            mem = new int[N][3][3][];
            TreeSet<Integer> set = new TreeSet<>();
            int[] result = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = parseInt(st.nextToken());
                set.add(arr[i]);
            }
            if (set.size() == 1) {
                Arrays.fill(result, 1);
                sb.append("1").append("\n");
            } else {
                sb.append(f(1, 0, 0) + 1).append("\n");
                result[0] = 1;
                int p = 1, c = 0, max = 0;
                for (; p < arr.length; p++) {
                    if (mem[p][c][max][1] != -1) {
                        c = mem[p][c][max][1];
                        max = Math.max(max, c);
                    }
                    result[p] = c + 1;
                }
            }
            sb.append(IntStream.of(result).mapToObj(a -> a + "").collect(Collectors.joining(" "))).append("\n");
        }
        System.out.print(new String(sb));
    }

    static int[][][][] mem;

    static int f(int p, int c, int max) {
        if (p == arr.length) {
            if (arr[0] != arr[arr.length - 1] && c == 0)
                return Integer.MAX_VALUE;
            return max;
        }
        if (mem[p][c][max] != null)
            return mem[p][c][max][0];
        int min = Integer.MAX_VALUE, mov = 0;
        if (arr[p - 1] == arr[p]) {
            min = f(p + 1, c, max);
            mov = -1;
        }
        for (int i = 0; i < 3; i++)
            if (c != i && min > f(p + 1, i, Math.max(i, max))) {
                mov = i;
                min = f(p + 1, i, Math.max(i, max));
            }
        mem[p][c][max] = new int[]{min, mov};
        return min;
    }
}
