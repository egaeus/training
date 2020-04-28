package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict T.L.E. (Closest Pair mal hecho)
 * @problemId 10245
 * @problemName The Closest Pair Problem
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level ?
 * @date 17/12/2010
 **/
import static java.lang.Integer.parseInt;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa10245 {
	static double dist(Point2D p, Point2D q) {
		return (p.getX() - q.getX()) * (p.getX() - q.getX()) + (p.getY() - q.getY()) * (p.getY() - q.getY());
	}
	static Point2D[] getClosestPair(Point2D[] pts){
		Point2D[] ptsY = new Point2D[pts.length];
		for (int i = 0; i < ptsY.length; i++)ptsY[i] = (Point2D)pts[i].clone();
		Arrays.sort(pts, new Comparator<Point2D>() {
			public int compare(Point2D o1, Point2D o2) {
				if(o1.getX() < o2.getX())return -1;if(o1.getX() > o2.getX())return 1;
				if(o1.getY() < o2.getY())return -1;if(o1.getY() > o2.getY())return 1;
				return 0;
			}
		});
		Arrays.sort(ptsY, new Comparator<Point2D>() {
			public int compare(Point2D o1, Point2D o2) {
				if(o1.getY() < o2.getY())return -1;if(o1.getY() > o2.getY())return 1;
				if(o1.getX() < o2.getX())return -1;if(o1.getX() > o2.getX())return 1;
				return 0;
			}
		});
		return getClosestPair(pts, ptsY, 0, pts.length - 1);
	}
	static Point2D[] getClosestPair(Point2D[] ptsX, Point2D[] ptsY, int izq, int der){
		Point2D[] res = new Point2D[]{new Point2D.Double(Double.MAX_VALUE, Double.MAX_VALUE), new Point2D.Double(Double.MIN_VALUE, Double.MIN_VALUE)};
		if(der > izq){
			if(der - izq == 1)return new Point2D[]{ptsX[der], ptsX[izq]};
			int pm = (der+izq)/2;
			res = getClosestPair(ptsX, ptsY, izq, pm);
			Point2D[] temp = getClosestPair(ptsX, ptsY, pm+1, der);
			if(temp[0].distanceSq(temp[1]) < res[0].distanceSq(res[1]))res = temp;
			double dist = res[0].distanceSq(res[1]);int cont = 0;
			Point2D[] pts = new Point2D[ptsX.length];
			for(Point2D p: ptsY)if(p.distance(ptsX[pm]) < dist)pts[cont++] = p;
			for(int i = 0; i < cont; i++)	
				for (int j = i + 1, k = 0; j < cont && k < 12; j++, k++)
					if(pts[i].distance(pts[j]) < dist){
						res[0] = pts[i];res[1] = pts[j]; dist = pts[i].distance(pts[j]);
					}
		}
		return res;
	}
	static int jsdfjsdj;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int N; (N = parseInt(in.readLine().trim())) != 0; ) {
			Point2D[] pts = new Point2D[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine().trim());
				pts[i] = new Point2D.Double(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
			}
			long t = System.currentTimeMillis();
			jsdfjsdj = 0;
			Point2D res[] = getClosestPair(pts);
			System.out.println(t - System.currentTimeMillis() + " " + jsdfjsdj);
			if(res[0].distance(res[1]) < 10000)System.out.printf(Locale.US, "%.4f%n", res[0].distance(res[1]));
			else System.out.printf("INFINITY%n");
		}
	}
}
