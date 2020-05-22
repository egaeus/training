package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1157/C1>
 * @category greedy
 * @date Marzo, 2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class CF1157C1 {
    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        for(String ln;(ln=in.readLine())!=null;) {
            int N = parseInt(ln);
            int A[] = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                A[i] = parseInt(st.nextToken());
            int a = 1, b = A.length;
            for (; a < b; ) {
                int p = (int)((1L + a + b) / 2 + (1L + a + b) % 2);
                if (check(A, p))
                    a = p;
                else
                    b = p - 1;
            }
            sb.append(a).append("\n");
            get(A, a, sb);
            System.out.print(new String(sb));
        }
    }

    static void get(int[] A, int p, StringBuilder sb) {
        int last=-1,a=0,b=A.length-1;
        for(int i=0;i<p;i++)
            if ((A[a]<A[b]||A[b]<last)&&A[a]>last) {
                last=A[a];
                a++;
                sb.append("L");
            }
            else
            if(A[b]>last) {
                last=A[b];
                b--;
                sb.append("R");
            }
        sb.append("\n");
    }

    static boolean check(int[] A, int p) {
        int last=-1,a=0,b=A.length-1;
        for(int i=0;i<p;i++) {
            if ((A[a]<A[b]||A[b]<last)&&A[a]>last) {
                last=A[a];
                a++;
            } else if (A[b] > last) {
                last=A[b];
                b--;
            } else
                return false;
        }
        return true;
    }
}
