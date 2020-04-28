package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10469
 * @problemName To Carry or not to Carry
 * @judge http://uva.onlinejudge.org/
 * @category math, simulation
 * @level easy
 * @date 2010
 **/
import static java.lang.Long.parseLong;
import static java.lang.Long.toBinaryString;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa10469 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln; (ln = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(ln.trim());
			long a = parseLong(st.nextToken()), b = parseLong(st.nextToken());
			String A = toBinaryString(a), B = toBinaryString(b), res = "";
			for (int i = Math.max(A.length(), B.length()) - 1; i >= Math.abs(A.length() - B.length()); i--) {
				int charA = A.charAt(A.length() > B.length()?i:i - B.length() + A.length()) - '0',
				    charB = B.charAt(B.length() > A.length()?i:i - A.length() + B.length()) - '0';
				res = ((charA + charB)>1?0:(charA + charB)) + res;
			}
			res = ((A.length() > B.length())?A.substring(0, A.length() - B.length()):B.substring(0, B.length() - A.length())) + res;
			System.out.println(parseLong(res, 2));
		}
	}
}
