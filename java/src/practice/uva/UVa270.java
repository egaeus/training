package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict T.L.E.
 * @problemId 270
 * @problemName Lining Up
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level ?
 * @date 11/11/2010
 **/
import static java.lang.Double.parseDouble;
import static java.lang.Math.abs;
import static java.lang.Math.max;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVa270 {
	static double[] getLinea(Point2D p1, Point2D p2){
		double m = (p1.getY() - p2.getY())/(p1.getX() - p2.getX());
		if(m == Double.NEGATIVE_INFINITY)m = Math.abs(m);
		if(m == Double.POSITIVE_INFINITY)return new double[]{m, p1.getX()};
		return new double[]{m, p1.getY() - m*p1.getX()};
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int c = 0, N = (int)parseDouble(in.readLine().trim()); c < N; c++) {
			if(c==0)in.readLine();
			ArrayList<Point2D> arr = new ArrayList<Point2D>(700);
			for(;;){
				String ln = in.readLine();
				if(ln == null || ln.equals(""))break;
				StringTokenizer st = new StringTokenizer(ln.trim());
				arr.add(new Point2D.Double(parseDouble(st.nextToken()), parseDouble(st.nextToken())));
			}
			TreeMap<double[], Integer> map = new TreeMap<double[], Integer>(new Comparator<double[]>() {
				public int compare(double[] o1, double[] o2) {
					if(abs(o1[0] - o2[0]) <= 1e-4 && abs(o1[1] - o2[1]) <= 1e-4)return 0;
					if(o1[0] < o2[0])return -1;
					if(o1[0] > o2[0])return 1;
					if(o1[1] < o2[1])return -1;
					if(o1[1] > o2[1])return 1;
					return 0;
				}
			});
			int max = 0;
			for (int i = 0; i < arr.size(); i++) 
				for (int j = i + 1; j < arr.size(); j++) {
					double[] l = getLinea(arr.get(i), arr.get(j));
					Integer val = map.get(l);
					map.put(l, val==null?1:(val+1));
					max = max(max, val==null?1:(val+1));
				}
			System.out.println(max);
		}
	}
}
