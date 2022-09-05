package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10297
 * @problemName Beavergnaw
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 14/02/2011
 **/
import static java.lang.Double.parseDouble;
import static java.lang.Math.PI;
import static java.lang.Math.pow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa10297 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine().trim())!=null;){
			StringTokenizer st = new StringTokenizer(ln);
			double D = parseDouble(st.nextToken()), V = parseDouble(st.nextToken());
			if(D==0&&V==0)break;
			System.out.printf(Locale.US, "%.3f%n", pow(-6*V/PI + D*D*D, 1.0/3));
		}
	}
}
