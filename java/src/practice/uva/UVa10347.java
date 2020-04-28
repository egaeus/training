package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10347
 * @problemName Medians
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date Nov 5, 2013
 **/
import static java.lang.Double.parseDouble;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa10347 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln;(ln=in.readLine())!=null;) {
			StringTokenizer st=new StringTokenizer(ln);
			double ma=parseDouble(st.nextToken()),mb=parseDouble(st.nextToken()),mc=parseDouble(st.nextToken());
			if(-(ma*ma)+2*mb*mb+2*mc*mc>=0&&-(mb*mb)+2*ma*ma+2*mc*mc>=0&&-(mc*mc)+2*mb*mb+2*ma*ma>=0) {
				double a=2*sqrt(-(ma*ma)+2*mb*mb+2*mc*mc)/3, b=2*sqrt(-(mb*mb)+2*ma*ma+2*mc*mc)/3, c=2*sqrt(-(mc*mc)+2*mb*mb+2*ma*ma)/3;
				if(a+b>c&&a+c>b&&b+c>a) {
					double p=(a+b+c)/2,area=sqrt(p*(p-a)*(p-b)*(p-c));
					System.out.printf(Locale.US,"%.3f\n",area);
				}
				else
					System.out.printf(Locale.US,"%.3f\n",-1.0);
			}
			else
				System.out.printf(Locale.US,"%.3f\n",-1.0);
		}
	}
}
