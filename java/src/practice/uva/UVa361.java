package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 361
 * @problemName Cops and Robbers
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 25/11/2010
 **/
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class UVa361 {
	static class Escaner{
		BufferedReader in;
		StringTokenizer st;
		Escaner(){
			in = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}
		int nextInt() throws Throwable{
			if(st.hasMoreTokens())return Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine().trim());
			return nextInt();
		}
	}
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
				if(!pts[k].equals(pts[0])){
					p1 = pts[k]; res[1%n]=pts[k];
					p2 = pts[(k+1)%n];
					i=k;j=2;
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
	static Shape getShape(Point2D[] pts){
		Path2D sh = new Path2D.Double(); 
		if(pts.length > 0){
			sh.moveTo(pts[0].getX(), pts[0].getY());
			for (int i = 1; i < pts.length; i++)sh.lineTo(pts[i].getX(), pts[i].getY());
			sh.closePath();
		}
		return sh;
	}
	static boolean puntoDentroPoligono(Point2D[] pts, Point2D pt, boolean conBorde, double epsilon){
		Path2D sh = new Path2D.Double(); 
		if(pts.length > 0){
			sh.moveTo(pts[0].getX(), pts[0].getY());
			for (int i = 1; i < pts.length; i++){
				if(new Line2D.Double(pts[i], pts[(i+1)%pts.length]).ptSegDist(pt) <= epsilon)return conBorde;
				sh.lineTo(pts[i].getX(), pts[i].getY());
			}
			sh.closePath();
		}
		return sh.contains(pt);
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Escaner sc = new Escaner();
		for(int c = 1;;c++){
			int N = sc.nextInt(), M = sc.nextInt(), Q = sc.nextInt();
			if(N==0 && M==0 && Q==0)break;
			Point2D[] tombos = new Point2D[N];
			Point2D[] ladrones = new Point2D[M];
			for (int i = 0; i < N; i++) 
				tombos[i] = new Point2D.Double(sc.nextInt(), sc.nextInt());
			for (int i = 0; i < M; i++) 
				ladrones[i] = new Point2D.Double(sc.nextInt(), sc.nextInt());
			Point2D[] convexTombos = convexHull(tombos, 1e-10, true), convexLadrones = convexHull(ladrones, 1e-10, true);
			sb.append("Data set " + c + ":\n");
			for (int i = 0; i < Q; i++) {
				Point2D civil = new Point2D.Double(sc.nextInt(), sc.nextInt());
				boolean ws1 = convexTombos.length > 2 && puntoDentroPoligono(convexTombos, civil, true, 1e-10), ws2 = convexLadrones.length > 2 && puntoDentroPoligono(convexLadrones, civil, true, 1e-10);
				sb.append("     Citizen at (" + (int)civil.getX() + "," + (int)civil.getY() + ") is " + (ws1?"safe":(ws2?"robbed":"neither")) + ".\n");
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}