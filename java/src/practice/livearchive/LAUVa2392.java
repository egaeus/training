package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2392
 * @problemName Points Within
 * @judge http://livearchive.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 11/08/2011
 **/
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2392 {
	static class Escaner{
		BufferedReader in;
		StringTokenizer st;
		Escaner(){
      			in = new BufferedReader(new InputStreamReader(System.in));
      			st = new StringTokenizer("");
		}
		int nextInt() throws Throwable{
      			if(st.hasMoreTokens())return Integer.parseInt(st.nextToken());
      			st = new StringTokenizer(in.readLine());
      			return nextInt();
		}
	}
	static boolean puntoDentroPoligono(Point2D[] pts,Point2D pt,boolean conBorde){
		Path2D sh=new Path2D.Double();int n;
		if((n=pts.length)==1)return pt.equals(pts[0])&&conBorde;
		if(n>0){
			sh.moveTo(pts[0].getX(),pts[0].getY());
			for (int i=1;i<pts.length;i++){
            	if(new Line2D.Double(pts[i],pts[(i+1)%n]).ptSegDist(pt)<1e-10)return conBorde;
            	sh.lineTo(pts[i].getX(),pts[i].getY());
            }
      		sh.closePath();
		}
		return sh.contains(pt);
	}
	public static void main(String[] args) throws Throwable{
		Escaner sc=new Escaner();
		StringBuilder sb=new StringBuilder();int caso=1;
		for(int N,M;(N=sc.nextInt())!=0;caso++){
			if(caso>1)sb.append("\n");
			M=sc.nextInt();
			Point2D[] pts=new Point2D[N];
			for(int i=0;i<N;i++){
				pts[i]=new Point2D.Double(sc.nextInt(),sc.nextInt());
			}
			sb.append("Problem "+caso+":\n");
			for(int i=0;i<M;i++){
				if(puntoDentroPoligono(pts, new Point2D.Double(sc.nextInt(), sc.nextInt()), true))
					sb.append("Within\n");
				else sb.append("Outside\n");
			}
		}
		System.out.print(new String(sb));
	}
}
