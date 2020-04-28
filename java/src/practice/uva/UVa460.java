package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 460
 * @problemName Overlapping Rectangles
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 12/02/2013
 **/
import static java.lang.Integer.parseInt;

import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa460{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int N=parseInt(in.readLine().trim()),n=0;n++<N;){
			if(n>1)sb.append("\n");
			in.readLine();
			Rectangle2D r1=null,r2=null,r3=new Rectangle2D.Double();
			{
				StringTokenizer st=new StringTokenizer(in.readLine());
				int x1=parseInt(st.nextToken()),y1=parseInt(st.nextToken()),x2=parseInt(st.nextToken()),y2=parseInt(st.nextToken());
				r1=new Rectangle2D.Double(x1,y1,x2-x1,y2-y1);
			}
			{
				StringTokenizer st=new StringTokenizer(in.readLine());
				int x1=parseInt(st.nextToken()),y1=parseInt(st.nextToken()),x2=parseInt(st.nextToken()),y2=parseInt(st.nextToken());
				r2=new Rectangle2D.Double(x1,y1,x2-x1,y2-y1);
			}
			Rectangle2D.intersect(r1,r2,r3);
			double area1=r3.getWidth()*r3.getHeight();
			if(area1>0)sb.append((int)r3.getX()+" "+(int)r3.getY()+" "+(int)(r3.getX()+r3.getWidth())+" "+(int)(r3.getY()+r3.getHeight())+"\n");
			else sb.append("No Overlap\n");
		}
		System.out.print(new String(sb));
	}
}
