package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10420
 * @problemName Polygon Inside A Circle
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 14/02/2011
 **/
import static java.lang.Double.parseDouble;
import static java.lang.Math.PI;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa10432 {
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine()) != null; ){
			StringTokenizer st = new StringTokenizer(ln.trim());
			double r = parseDouble(st.nextToken()), n = parseDouble(st.nextToken()),
			theta = 2*PI/n, d = r*sin(theta)/sin((PI-theta)/2), h = sqrt(r*r - d*d/4);
			System.out.printf(Locale.US, "%.3f%n", n*d*h/2);
		}
	}
}
