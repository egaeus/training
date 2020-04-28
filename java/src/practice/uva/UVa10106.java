package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10106
 * @probleName Product
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class UVa10106 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for (String ln; (ln = in.readLine())!=null; ) 
			sb.append(new BigInteger(ln.trim()).multiply(new BigInteger(in.readLine().trim())) + "\n");
		System.out.print(sb);
	}
}
