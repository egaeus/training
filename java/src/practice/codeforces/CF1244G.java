package practice.codeforces;
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1244/G
 * @category implementation
 * @date 18/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1244G {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            int N = parseInt(st.nextToken());
            long NL = N;
            long K = Long.parseLong(st.nextToken());
            long min = (NL * (NL + 1)) / 2;
            long max = N % 2 == 1 ? N / 2 + 1 : 0;
            for (int i = 0; i < N / 2; i++)
                max += 2 * (N - i);
            //System.out.println(min+" "+max);
            if (K < min)
                System.out.println(-1);
            else if (K >= max) {
                System.out.println(max);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < N; i++)
                    sb.append(i > 0 ? " " : "").append(i+1);
                sb.append("\n");
                for (int i = 0; i < N; i++)
                    sb.append(i > 0 ? " " : "").append((N - i));
                System.out.println(new String(sb));
            } else {
                long k = K - min;
                int[] sol = new int[N];
                for (int i = 0; i < N; i++)
                    sol[i] = i + 1;
                for(int i=0,j=N-1;i<N&&j>=0&&k>0;) {
                    if(j-i<=k) {
                        int swap = sol[i];
                        sol[i] = sol[j];
                        sol[j]=swap;
                        k-=j-i;
                        i++;j--;
                    }
                    else {
                        i=(int)(j-k);
                        int swap = sol[i];
                        sol[i] = sol[j];
                        sol[j]=swap;
                        j--;
                        k=0;
                    }
                }
                System.out.println(K-k);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < N; i++)
                    sb.append(i > 0 ? " " : "").append(i+1);
                sb.append("\n");
                for (int i = 0; i < N; i++)
                    sb.append(i > 0 ? " " : "").append(sol[i]);
                System.out.println(new String(sb));

            }
        }
    }
}
