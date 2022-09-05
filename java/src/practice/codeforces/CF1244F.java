package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1244/F>
 * @category implementation
 * @date 18/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class CF1244F {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken()), K = parseInt(st.nextToken());
            char[] S = in.readLine().toCharArray();
            N=S.length;
            char[] s = new char[2*N];
            for(int i=0;i<N;i++)
                s[i]=s[N+i]=S[i];
            if (f(s, N)) {
                if (K % 2 == 1)
                    s = move(s, N);
            } else {
                for (; K > 0; K--) {
                    ArrayList<int[]> list = get(s, N);
                    if(list.size()==0)break;
                    int max = 0;
                    for(int[] l:list)
                        max = Math.max(max, (l[1]-l[0])/2);
                    max = Math.min(max, K);
                    s = move(s, N, max, list);
                    K-=max;
                }
            }
            System.out.println(Arrays.copyOf(s, N));
        }
    }

    static ArrayList<int[]> get(char[] S, int N) {
        int ant = -1;
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0;i<2*N-1;i++)
            if(S[i]==S[i+1]) {
                if(ant!=-1&&i-ant>1&&ant<N) {
                    list.add(new int[]{ant, i});
                    if(i>=N&&list.size()>0&&list.get(0)[0]==0)
                        list.remove(0);
                }
                ant = -1;
            }
            else if(ant == -1)
                ant = i;
        return list;
    }

    static char[] move(char[] s, int N, int C, ArrayList<int[]> list) {
        for(int[] l:list) {
            int i=l[0]+1, c=0, j=l[1]-1;
            for(;c<C&&i<=j;c++,i++,j--) {
                s[i] = s[i<N?i+N:i%N] = s[l[0]];
                s[j] = s[j<N?j+N:j%N] = s[l[1]];
            }
            for(;i<=j;i++)
                s[i] = s[i<N?i+N:i%N] = s[i-1]=='W'?'B':'W';
        }
        return s;
    }

    static char[] move(char[] s, int N) {
        char[] n = new char[s.length];
        for (int i = 0; i < N; i++) {
            int W = (s[i] == 'W' ? 1 : 0) + (s[i == 0 ? N - 1 : i - 1] == 'W' ? 1 : 0) + (s[(i + 1) % N] == 'W' ? 1 : 0);
            if (W >= 2) n[i] = n[N+i] = 'W';
            else n[i] = n[N+i] = 'B';
        }
        return n;
    }

    static boolean f(char[] s, int N) {
        for (int i = 0; i < N - 1; i++)
            if (s[i] == s[i + 1])
                return false;
        return s[0] != s[N - 1];
    }

}
