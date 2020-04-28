package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10127
 * @probleName Ones
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class UVa10127 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln; (ln = in.readLine()) != null; ) {
			int N = parseInt(ln.trim());
			int i;
			int mod = 0; 
			for (i = 0; ; i++){
				mod += BigInteger.TEN.modPow(new BigInteger(i + ""), new BigInteger(N + "")).intValue();				
				if(mod%N == 0)break;
			}
			System.out.println(N + ": " + (i + 1));
		}
	}
}
