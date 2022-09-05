package practice.codeforces; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1157/E>
 * @category greedy, data structures
 * @date Marzo, 2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1157E {
    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(String ln;(ln=in.readLine())!=null;) {
            StringTokenizer st = new StringTokenizer(ln);
            long N=parseInt(st.nextToken()),K=parseInt(st.nextToken());
            long[] res = new long[(int)K];
            if(N>=(K*(K+1))/2) {
                long n=(long)Math.floor((-1+Math.sqrt(1+8*N))/2),k=N/n;
                N%=n;
                for(int i=0;i<K;i++)
                    ;
                System.out.println("YES");
                int s=0;
                for(int i=0;i<K;i++) {
                    System.out.print((i > 0 ? " " : "") + res[i]);
                    s+=res[i];
                }
                System.out.println();
            }
            else System.out.println("NO");
        }
    }
}
