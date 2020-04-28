package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId GNY07B
 * @problemName Conversions
 * @judge http://www.spoj.pl
 * @category Adhoc
 * @level easy
 * @date 22/02/2011
 **/
import static java.lang.Double.parseDouble;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class SPOJGNY07B {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = (int)parseDouble(in.readLine().trim()); c++ < C; ){
			StringTokenizer st = new StringTokenizer(in.readLine());
			double val = parseDouble(st.nextToken());
			String unidad = st.nextToken().toLowerCase();
			if(unidad.equals("kg"))System.out.printf(Locale.US, "%d %.4f lb%n", c, val*2.2046);
			if(unidad.equals("l"))System.out.printf(Locale.US, "%d %.4f g%n", c, val*0.2642);
			if(unidad.equals("lb"))System.out.printf(Locale.US, "%d %.4f kg%n", c, val*0.4536);
			if(unidad.equals("g"))System.out.printf(Locale.US, "%d %.4f l%n", c, val*3.7854);
		}
	}
}
