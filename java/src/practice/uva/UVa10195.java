package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10195
 * @problemName The Knights Of The Round Table
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 26/12/2011
 **/
import static java.lang.Double.isNaN;
import static java.lang.Double.parseDouble;
import static java.lang.Math.sqrt;

import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa10195 {
	static double dist(double[] p, double[] q) {
		return (p[0]-q[0])*(p[0]-q[0])+(p[1]-q[1])*(p[1]-q[1]);
	}
	static double[] circuloInscritoATriangulo(double[] a,double[] b,double[] c){
		double A=Math.sqrt(dist(b,c)),B=Math.sqrt(dist(a,c)),C=Math.sqrt(dist(a,b)),
		z=A+B+C,p=A/z,q=B/z,r=C/z,cc[]=new double[]{a[0]*p+b[0]*q+c[0]*r,
		a[1]*p+b[1]*q+c[1]*r},rc=Line2D.ptLineDist(a[0],a[1],b[0],b[1],cc[0],cc[1]);
		return new double[]{cc[0],cc[1],rc};
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln;(ln=in.readLine())!=null;) {
			StringTokenizer st=new StringTokenizer(ln);
			double A=parseDouble(st.nextToken()),B=parseDouble(st.nextToken()),C=parseDouble(st.nextToken()),
			y=(A*A+C*C-B*B)/(2*A),x=sqrt(C*C-y*y),r=circuloInscritoATriangulo(new double[]{0,0},new double[]{0,A},new double[]{x,y})[2];
			System.out.printf(Locale.US,"The radius of the round table is: %.3f\n",isNaN(r)?0.0:r);
		}
	}
}
