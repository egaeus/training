package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 623
 * @problemName 500!
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 2009
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class UVa623 {
	public static void main(String[] args) throws Throwable{
		BigInteger arr[] = new BigInteger[1001];
		arr[0] = BigInteger.ONE;
		arr[1] = BigInteger.ONE;
		for (int i = 2; i < arr.length; i++) 
			arr[i] = arr[i - 1].multiply(BigInteger.valueOf(i));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for (String ln; (ln = in.readLine()) != null; ) {
			int n = parseInt(ln.trim());
			sb.append(n + "!\n" + arr[n] + "\n");
		}
		System.out.print(new String(sb));
	}
}
