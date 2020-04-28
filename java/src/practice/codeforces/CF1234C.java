package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1234/C
 * @category memoization
 * @date 02/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class CF1234C {
    static int N;
    static char[][] T;
    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(int Q=parseInt(in.readLine()),q=0;q++<Q;) {
            N=parseInt(in.readLine());
            T = new char[2][];
            T[0]=in.readLine().toCharArray();
            T[1]=in.readLine().toCharArray();
            mem = new int[N][2];
            System.out.println(f(0,0)?"YES":"NO");
        }
    }

    static int[][] mem;

    static boolean f(int p, int f) {
        if(p==N)return f==1;
        if(mem[p][f]!=0)
            return mem[p][f]==1;
        if(T[f][p]=='1'||T[f][p]=='2') {
            boolean ws = f(p + 1, f);
            mem[p][f] = ws?1:2;
            return ws;
        }
        if(T[(f+1)%2][p]!='1'&&T[(f+1)%2][p]!='2') {
            boolean ws = f(p + 1, (f + 1) % 2);
            mem[p][f] = ws?1:2;
            return ws;
        }
        mem[p][f] = 2;
        return false;
    }
}
