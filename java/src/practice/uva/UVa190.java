package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 190
 * @problemName Circle Through Three Points
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level medium
 * @date 27/12/2011
 **/
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Double.parseDouble;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa190 {
	static double[] interseccionLn(double[][] l1,double[][] l2){
		double p1=l1[0][0],p2=l1[0][1],x1=l1[1][0],y1=l1[1][1],q1=l2[0][0],
		q2=l2[0][1],x2=l2[1][0],y2=l2[1][1],v1=x1-p1,v2=y1-p2,w1=x2-q1,w2=y2-q2,
		s1=v2*(q1-p1)-v1*(q2-p2),s2=w2*v1-w1*v2,s=s1/s2;
		if(Math.abs(s2)<=1e-10)return null;
		return new double[]{q1+s*w1,q2+s*w2};
	}
	static double getPendiente(double[][] l){
		return (l[0][1]-l[1][1])/(l[0][0]-l[1][0]);
	}
	static double dist(double[] p, double[] q) {
		return (p[0]-q[0])*(p[0]-q[0])+(p[1]-q[1])*(p[1]-q[1]);
	}
	static double[] pm(double l1[][]){
		return new double[]{l1[1][0]+(l1[0][0]-l1[1][0])/2,l1[1][1]+(l1[0][1]-l1[1][1])/2};
	}
	static double[] circulo3P(double p1[],double p2[],double p3[]){
		double m1=getPendiente(new double[][]{p1,p2}),m=-1/m1,pm[]=pm(new double[][]{p1,p2}),
		b=pm[1]-m*pm[0],l1[][]=new double[][]{pm,{m1==0?pm[0]:10,m1==0?10:(m*10+b)}},l2[][],c[],
		inf=POSITIVE_INFINITY;
		m1=getPendiente(new double[][]{p2,p3});m=-1/m1;pm=pm(new double[][]{p2,p3});
		b=pm[1]-m*pm[0];l2=new double[][]{pm,{m1==0?pm[0]:10,m1==0?10:(m*10+b)}};
		if((c=interseccionLn(l1,l2))==null)return new double[]{inf,inf,inf};
		return new double[]{c[0],c[1],sqrt(dist(c,p1))};
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln;(ln=in.readLine())!=null;) {
			StringTokenizer st=new StringTokenizer(ln);
			double[] c=circulo3P(new double[]{parseDouble(st.nextToken()),parseDouble(st.nextToken())},
					new double[]{parseDouble(st.nextToken()),parseDouble(st.nextToken())},
					new double[]{parseDouble(st.nextToken()),parseDouble(st.nextToken())});
			double v=c[0]*c[0]+c[1]*c[1]-c[2]*c[2];
			System.out.printf(Locale.US,"(x "+(c[0]>0?"-":"+")+" %.3f)^2 + (y "+(c[1]>0?"-":"+")+" %.3f)^2 = %.3f^2\n",abs(c[0]),abs(c[1]),c[2]);
			System.out.printf(Locale.US,"x^2 + y^2 "+(c[0]>0?"-":"+")+" %.3fx "+(c[1]>0?"-":"+")+" %.3fy "+(v<0?"-":"+")+" %.3f = 0\n\n",2*abs(c[0]),2*abs(c[1]),abs(v));
		}
	}
}
