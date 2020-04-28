package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10446
 * @problemName The Marriage Interview :-)
 * @judge http://uva.onlinejudge.org/
 * @category dynamic programming
 * @level easy
 * @date 21/04/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
public class UVa10446 {
    static BigInteger count;
    static BigInteger[][] resp = new BigInteger[62][62];
    static void trib(int n, int back){
        count = count.add(BigInteger.ONE);
        if(n<=0) return;
        if(n==1) return;
        if(resp[n][back] != null){count=count.add(resp[n][back]);return;}
        BigInteger cont = count;
        for(int i=1;i<=back;i++)
             trib(n-i,back);
        resp[n][back]=count.subtract(cont);
    }
    public static void main(String[] args) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int caso = 1; ; caso++) {
            StringTokenizer st = new StringTokenizer(in.readLine().trim());
            int n = parseInt(st.nextToken()), back = parseInt(st.nextToken());
            if(n>60)break;
            count = BigInteger.ZERO;
            trib(n, back);
            System.out.println("Case " + caso + ": " + count);
        }
    }
}