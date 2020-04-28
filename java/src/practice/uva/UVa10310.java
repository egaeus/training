package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10310
 * @problemName Dog and Gopher
 * @judge http://uva.onlinejudge.org/
 * @category Geom
 * @level easy
 * @date 06/09/2010
 **/
import static java.lang.Double.parseDouble;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa10310 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln; (ln = in.readLine())!=null;) {
			StringTokenizer st = new StringTokenizer(ln.trim());
			int N = (int)parseDouble(st.nextToken());
			double gropherX = parseDouble(st.nextToken()), gropherY = parseDouble(st.nextToken()),
			dogX = parseDouble(st.nextToken()), dogY = parseDouble(st.nextToken());
			boolean ws = false;
			double solX=0, solY=0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine().trim());
				double X = parseDouble(st.nextToken()), Y = parseDouble(st.nextToken());
				if(!ws && sqrt(pow(gropherX-X, 2)+pow(gropherY-Y, 2))<=sqrt(pow(dogX-X, 2)+pow(dogY-Y, 2))/2){
					ws=true;
					solX = X;
					solY = Y;
				}
			}
			if(ws)System.out.printf(Locale.US, "The gopher can escape through the hole at (%.3f,%.3f).%n", solX, solY);
			else System.out.println("The gopher cannot escape.");
			if(in.readLine()==null)break;
		}
	}
}
