package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url https://codeforces.com/problemset/problem/1355/A
 * @category adhoc
 * @date 16/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1355A {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long N = Long.parseLong(st.nextToken()), K = Long.parseLong(st.nextToken());
            long res = N;
            for(long i=0;i<K-1;i++){
                long min = 9, max = 0;
                N = res;
                for(;N>0;N/=10) {
                    min = Math.min(min, N%10);
                    max = Math.max(max, N%10);
                }
                if(min == 0)break;
                res += min*max;
            }
            System.out.println(res);
        }
    }
}
