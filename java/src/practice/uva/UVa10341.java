package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10341
 * @problemName Solve It
 * @judge http://uva.onlinejudge.org/
 * @category Math
 * @level easy
 * @date 23/07/2010
 **/
import static java.lang.Double.parseDouble;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa10341 {
	static double function(double val, double p, double q, double r, double s, double t, double u){
		return p*Math.pow(Math.E, -val) + q*Math.sin(val) + r*Math.cos(val) + s*Math.tan(val) + t*val*val + u;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln; (ln = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(ln.trim());
			double p = parseDouble(st.nextToken()),
			q = parseDouble(st.nextToken()),
			r = parseDouble(st.nextToken()),
			s = parseDouble(st.nextToken()),
			t = parseDouble(st.nextToken()),
			u = parseDouble(st.nextToken());
			if(p == 0 && q == 0 && r == 0 && s == 0 && t == 0 && u == 0)
				System.out.println("0.0000");
			else{
				double cotaSup = 1, cotaInf = 0;
				for (; ; ) {
					if(cotaSup==cotaInf&&!(Math.abs(function(cotaSup, p, q, r, s, t, u))<10E-12)){
						System.out.println("No solution");
						break;
					}
					double pn = (cotaSup + cotaInf)/2;
					if(Math.abs(function(pn, p, q, r, s, t, u))<10E-12){
						if(pn>=0&&pn<=1)
							System.out.printf(Locale.US, "%.4f%n", pn);
						else System.out.println("No solution");
						break;
					}
					if(function(pn, p, q, r, s, t, u)*function(cotaInf, p, q, r, s, t, u)>0)
						cotaInf=pn;
					else cotaSup=pn;
				}
			}
		}
	}
}
