package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1238/D>
 * @category string
 * @date 19/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.lang.Integer.parseInt;

public class CF1238D {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            int N = parseInt(ln);
            char[] S = in.readLine().toCharArray();
            int[] nextA = new int[N];
            int[] nextB = new int[N];
            nextA[N - 1] = nextB[N - 1] = -1;
            for (int i = N - 2; i >= 0; i--) {
                if (S[i + 1] == 'A') {
                    nextA[i] = i + 1;
                    nextB[i] = nextB[i + 1];
                } else {
                    nextB[i] = i + 1;
                    nextA[i] = nextA[i + 1];
                }
            }
            boolean ws[] = new boolean[N];
            for(int i=0;i<N;i++) {
                if (nextA[i] != -1 && S[i] == 'A')
                    ws[nextA[i]] = true;
                if (nextB[i] != -1 && S[i] == 'B')
                    ws[nextB[i]] = true;
            }
            long q[] = new long[N];
            q[N-1]=ws[N-1]?1:0;
            for(int i=N-2;i>=0;i--)
                q[i] = q[i+1]+ (ws[i]?1:0);
            long s[] = new long[N];
            for(int i=0;i<N;i++) {
                if(S[i]=='A') {
                    if(nextA[i]!=-1) {
                        s[i] = q[nextA[i]];
                        if(nextB[i]>nextA[i] && ws[nextB[i]])
                            s[i]--;
                    }
                }
                if(S[i]=='B') {
                    if(nextB[i]!=-1) {
                        s[i] = q[nextB[i]];
                        if(nextA[i]>nextB[i]&& ws[nextA[i]])
                            s[i]--;
                    }
                }
            }
            System.out.println(LongStream.of(s).sum());
        }
    }

}
