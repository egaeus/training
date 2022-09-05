package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 713
 * @problemName Adding Reversed Numbers
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 20/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
public class UVa713 {
	static String reverse(String str){
		return new String(new StringBuffer(str).reverse());
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int c=0,C=parseInt(in.readLine().trim());c++<C;) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			System.out.println(new BigInteger(reverse(new BigInteger(reverse(st.nextToken())).add(new BigInteger(reverse(st.nextToken()))).toString())));
		}
	}
}
