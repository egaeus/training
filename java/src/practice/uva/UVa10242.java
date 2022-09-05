package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict R.E.
 * @problemId 10242
 * @problemName Fourth Point !!
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 11/02/2013
 **/
import static java.lang.Double.parseDouble;
import static java.lang.Math.sqrt;

import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa10242{
	static double[][] interseccionCirculos(double[] c1,double[] c2){
		double h1=c1[0],k1=c1[1],r1=c1[2],h2=c2[0],k2=c2[1],r2=c2[2],K=k1-k2,H=h1-h2,
				M=-h1*h1+h2*h2-k1*k1+k2*k2+r1*r1-r2*r2,a=4*(K*K+H*H),b=4*(M*K-2*k1*H*H+2*h1*K*H),
				c=M*M+4*(h1*h1+k1*k1-r1*r1)*H*H+4*h1*M*H,B=b*b-4*a*c,y1=(-b+Math.sqrt(B))/(2*a),
				y2=(-b-Math.sqrt(B))/(2*a),x1=Math.abs(H)<1e-10?a-(a-b)/2:(2*y1*(K)+M)/(2*(-H)),
						x2=Math.abs(H)<1e-10?a-(a-b)/2:(2*y2*(K)+M)/(2*(-H));
		if(B<0||Math.abs(a)<=1e-10)return null;
		return new double[][]{{x1,y1},{x2,y2}};
	}
	static double dist(double[] a,double[] b) {
		return sqrt((a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]));
	}
	static boolean equals(double []a,double[] b) {
		for(int i=0;i<a.length;i++)
			if(a[i]!=b[i])return false;
		return true;
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(String ln;(ln=in.readLine())!=null;){
			StringTokenizer st=new StringTokenizer(ln);
			double A[]={parseDouble(st.nextToken()),parseDouble(st.nextToken())},B[]={parseDouble(st.nextToken()),parseDouble(st.nextToken())},
					C[]={parseDouble(st.nextToken()),parseDouble(st.nextToken())},D[]={parseDouble(st.nextToken()),parseDouble(st.nextToken())};
			double[][] s={A,B,C,D},c=null;
			for(int i=0,k=0;i<s.length&&c==null;i++)
				for(int j=i+1;j<s.length&&c==null;j++)
					if(equals(s[j],s[i])) {
						c=new double[3][];
						c[k++]=s[i];
						for(int h=0;h<s.length;h++)
							if(s[h]!=s[i]&&s[h]!=s[j])
								c[k++]=s[h];
					}
			double d1=dist(c[0],c[1]),d2=dist(c[0],c[2]),sol[][]=interseccionCirculos(new double[]{c[1][0],c[1][1],d2},new double[]{c[2][0],c[2][1],d1});
			if(!new Line2D.Double(c[0][0],c[0][1],c[2][0],c[2][0]).intersectsLine(sol[0][0],sol[0][1],c[1][0],c[1][1])&&
					!new Line2D.Double(c[0][0],c[0][1],c[1][0],c[1][0]).intersectsLine(sol[0][0],sol[0][1],c[2][0],c[2][1]))
					System.out.printf(Locale.US,"%.3f %.3f\n",sol[0][0],sol[0][1]);
			else System.out.printf(Locale.US,"%.3f %.3f\n",sol[1][0],sol[1][1]);
		}
	}
}
