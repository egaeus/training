package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 913
 * @problemName Joana and the Odd Numbers
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 23/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa913 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln;(ln=in.readLine())!=null;) {
			long N=parseInt(ln.trim()),P=(N/2+1)*(N/2+1);
			System.out.println(3*((P-1)*2+1)-6);
		}
	}
}
