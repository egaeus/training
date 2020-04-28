package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10334
 * @problemName Ray Through Glasses
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 6/01/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class UVa10334 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BigInteger[] f=new BigInteger[1001];f[0]=BigInteger.ONE;f[1]=BigInteger.valueOf(2);
		for(int i=2;i<f.length;i++)f[i]=f[i-1].add(f[i-2]);
		for (String ln;(ln=in.readLine())!=null;) 
			System.out.println(f[parseInt(ln.trim())]);
	}
}

