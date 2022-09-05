package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1244/C>
 * @category math
 * @date 16/10/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Long.parseLong;

public class CF1244C {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String ln; (ln = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(ln);
            long N = parseLong(st.nextToken()), P = parseLong(st.nextToken());
            int W = Integer.parseInt(st.nextToken()), D = Integer.parseInt(st.nextToken());
            boolean[] mods = new boolean[D];
            boolean ws = false;
            for(long x = Math.min(N, P/W); x >= 0;x--) {
                long mod = (P-x*W)%D;
                if(mod == 0) {
                    long y = (P-x*W)/D;
                    if(y+x<=N)
                        System.out.println(x + " " + y + " " + (N - x - y));
                    else
                        System.out.println(-1);
                    ws = true;
                    break;
                }
                else {
                    if(mods[(int)mod]) {
                        System.out.println(-1);
                        ws = true;
                        break;
                    }
                    mods[(int)mod] = true;
                }
            }
            if(!ws)
                System.out.println(-1);
        }
    }
}
