package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1363/D>
 * @category binary search
 * @date 2/06/2020
 **/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1363D {
    static int[][] sets;

    static void generateCase() {
        int T = 1;
        int N = 802, K = 802;
        StringBuilder sb = new StringBuilder();
        sb.append(T).append("\n");
        sb.append(N + " " + K).append("\n");
        for (int i = 0; i < K; i++)
            sb.append(1 + " " + (i + 1) + "\n");
        System.out.println(new String(sb));
    }

    public static void main(String args[]) throws Throwable {
        //generateCase();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            sets = new int[K][];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(in.readLine());
                sets[i] = new int[parseInt(st.nextToken())];
                for (int j = 0; j < sets[i].length; j++)
                    sets[i][j] = parseInt(st.nextToken());
            }
            System.out.println("? " + N);
            System.out.println(IntStream.range(1, N + 1).mapToObj(a -> a + "").collect(Collectors.joining(" ")));
            System.out.flush();
            int max = parseInt(in.readLine());
            int[] solution = new int[K];
            f(0, K, solution, max, in, N);
            System.out.print("! ");
            System.out.println(IntStream.of(solution).mapToObj(a -> a + "").collect(Collectors.joining(" ")));
            System.out.flush();
            in.readLine();
        }
    }

    static void f(int a, int b, int[] solution, int max, BufferedReader in, int N) throws Throwable {
        if (b - a == 1) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 1; i <= N; i++)
                set.add(i);
            for (int i : sets[a])
                set.remove(i);
            System.out.println("? " + set.size());
            System.out.println(set.stream().map(A -> A + "").collect(Collectors.joining(" ")));
            System.out.flush();
            solution[a] = parseInt(in.readLine());
        } else {
            int p = (a + b) / 2;
            int response = getMax(a, p, in);
            if (response < max) {
                Arrays.fill(solution, a, p, max);
                f(p, b, solution, max, in, N);
            } else {
                Arrays.fill(solution, p, b, max);
                f(a, p, solution, max, in, N);
            }
        }
    }

    static int getMax(int a, int b, BufferedReader in) throws Throwable {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = a; i < b; i++)
            for (int t : sets[i])
                set.add(t);
        System.out.println("? " + set.size());
        System.out.println(set.stream().map(A -> A + "").collect(Collectors.joining(" ")));
        System.out.flush();
        return parseInt(in.readLine());
    }
}
