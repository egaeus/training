package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict
 * @url https://codeforces.com/problemset/problem/1239/D
 * @category implementation
 * @date
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class CF1239D {

    static int N;
    static ArrayList<int[]> p;
    static int[][][][] mem;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int T = parseInt(in.readLine()), t = 0; t < T; t++) {
            if (t > 0) in.readLine();
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = parseInt(st.nextToken());
            int M = parseInt(st.nextToken());
            initSet(2*N);
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int u = parseInt(st.nextToken()) - 1;
                int v = parseInt(st.nextToken()) - 1 + N;
                unionSet(u, v);
            }
            p = new ArrayList<>(numDisjointSets());
            ArrayList<ArrayList<Integer>> S = new ArrayList<>();
            for(int i=0;i<p.size();i++) {
                p.add(new int[2]);
                S.add(new ArrayList<>());
            }
            System.out.println(IntStream.range(0, 2*N).mapToObj(a -> findSet(a)+"").collect(Collectors.joining(" ")));
            /*p = new ArrayList<>();

            boolean[] vis = new boolean[2 * N];
            for (int i = 0; i < 2 * N; i++)
                if (!vis[i]) {
                    S.add(get(i, vis));
                    int[] r = new int[2];
                    for (int a : S.get(S.size() - 1))
                        if (a < N) r[0]++;
                        else r[1]++;
                    p.add(r);
                }
            mem = new int[2][2][p.size()][];
            for (int i = p.size() - 1; i >= 0; i--)
                f(i, false, false);
            int R = f(0, false, false);
            if (R >= N) {
                sb.append("Yes\n");
                ArrayList<Integer> juries = new ArrayList<>();
                ArrayList<Integer> cats = new ArrayList<>();
                for (int P = 0, i = 1, d = 1; juries.size() + cats.size() < N; P++) {
                    if (mem[i][d][P][1] == 0) {
                        i = 0;
                        juries.addAll(S.get(P).stream().filter(a -> a < N).collect(Collectors.toList()));
                    } else {
                        d = 0;
                        cats.addAll(S.get(P).stream().filter(a -> a >= N).collect(Collectors.toList()));
                    }
                }
                for (; juries.size() + cats.size() > N; )
                    if (juries.size() > cats.size())
                        juries.remove(juries.size() - 1);
                    else
                        cats.remove(cats.size() - 1);
                sb.append(juries.size()).append(" ").append(cats.size()).append("\n");
                sb.append(juries.stream().map(a -> (a+1)+"").collect(Collectors.joining(" "))).append("\n");
                sb.append(cats.stream().map(a -> (a+1-N)+"").collect(Collectors.joining(" "))).append("\n");
            } else
                sb.append("No\n");*/
        }
        System.out.print(new String(sb));
    }

    public static int[] set;
    public static int _numDisjointSets;

    public static void initSet(int size) {
        set = new int[size];
        _numDisjointSets = size;
        for (int i = 0; i < size; i++)
            set[i]=i;
    }
    public static int findSet(int i) {
        return set[i] == i ? i : findSet(set[i]);
    }
    public static boolean isSameSet(int i, int j) {
        return (findSet(i) == findSet(j));
    }
    public static int findpatern(int i) {
        return findSet(i) == i ? i : findpatern(findSet(i));
    }
    public static void unionSet(int i, int j) {
        if(!isSameSet(i,j))
            _numDisjointSets--;
        set[findSet(i)] = findSet(j);
    }
    public static int numDisjointSets() {
        return _numDisjointSets;
    }

}
