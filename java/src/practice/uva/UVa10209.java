package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10209
 * @problemName Is This Integration?
 * @judge http://uva.onlinejudge.org/
 * @category Geom
 * @level medium
 * @date 08/09/2010
 **/
import static java.lang.Double.parseDouble;
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
public class UVa10209 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine()) != null; ){
			double l = parseDouble(ln.trim()), x = (PI*l*l)/4 - (l*l*(PI/6))/2 - (l*l*sqrt(3))/8, 
			a = ((3*PI*l*l)/2 - 8*x - 2*l*l)*2,
			b = (4*x + l*l - PI*l*l + l*l)*2,
			c = ((PI*l*l)/4 - (l*l)/4 - 2*x)*-4;
			System.out.printf(Locale.US, "%.3f %.3f %.3f%n", c, a, b);
		}
	}
}
