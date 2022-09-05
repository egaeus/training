package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10286
 * @problemName Trouble with a Pentagon
 * @judge http://uva.onlinejudge.org/
 * @category math (Teorema del Seno)
 * @level easy
 * @date 11/02/2011
 **/
import static java.lang.Double.parseDouble;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
public class UVa10286 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		double sin108 = sin(toRadians(108)), sin63 = sin(toRadians(63)), sinT = sin108/sin63;
		for(String ln; (ln = in.readLine()) != null; ){
			double l = parseDouble(ln.trim());
			System.out.printf(Locale.US, "%.10f%n", l*sinT);
		}
	}
}
