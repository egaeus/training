package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 5138
 * @problemName Trash Removal
 * @judge http://livearchive.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 20/06/2011
 **/
import static java.lang.Integer.parseInt;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.StringTokenizer;
public class LAUVa5138 {
	static boolean doubleEquals(double a, double b, double epsilon){
		if(Math.abs(a) == Double.POSITIVE_INFINITY && Math.abs(b) == Double.POSITIVE_INFINITY)return true;
		return Math.abs(a-b) <= epsilon;
	}
	static double dist(Point2D p, Point2D q) {
		return (p.getX() - q.getX()) * (p.getX() - q.getX()) + (p.getY() - q.getY()) * (p.getY() - q.getY());
	}
	static double movimientoVectorial(Point2D p, Point2D q, Point2D r){
		return (q.getX()-p.getX())*(r.getY()-p.getY()) - (q.getY()-p.getY())*(r.getX()-p.getX());
	}
	static Point2D[] convexHull(Point2D[] pts, final double epsilon, boolean conBorde){
		if(pts.length==0)return new Point2D[0];
		int n=pts.length;
		Point2D[] res=new Point2D[n];
		Point2D p=new Point2D.Double(Double.MAX_VALUE,Double.MAX_VALUE);
		for(Point2D q:pts)
			if(q.getY()<p.getY()||(doubleEquals(q.getY(),p.getY(),epsilon)&&q.getX()<p.getX()))p=q;
		final Point2D P=p;
		Arrays.sort(pts, new Comparator<Point2D>() {
			public int compare(Point2D o1, Point2D o2) {
				if(o1==P)return -1;if(o2==P)return 1;
				double dist1=Math.atan2(o1.getX()-P.getX(),o1.getY()-P.getY()),
				dist2=Math.atan2(o2.getX()-P.getX(),o2.getY()-P.getY());
				return doubleEquals(dist1,dist2,epsilon)?(dist(P,o1)<dist(P,o2)?1:-1):(dist1<dist2?-1:1);
			}
		});
		int j=Math.min(2, n);int i=j+1;
		res[0]=p;res[1%n]=pts[1%n];
		Point2D p1=pts[1%n],p2=pts[2%n];
		if(!conBorde){
			j = 1;
			for (int k = 1; k < n; k++)
				if(!pts[k].equals(pts[0])){p1 = pts[k]; res[1%n]=pts[k];
					p2 = pts[(k+1)%n];i=k;j=2;break;}
		}
		for (; i <= n; i++)
			if((doubleEquals(movimientoVectorial(p2,p1,pts[i%n]),0,epsilon)&&conBorde)||(!doubleEquals(movimientoVectorial(p2, p1, pts[i%n]),0,epsilon)&&movimientoVectorial(p2,p1,pts[i%n])>0)){
				if(p2!=pts[1])res[j++]=p2;
	 			p1=p2;p2=pts[i%n];
			}
			else {
				if(i>2&&!doubleEquals(movimientoVectorial(p2,p1,pts[i%n]),0,epsilon))i--;
				if(j-2<0)p1=res[0];else p1 =res[j-2];p2 = res[j-1];
				if(j > 2){res[--j] = null;}
			}
		return Arrays.copyOfRange(res, 0, j);
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int N, c=1;(N=parseInt(in.readLine().trim()))!=0; c++){
			Point2D[] pts=new Point2D[N];
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				pts[i]=new Point2D.Double(parseInt(st.nextToken()), parseInt(st.nextToken()));
			}
			Point2D[] convex=convexHull(pts, 1e-10, false);
			double res = Double.POSITIVE_INFINITY;
			for(int i=0;i<convex.length;i++){
				double v=0;
				for(Point2D p: convex)
					v=Math.max(v, new Line2D.Double(convex[i], convex[(i+1)%convex.length]).ptLineDistSq(p));
				res=Math.min(res, v);
			}
			System.out.printf(Locale.US, "Case %d: %.2f%n", c, Math.ceil(Math.sqrt(res)*100)/100);
		}
	}
}
