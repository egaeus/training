package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1345/B>
 * @category math
 * @date 09/05/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class CF1345B {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        for(int i = 0; i < T; i++) {
            long N = parseInt(in.readLine());
            int s = 0;
            for(; N> 0;) {
                long n = (int)(-1 + Math.sqrt(1+24*N))/6;
                if(n==0)break;
                N-= n*(n+1)+(n*(n-1))/2;
                s++;
            }
            System.out.println(s);
        }
    }
}
