package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId ANARC09F
 * @problemName Air Strike
 * @judge http://www.spoj.pl
 * @category geometry
 * @level easy
 * @date 22/03/2011
 **/
import static java.lang.Double.parseDouble;
import static java.lang.Math.max;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SPOJANARC09F {
	static class Escaner{
		BufferedReader in;
		StringTokenizer st;
		Escaner() throws Throwable{
			in = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}
		public String next() throws Throwable{
			if(st.hasMoreTokens())return st.nextToken();
			st = new StringTokenizer(in.readLine());
			return next();
		}
	}
	static double distanceSq(double[] p1, double[] p2){
		return (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
	}
	static double distance(double[] p1, double p2[]){
		return sqrt(distanceSq(p1, p2));
	}
	static final double pi = 3.141;
	public static void main(String[] args) throws Throwable{
		Escaner sc = new Escaner();
		for(int N, caso = 1; (N = Integer.parseInt(sc.next()))!=0; caso++){
			double[] c1 = new double[]{parseDouble(sc.next()), parseDouble(sc.next())},
			c2 = new double[]{parseDouble(sc.next()), parseDouble(sc.next())};
			double area = parseDouble(sc.next());
			double[][] pts = new double[N][2];
			for(int i = 0; i < N; i++)
				pts[i] = new double[]{parseDouble(sc.next()), parseDouble(sc.next())};
			int max = 0;
			for(int i = 0; i < N; i++){
				boolean ws = pi*distanceSq(pts[i],c1)<=area,
				ws2 = pi*distanceSq(pts[i],c2)<=area;
				if(ws||ws2){
					int cont = 0, cont1 = 0;
					double radio1=0,radio2=0,radio12=0,radio11=0; 
					if(ws){
						radio1 = distance(pts[i],c1);
						radio2 = sqrt((area-pi*distanceSq(pts[i],c1))/pi);
					}
					if(ws2){
						radio12 = distance(pts[i],c2);
						radio11 = sqrt((area-pi*distanceSq(pts[i],c2))/pi);
					}
					for(int j = 0; j < N; j++){
						if(ws&&(distance(c1,pts[j])<=radio1||distance(c2,pts[j])<=radio2))cont++;
						if(ws2&&(distance(c1,pts[j])<=radio11||distance(c2,pts[j])<=radio12))cont1++;
					}
					max = max(max, max(cont, cont1));
				}		
			}
			System.out.println(caso+". "+(N-max));
		}
	}
}
