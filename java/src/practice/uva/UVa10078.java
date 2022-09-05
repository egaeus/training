package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10078
 * @problemName The art Gallery
 * @judge http://uva.onlinejudge.org/
 * @category geometry
 * @level easy
 * @date 29/04/2010
 **/
import static java.lang.Integer.parseInt;

import java.awt.Polygon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa10078 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int N; (N = parseInt(in.readLine().trim()))!=0; ) {
			int[][] puntos = new int[N][2]; 
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine().trim());
				puntos[i][0] = parseInt(st.nextToken());
				puntos[i][1] = parseInt(st.nextToken());
			}
			boolean ws = true;
			for (int i = 0; i < N && ws; i++) {
				Polygon poligono = new Polygon();
				for (int j = 0; j < N && ws; j++) if(i!=j)poligono.addPoint(puntos[j][0], puntos[j][1]);
				ws = !poligono.contains(puntos[i][0], puntos[i][1]);
			}
			System.out.println(ws?"No":"Yes");
		}
	}
}
