package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10060
 * @problemName A Hole to Catch a Man
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 31/03/2011
 **/
import static java.lang.Integer.parseInt;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class UVa10060 {
	static double area(Object[] pts) {
    	double res = 0; int n = pts.length;
    		for (int i = 0, j = 1; i < n; i++, j=(j+1)%n)
          		res += ((Point2D)pts[i]).getX()*((Point2D)pts[j]).getY() - ((Point2D)pts[i]).getY()*((Point2D)pts[j]).getX();
    	return Math.abs(res)/2;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int N; (N = parseInt(in.readLine().trim()))!=0;){
			double res = 0;
			for(int n = 0; n++ < N;){
				StringTokenizer st = new StringTokenizer(in.readLine());
				double t = Double.parseDouble(st.nextToken());
				ArrayList<Point2D> pts = new ArrayList<Point2D>();
				for(;st.hasMoreTokens();)
					pts.add(new Point2D.Double(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken())));
				res+=area(pts.toArray())*t;
			}
			StringTokenizer st = new StringTokenizer(in.readLine());
			res/=(Math.PI*Math.pow(Double.parseDouble(st.nextToken()),2)*Double.parseDouble(st.nextToken()));
			System.out.println((int)res);
		}
	}
}
