package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict W.A.
 * @problemId 681
 * @problemName Convex Hull Finding 
 * @judge http://uva.onlinejudge.org/
 * @category geometry
 * @level easy
 * @date 25/11/2010
 **/
import static java.lang.Integer.parseInt;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class UVa681 {
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
		if(!conBorde){j = 1;
		for (int k = 1; k < res.length; k++)
			if(!pts[k].equals(pts[0])){
				p1 = pts[k]; res[1%n] = pts[k];
				p2 = pts[(k+1)%n];
				i = k+1; j = 2;
				break;
			}
		}
		for (; i <= n; i++)
		if(doubleEquals(movimientoVectorial(p2,p1,pts[i%n]),0,epsilon)&&conBorde||(!doubleEquals(movimientoVectorial(p2, p1, pts[i%n]),0,epsilon)&&movimientoVectorial(p2,p1,pts[i%n])>0)){
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
	
	static int sgn(double x) {return Math.abs(x)>9.9e-12?(x<0?-1:1):0;}
	static double cruz(double[] a, double[] b) {return a[0]*b[1]-a[1]*b[0];}
	static double cruz(double[] a, double[] b, double[] c) {return cruz(a,b)+cruz(b,c)+cruz(c,a);}
	static double[][] convexHullGS(double[][] pt, boolean bd) { // bd: con borde?
	int h=pt.length,i=h,t=0; double v[]=null,w[],r[][]=new double[h][];
	for (double[] p:pt) if (v==null||p[1]<v[1]||(p[1]==v[1]&&p[0]>v[0])) v=p; v=v.clone();
	for (double[] p:pt) {p[0]-=v[0]; p[1]-=v[1];}
	Arrays.sort(pt,new Comparator<double[]>() {public int compare(double[] a, double[] b)
	{double cz=cruz(b,a); return sgn(sgn(cz)!=0?cz:a[0]*a[0]+a[1]*a[1]-b[0]*b[0]-b[1]*b[1]);}});
	if (bd) while (i-1>=0&&cruz(pt[h-1],pt[i-1])==0) i--;
	if (bd) for (int k=i; k<(i+h)/2; k++) {w=pt[k]; pt[k]=pt[h-1-k+i]; pt[h-1-k+i]=w;}
	for (double[] p:pt) {while (t>=2&&sgn(cruz(r[t-1],p,r[t-2]))<(bd?0:1)) t--; r[t++]=p;}
	for (double[] p:pt) {p[0]+=v[0]; p[1]+=v[1];}
	return Arrays.copyOfRange(r,0,t);
	}
	
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int K = parseInt(in.readLine().trim());
		sb.append(K + "\n");
		for (int k = 0; k < K; k++) {
			int N = parseInt(in.readLine().trim());
			Point2D pts[] = new Point2D[N];
			double[][] points = new double[N][2];
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(in.readLine().trim());
				pts[n] = new Point2D.Double(points[n][0]=parseInt(st.nextToken()), points[n][1]=parseInt(st.nextToken()));
			}
			if(k<K-1)in.readLine();
			//Point2D[] convex = convexHull(pts, 1e-10, false);
			double[][] convexAlejandro = convexHullGS(points, false);
//			sb.append((convex.length + 1) + "\n");
//			sb.append((int)convex[0].getX() + " " + (int)convex[0].getY() + "\n");
//			for (int i = convex.length - 1; i >= 0; i--)
//				sb.append((int)convex[i].getX() + " " + (int)convex[i].getY() + "\n");
//			if(convex.length == 1)sb.append((int)convex[0].getX() + " " + (int)convex[0].getY() + "\n");
			sb.append((convexAlejandro.length + 1) + "\n");
			for (int i = 0; i < convexAlejandro.length; i++)
				sb.append((int)convexAlejandro[i][0] + " " + (int)convexAlejandro[i][1] + "\n");
			sb.append((int)convexAlejandro[0][0] + " " + (int)convexAlejandro[0][1] + "\n");
			//if(convexAlejandro.length == 1)sb.append((int)convexAlejandro[0][0] + " " + (int)convexAlejandro[0][1] + "\n");
			if(k<K-1)sb.append("-1\n");
		}
		System.out.print(new String(sb));
	}
}
