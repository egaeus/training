package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 476
 * @problemName Points in Figures: Rectangles 
 * @judge http://uva.onlinejudge.org/
 * @category geometry
 * @level easy
 * @date 2010
 **/
import static java.lang.Double.parseDouble;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVa476 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Point[]> rect = new ArrayList<Point[]>();
		StringBuffer sb = new StringBuffer();
		for (String ln; !(ln = in.readLine().trim()).equals("*");) {
			String[] arr = ln.split(" +");
			if(arr[0].equals("r"))
				rect.add(new Point[]{new Point(parseDouble(arr[1]), parseDouble(arr[2])), new Point(parseDouble(arr[3]), parseDouble(arr[4]))});
		}
		int cont = 0;
		while(true){
			String ln[] = in.readLine().trim().split(" +");
			Point p = new Point(parseDouble(ln[0]), parseDouble(ln[1]));
			if(p.x == 9999.9 && p.y == 9999.9)break;
			boolean ws = false;
			for (int i = 0; i < rect.size(); i++) 
				if(p.dentroRect(rect.get(i))){
					sb.append("Point " + (cont + 1) + " is contained in figure " + (i + 1) + "\n");
					ws = true;
				}
			if(!ws)sb.append("Point " + (cont + 1) + " is not contained in any figure\n");
			cont++;
		}
		System.out.print(new String(sb));
	}
	static class Point{
		public double x, y;
		Point(double x, double y){
			this.x = x;
			this.y = y;
		}
		public boolean dentroRect(Point[] rect){
			if(x <= rect[0].x)return false;
			if(x >= rect[1].x)return false;
			if(y >= rect[0].y)return false;
			if(y <= rect[1].y)return false;
			return true;
		}
	}
}
