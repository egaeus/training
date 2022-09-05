package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 378
 * @problemName Intersecting Lines
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 11/02/2013
 **/
import static java.lang.Integer.parseInt;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa378{
	static boolean line;
	static Point2D interseccionLn(Line2D l1,Line2D l2){
		double p1=l1.getX1(),p2=l1.getY1(),x1=l1.getX2(),y1=l1.getY2(),q1=l2.getX1(),
		q2=l2.getY1(),x2=l2.getX2(),y2=l2.getY2(),v1=x1-p1,v2=y1-p2,w1=x2-q1,w2=y2-q2,
		s1=v2*(q1-p1)-v1*(q2-p2),s2=w2*v1-w1*v2,s=s1/s2;
		line=Math.abs(s1)<1e-6&&Math.abs(s2)<1e-6;
		if(Math.abs(s2)<=1e-10)return null;
		return new Point2D.Double(q1+s*w1,q2+s*w2);
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		System.out.printf("INTERSECTING LINES OUTPUT\n");
		for(int N=parseInt(in.readLine().trim()),n=0;n++<N;){
			StringTokenizer st=new StringTokenizer(in.readLine());
			Line2D l1=new Line2D.Double(parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken())),
					l2=new Line2D.Double(parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken()));
			line=false;
			Point2D a=interseccionLn(l1,l2);
			if(a!=null)System.out.printf(Locale.US,"POINT %.2f %.2f\n",a.getX(),a.getY());
			else System.out.printf(line?"LINE\n":"NONE\n");
		}
		System.out.printf("END OF OUTPUT\n");
		System.out.print(new String(sb));
	}
}
