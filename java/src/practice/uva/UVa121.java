package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 121
 * @problemName Pipe Fitters
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 30/04/2012
 **/
import static java.lang.Double.parseDouble;
import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa121 {
	static int normal(double a,double b){
		return (int)floor(a)*(int)floor(b);
	}
	static int skew(double a,double b){
		int s=(int)((a-1)/(Math.sqrt(3)/2))+(a>=1?1:0),even=(int)ceil(s/2.),odd=s/2;
		return even*(int)floor(b)+odd*((int)floor(b-0.5));		
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String ln;(ln=in.readLine())!=null;) {
			StringTokenizer st=new StringTokenizer(ln);
			double a=parseDouble(st.nextToken()),b=parseDouble(st.nextToken());
			int max=normal(a,b);boolean ws=true;
			if(max<skew(a,b)||max<skew(b,a)){ws=false;max=max(skew(a,b),skew(b,a));}
			sb.append(max+" "+(ws?"grid":"skew")+"\n");
		}
		System.out.print(new String(sb));
	}
}
