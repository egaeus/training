package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10254
 * @problemName The Priest Mathematician
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 17/03/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class UVa10254 {
	public static void main(String[] args) throws Throwable{
		BigInteger[] arr = new BigInteger[10001];
		arr[0]=BigInteger.ZERO;
		BigInteger h = BigInteger.ONE;
		for(int i = 1, j = 1; i < arr.length; j++, h=h.multiply(BigInteger.valueOf(2)))
			for(int k = 0; i < arr.length && k < j; i++, k++)
				arr[i]=arr[i-1].add(h);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(String ln; (ln = in.readLine())!=null;)sb.append(arr[parseInt(ln.trim())]+"\n");
		System.out.print(new String(sb));		
	}
}
