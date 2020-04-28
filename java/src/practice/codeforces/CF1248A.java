package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1248/A
 * @category math
 * @date 20/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class CF1248A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0, T=parseInt (in.readLine());t++<T; ) {
            int N = parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());
            long[] A=new long[2];
            long[] B=new long[2];
            for(int i=0;i<N;i++)
                A[parseInt(st.nextToken())%2]++;
            int M = parseInt(in.readLine());
            st = new StringTokenizer(in.readLine());
            for(int i=0;i<M;i++)
                B[parseInt(st.nextToken())%2]++;
            System.out.println(A[0]*B[0]+A[1]*B[1]);
        }
    }
}
