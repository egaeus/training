package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 621
 * @problemName Secret Research
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 29/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa621 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int N=parseInt(in.readLine().trim()),n=0;n++<N;) {
			String str=in.readLine().trim();
			if(str.equals("78")||str.equals("1")||str.equals("4"))System.out.println("+");
			else if(str.endsWith("35"))System.out.println("-");
			else if(str.startsWith("9")&&str.endsWith("4"))System.out.println("*");
			else System.out.println("?");
		}
	}
}
