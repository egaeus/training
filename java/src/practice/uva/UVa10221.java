package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10221
 * @problemName Satellites
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 11/02/2013
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa10221{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;){
			StringTokenizer st=new StringTokenizer(ln);
			double s=parseInt(st.nextToken())+6440,a=parseInt(st.nextToken());
			String h=st.nextToken();
			double t=h.equals("deg")?toRadians(a):2*PI*a/21600;
			if(t>PI)t=2*PI-t;
			System.out.printf(Locale.US,"%.6f %.6f\n",t*s,sqrt(s*s+s*s-2*s*s*cos(t)));
		}
		System.out.print(new String(sb));
	}
}
