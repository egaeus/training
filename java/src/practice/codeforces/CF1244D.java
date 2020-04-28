package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1244/D
 * @category dp
 * @date 16/10/2019
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class CF1244D {

    static long[][] colors;
    static ArrayList<Integer> lAdy[];

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            int N = parseInt(ln);
            colors = new long[N][3];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                colors[i][0] = parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                colors[i][1] = parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                colors[i][2] = parseInt(st.nextToken());
            lAdy = new ArrayList[N];
            for (int i = 0; i < N; i++)
                lAdy[i] = new ArrayList<>();
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(in.readLine());
                int u = parseInt(st.nextToken()) - 1;
                int v = parseInt(st.nextToken()) - 1;
                lAdy[u].add(v);
                lAdy[v].add(u);
            }
            boolean ws = true;
            int first = -1;
            for(int i=0;i<N;i++)
                if(lAdy[i].size()>2)
                    ws = false;
                else if(lAdy[i].size()==1)
                    first = i;
            if(!ws)
                System.out.println(-1);
            else {
                int[] next= new int[N];
                Arrays.fill(next, -1);
                LinkedList<Integer> q = new LinkedList<>();
                q.add(first);
                for(int i=0;i<N-1;i++) {
                    int u = q.pollFirst();
                    for(int v: lAdy[u])
                        if(next[v] == -1) {
                            next[u]=v;
                            q.add(v);
                        }
                }

                int second = next[first];

                long min = Long.MAX_VALUE;
                int[] res = null;

                for(int i=0;i<3;i++)
                    for(int j=0;j<3;j++) {
                        if(i!=j) {
                            long S = colors[first][i] +  colors[second][j];
                            int[] solution = new int[N];
                            solution[first]=i;
                            solution[second]=j;
                            int c = i, c1 = j, node = next[second];
                            for(int h=2;h<N;h++) {
                                int newColor = getColor(c, c1);
                                solution[node] = newColor;
                                S += colors[node][newColor];
                                c = c1;
                                c1 = newColor;
                                node = next[node];
                            }
                            if(min > S) {
                                min = S;
                                res = solution;
                            }
                        }
                    }

                System.out.println(min);
                System.out.println(IntStream.of(res).mapToObj(a -> (a+1)+"").collect(Collectors.joining(" ")));
            }
        }
    }

    static int getColor(int c, int c1) {
        for(int i=0;i<3;i++)
            if(i!=c&&i!=c1)
                return i;
        return -1;
    }

}
