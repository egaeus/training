package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict T.L.E.
 * @problemId 184
 * @problemName Laser Lines
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level ?
 * @date 11/11/2010
 **/
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class UVa184 {
	static class Escaner{
		BufferedReader in;
		StringTokenizer st;
		Escaner(){
			in = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}
		public int nextInt() throws Throwable{
			if(!st.hasMoreTokens()){
				st = new StringTokenizer(in.readLine().trim());
				return nextInt();
			}
			return parseInt(st.nextToken());
		}
	}
	public static void main(String[] args) throws Throwable{
		Escaner sc = new Escaner();
		StringBuffer sb = new StringBuffer();
		ArrayList<Point2D> pts = new ArrayList<Point2D>();
		for(;;){
			pts.add(new Point2D.Double(sc.nextInt(), sc.nextInt()));
			if(pts.get(0).getX() == 0 && pts.get(0).getY() == 0)break;
			for(;;){
				pts.add(new Point2D.Double(sc.nextInt(), sc.nextInt()));
				if(pts.get(pts.size() - 1).getX() == 0 && pts.get(pts.size() - 1).getY() == 0)break;
			}
			pts.remove(pts.size() - 1);			
			ArrayList<TreeSet<Point2D>> lineas = new ArrayList<TreeSet<Point2D>>();
			final Comparator<Point2D> comp = new Comparator<Point2D>() {
				public int compare(Point2D o1, Point2D o2) {
					if(o1.getX() < o2.getX())return -1;
					if(o1.getX() > o2.getX())return 1;
					if(o1.getY() < o2.getY())return -1;
					if(o1.getY() > o2.getY())return 1;
					return 0;
				}
			};	
			for (int i = 0; i < pts.size(); i++) {
				for (int j = i + 1; j < pts.size(); j++) {
					boolean ws = false;
					for (int k = 0; k < lineas.size(); k++) {
						if(lineas.get(k).contains(pts.get(i))){
							Line2D l = new Line2D.Double(lineas.get(k).first(), lineas.get(k).last());
							if(l.ptLineDist(pts.get(j)) <= 1E-10){
								lineas.get(k).add(pts.get(j));
								ws = true;
							}
						}
					}
					if(!ws){
						lineas.add(new TreeSet<Point2D>(comp));
						lineas.get(lineas.size() - 1).add(pts.get(i));
						lineas.get(lineas.size() - 1).add(pts.get(j));
					}
				}
			}
			Object[] arr = lineas.toArray();
			Arrays.sort(arr, new Comparator<Object>() {
				public int compare(Object arg1, Object arg2) {
					Object[] arr1 = ((TreeSet)arg1).toArray();
					Object[] arr2 = ((TreeSet)arg2).toArray();
					for (int i = 0; i < min(arr1.length, arr2.length); i++) 
						if(comp.compare((Point2D)arr1[i], (Point2D)arr2[i]) != 0)return comp.compare((Point2D)arr1[i], (Point2D)arr2[i]);
					return 0;
				}
			});
			String casos = "";
			for (Object set: arr) {
				if(((TreeSet)set).size() > 2){
					for (Object p: (TreeSet)set) 
						casos += "(" + llenarEspacios((int)((Point2D)p).getX() + "") + "," + llenarEspacios((int)((Point2D)p).getY() + "") + ")";
					casos += "\n";					
				}
			}
			if(casos.equals(""))sb.append("No lines were found\n");
			else sb.append("The following lines were found:\n" + casos);			
			pts = new ArrayList<Point2D>();
		}
		System.out.print(new String(sb));
	}
	static String llenarEspacios(String str){
		while(str.length() < 4)
			str = " " + str;
		return str;
	}
}
