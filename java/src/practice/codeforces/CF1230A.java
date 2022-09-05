package practice.codeforces;
/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/1230/A>
 * @category adhoc
 * @date 30/09/2019
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF1230A {
    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(String ln;(ln=in.readLine())!=null;) {
            StringTokenizer st = new StringTokenizer(ln);
            int[] a = new int[4];
            boolean ws=false;
            int sum=0;
            for(int i=0;i<4;i++)
                sum+=(a[i]=parseInt(st.nextToken()));
            for(int i=0;i<(1<<4);i++) {
                int s=0;
                for(int j=0;j<4;j++)
                    if(((1<<j)&i)!=0)
                        s+=a[j];
                ws|=(s==sum-s);
            }
            System.out.println(ws?"YES":"NO");
        }
    }
}
