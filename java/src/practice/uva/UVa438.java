package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 438
 * @problemName The Circumference of the Circle
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 13/12/2011
 **/
import static java.lang.Double.parseDouble;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa438 {
	static double[] circulo3P(double[] p1, double[] p2, double[] p3){
		return circulo3P(p1[0],p1[1],p2[0],p2[1],p3[0],p3[1]);
	}
	static double[] circulo3P(double x1, double y1, double x2, double y2, double x3, double y3) {
		double x4=(x1+x2)/2,y4=(y1+y2)/2,x5=(x3+x2)/2,y5=(y3+y2)/2;
		double c[]=intLineas(x4,y4,x4+y2-y1,y4+x1-x2,x5,y5,x5+y2-y3,y5+x3-x2),cx=c[0],cy=c[1];
		return new double[]{cx,cy,Math.sqrt((cx-x1)*(cx-x1)+(cy-y1)*(cy-y1))};
	}
	static double[] intLineas(double x1, double y1, double x2, double y2,
		double x3, double y3, double x4, double y4) {
		double xa=x2-x1,xb=x4-x3,xc=x1-x3,ya=y2-y1,yb=y4-y3,yc=y1-y3,d=yb*xa-xb*ya,n=xb*yc-yb*xc;
		return Math.abs(d)<1e-11?null:new double[]{x1+xa*n/d,y1+ya*n/d};
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		final double PI=3.141592653589793;
		for(String ln;(ln=in.readLine())!=null;){
			StringTokenizer st=new StringTokenizer(ln);
			double[][] p=new double[][]{{parseDouble(st.nextToken()),parseDouble(st.nextToken())},{parseDouble(st.nextToken()),parseDouble(st.nextToken())},{parseDouble(st.nextToken()),parseDouble(st.nextToken())}};
			double[] c=circulo3P(p[0],p[1],p[2]);
			System.out.printf(Locale.US,"%.2f\n",2*PI*c[2]);
		}
	}
}
