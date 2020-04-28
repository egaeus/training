package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10451
 * @problemName Ancient Village Sports
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 14/01/2013
 **/
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Math.acos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa10451{
	public static void main(String args[]) throws Throwable{
		final double PI=2*acos(0);
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int caso=1;
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;caso++){
			int N=parseInt(st.nextToken());
			if(N<3)break;
			double AT=parseDouble(st.nextToken()),A=AT/N,tetha=2*PI/N,
					b=sqrt(2*A/sqrt(1/(4*sin(tetha/2)*sin(tetha/2))-1/4.)),h=2*A/b,
					r=sqrt((b*b)/4+h*h);
			System.out.printf(Locale.US,"Case %d: %.5f %.5f\n",caso,(PI*r*r)-AT,AT-PI*h*h);
		}
		System.out.print(new String(sb));
	}
}
