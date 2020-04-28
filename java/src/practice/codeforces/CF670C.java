package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/670/C
 * @category implementation
 * @date 16/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

import static java.lang.Integer.parseInt;

public class CF670C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            int N = parseInt(ln);
            StringTokenizer st = new StringTokenizer(in.readLine());
            int[] A = new int[N];
            for (int i = 0; i < N; i++)
                A[i] = parseInt(st.nextToken());
            int M = parseInt(in.readLine());
            int[] B = new int[M];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < M; i++)
                B[i] = parseInt(st.nextToken());
            int[] C = new int[M];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < M; i++)
                C[i] = parseInt(st.nextToken());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int a : A)
                if (map.containsKey(a))
                    map.put(a, map.get(a) + 1);
                else
                    map.put(a, 1);
            int[][] satisfied = new int[M][2];
            int betterSolution = 0;
            for (int i = 0; i < M; i++) {
                if (map.containsKey(B[i]))
                    satisfied[i][0] = map.get(B[i]);
                if (map.containsKey(C[i]))
                    satisfied[i][1] = map.get(C[i]);
                if(satisfied[betterSolution][0] < satisfied[i][0] ||
                        (satisfied[betterSolution][0] == satisfied[i][0] && satisfied[betterSolution][1] < satisfied[i][1]))
                    betterSolution = i;
            }
            System.out.println(betterSolution+1);
        }
    }
}
