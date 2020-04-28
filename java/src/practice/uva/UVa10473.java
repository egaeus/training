package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10473
 * @problemName Simple Base Conversion
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 22/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10473 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln;(ln=in.readLine().trim())!=null;) {
			if(ln.startsWith("0x"))System.out.println(parseInt(ln.substring(2),16));
			else if(parseInt(ln)<0)break;
			else System.out.println("0x"+Integer.toHexString(parseInt(ln)).toUpperCase());
		}
	}
}
