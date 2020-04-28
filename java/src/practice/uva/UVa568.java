package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 568
 * @problemName Just the Facts
 * @judge http://uva.onlinejudge.org/
 * @category Math
 * @level easy
 * @date 21/04/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
public class UVa568 {
    public static void main(String[] args) throws Throwable{
        boolean[] primos = new boolean[101];
        primos[0] = primos[1] = true;
        ArrayList<Integer> p = new ArrayList<Integer>();
        for (int i = 0; i < primos.length; i++)
            if(!primos[i]){
                p.add(i);
                for (int j = 2*i; j < primos.length; j+=i)
                    primos[j]=true;
            }
        BigInteger temp = BigInteger.ONE;
        int[] res = new int[10001];
        res[0] = res[1] = 1;
        for (int i = 2; i < res.length; i++) {
            int m = i;
            int cont5 = 0, cont2 = 0;
            for (int j = 0; m > 1 && j < p.size(); j++){
                int val = p.get(j);
                if(m%val==0){
                    m/=val;
                    if(val!=5 && val != 2)temp = temp.multiply(BigInteger.valueOf(val));
                    if(val==2)cont2++;
                    if(val==5)cont5++;
                    j--;
                }
            }
            if(cont2-cont5<0)temp = temp.divide(BigInteger.valueOf(2).pow(cont5-cont2));
            else temp = temp.multiply(BigInteger.valueOf(2).pow(cont2-cont5));
            if(m!=1)temp = temp.multiply(BigInteger.valueOf(m));
            temp = temp.mod(BigInteger.valueOf(100000));
            res[i] = temp.mod(BigInteger.TEN).intValue();
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        for (String ln; (ln = in.readLine()) != null; ) {
            int n = parseInt(ln.trim());
            for (int i = 0; i < 5 - (n + "").length(); i++)sb.append(" ");
            sb.append(n + " -> " + res[n] + "\n");
        }
        System.out.print(new String(sb));
    }
}