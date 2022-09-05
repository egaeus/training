package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 424
 * @problemName Integer Inquiry
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class UVa424 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BigInteger sum = BigInteger.ZERO;
		while(true){
			String s = in.readLine().trim();
			if(s.equals("0"))break;
			sum = sum.add(new BigInteger(s));
		}
		System.out.println(sum);
	}

}