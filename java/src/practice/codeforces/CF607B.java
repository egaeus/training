package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/607/B>
 * @category dp
 * @date 24/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF607B {
    static int[] arr;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            int N = parseInt(ln);
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i=0;i<N;i++)
                arr[i]=parseInt(st.nextToken());
            mem = new int[N+1][N+1];
            for(int[] m:mem)
                Arrays.fill(m,-1);
            System.out.println(f(0,N));
        }
    }

    static int[][] mem;

    static int f(int a, int b) {
        if(b-a==1)return 1;
        if(a>=b)return 1;
        if(mem[a][b]>=0)
            return mem[a][b];
        int min = f(a+1,b)+1;
        for(int i=a+1;i<b;i++)
            if(arr[a]==arr[i]) {
                int A1 = a+1, A2 = i;
                int B1 = i+1;
                int s = 0;
                if(B1!=b)
                    s+=f(B1, b);
                if(i-a==1)
                    s++;
                else
                    s+=f(A1, A2);
                min = Math.min(min, s);
            }
        return mem[a][b]=min;
    }
}
