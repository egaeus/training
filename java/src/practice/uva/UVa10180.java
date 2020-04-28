package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10180
 * @problemName Rope Crisis in Ropeland!
 * @judge http://uva.onlinejudge.org/
 * @category Geom
 * @level medium, cascarudo
 * @date 08/09/2010
 **/
import static java.lang.Double.min;
import static java.lang.Double.parseDouble;
import static java.lang.Math.PI;
import static java.lang.Math.acos;
import static java.lang.Math.atan;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa10180 {
	static double ds(double[] a, double[] b) {
		return (b[0]-a[0])*(b[0]-a[0])+(b[1]-a[1])*(b[1]-a[1]);
	}
	static double distPL(double[] p1, double[] p2, double[] p) {
		return Math.abs((p2[0]-p1[0])*(p1[1]-p[1])-(p2[1]-p1[1])*(p1[0]-p[0]))/Math.sqrt(ds(p1,p2));
	}
	static double distPS(double[] p1, double[] p2, double[] p) {
		double dP=ds(p1,p2),d1=ds(p1,p),d2=ds(p2,p);
		return (d2+dP<d1||d1+dP<d2)?Math.sqrt(Math.min(d1,d2)):distPL(p1,p2,p);
	}
	static double dist(double x1, double y1, double x2, double y2){
		return sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	static double longArco(double theta, double r){
		return theta*r;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0, N = (int)parseDouble(in.readLine().trim()); i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			double p1x = parseDouble(st.nextToken()), p1y = parseDouble(st.nextToken()),
			p2x = parseDouble(st.nextToken()), p2y = parseDouble(st.nextToken());
			double r = parseDouble(st.nextToken());
			if(p1x==p2x&&p1y==p2y)System.out.printf(Locale.US, "%.3f%n", 0.0);
			else{
				if(p1x==p2x){double x1 = p1x, x2 = p2x;p1x = p1y; p2x = p2y;p1y = x1; p2y = x2;}
				if(distPS(new double[]{p1x, p1y}, new double[]{p2x, p2y}, new double[]{0, 0})>=r)System.out.printf(Locale.US, "%.3f%n", dist(p1x, p1y, p2x, p2y));
				else{
					double distTang1 = sqrt(dist(p1x, p1y, 0,0)*dist(p1x, p1y, 0, 0) - r*r);
					double distTang2 = sqrt(dist(p2x, p2y, 0,0)*dist(p2x, p2y, 0, 0) - r*r);
					//Teorema del Coseno
					double theta = acos((-ds(new double[]{p1x, p1y}, new double[]{p2x, p2y}) + ds(new double[]{p1x, p1y}, new double[]{0, 0}) + ds(new double[]{p2x, p2y}, new double[]{0, 0}))/(2*dist(p1x, p1y, 0, 0)*dist(p2x, p2y, 0, 0))),
					phi = atan(distTang1/r), alpha = atan(distTang2/r);
					if(p1y - ((p1y-p2y)/(p1x-p2x)) * p1x == 0)System.out.printf(Locale.US, "%.3f%n", longArco(PI - phi - alpha, r) + distTang1 + distTang2);
					else System.out.printf(Locale.US, "%.3f%n", min(longArco(theta - phi - alpha, r), longArco(2*PI - theta - phi - alpha, r)) + distTang1 + distTang2);
				}
			}
		}
	}
}
