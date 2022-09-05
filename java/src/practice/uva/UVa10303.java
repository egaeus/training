package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10303
 * @problemName How Many Trees?
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 16/07/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class UVa10303{
	public static void main(String args[]) throws Throwable{
		BigInteger res[]=new BigInteger[1001];
		res[0]=res[1]=BigInteger.ONE;
		for(int i=2;i<res.length;i++){
			res[i]=BigInteger.ZERO;
			for(int j=1;j<=i;j++)
				res[i]=res[i].add(res[j-1].multiply(res[i-j]));
		}
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;)
			sb.append(res[parseInt(ln.trim())]+"\n");
		System.out.print(new String(sb));
	}
}
