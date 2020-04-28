package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 837
 * @problemName Light and Transparencies
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 10/08/2010
 **/
import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
public class UVa837 {
	public static void main(String[] args) throws Throwable{
		Comparator<Line2D> comp = new Comparator<Line2D>() {
			public int compare(Line2D l1, Line2D l2) {
				if(l1.getP1().getX()<l2.getP1().getX())return -1;
				if(l1.getP1().getX()>l2.getP1().getX())return 1;
				if(l1.getP2().getX()<l2.getP2().getX())return -1;
				if(l1.getP2().getX()>l2.getP2().getX())return 1;
				if(l1.getP1().getY()<l2.getP1().getY())return -1;
				if(l1.getP1().getY()>l2.getP1().getY())return 1;
				if(l1.getP2().getY()<l2.getP2().getY())return -1;
				if(l1.getP2().getY()>l2.getP2().getY())return 1;
				return 0;
			}
		};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0, N = parseInt(in.readLine().trim()); i < N; i++) {
			in.readLine();
			TreeMap<Line2D, Double> lineas = new TreeMap<Line2D, Double>(comp);
			TreeSet<Double> esquinas = new TreeSet<Double>();
			for (int j = 0, M = parseInt(in.readLine().trim()); j < M; j++) {
				StringTokenizer st = new StringTokenizer(in.readLine().trim());
				double x1 = parseDouble(st.nextToken()), y1 = parseDouble(st.nextToken()),
				x2 = parseDouble(st.nextToken()), y2 = parseDouble(st.nextToken());
				lineas.put(new Line2D.Double(x1<x2?x1:x2, x1<x2?y1:y2, x1<x2?x2:x1, x1<x2?y2:y1), parseDouble(st.nextToken()));
				esquinas.add(x1);
				esquinas.add(x2);
			}
			double ant = NEGATIVE_INFINITY;
			System.out.println(esquinas.size() + 1);
			System.out.printf(Locale.US, "-inf %.3f 1.000%n", esquinas.first());
			for (double d: esquinas) {
				double res = 1;
				for (Entry<Line2D, Double> entry: lineas.entrySet()) 
					if(d > entry.getKey().getX1() && d <= entry.getKey().getX2())res*=entry.getValue();				
				if(ant != NEGATIVE_INFINITY)
					System.out.printf(Locale.US, "%.3f %.3f %.3f%n", ant, d, res);				
				ant = d;
			}
			System.out.printf(Locale.US, "%.3f +inf 1.000%n", esquinas.last());
			if(i < N-1)System.out.println();
		}
	}
}
