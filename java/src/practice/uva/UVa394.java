package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 394
 * @problemName Mapmaker
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 27/07/2010
 **/
import static java.lang.Integer.parseInt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVa394 {
	static class Array{
		String nombre;
		int b, cd;
		ArrayList<Point> bounds;
		Array(String val){
			StringTokenizer st = new StringTokenizer(val);
			bounds = new ArrayList<Point>();
			nombre = st.nextToken();
			b = parseInt(st.nextToken());
			cd = parseInt(st.nextToken());
			for (int i = 0, D = parseInt(st.nextToken()); i < D; i++) 
				bounds.add(new Point(parseInt(st.nextToken()), parseInt(st.nextToken())));
		}
		public int hallarDireccion(String val){
			StringTokenizer st = new StringTokenizer(val);
			st.nextToken();
			ArrayList<Integer> A = new ArrayList<Integer>();
			for (int i = 0; i < bounds.size(); i++) A.add(parseInt(st.nextToken()));
			int C[] = new int[A.size()];
			C[C.length - 1] = cd;
			for (int i = C.length - 2; i >= 0; i--) C[i]=C[i+1]*(bounds.get(i+1).y-bounds.get(i+1).x+1);
			int res = b;
			for (int i = 0; i < C.length; i++) res-=C[i]*bounds.get(i).x;
			for (int i = 0; i < C.length; i++) res+=C[i]*A.get(i);
			return res;
		}
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int N = parseInt(st.nextToken()), R = parseInt(st.nextToken());
		Array[] arreglos = new Array[N];
		TreeMap<String, Integer> posiciones = new TreeMap<String, Integer>();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			String ln = in.readLine().trim();
			st = new StringTokenizer(ln);
			posiciones.put(st.nextToken(), i);
			arreglos[i] = new Array(ln);
		}
		for (int i = 0; i < R; i++) {
			String ln = in.readLine().trim();
			st = new StringTokenizer(ln);
			String nombre = st.nextToken();
			String linea = nombre + "[";
			for (int j = 0; j < arreglos[posiciones.get(nombre)].bounds.size(); j++)linea+=st.nextToken()+(j<arreglos[posiciones.get(nombre)].bounds.size()-1?", ":"] = ");
			linea += arreglos[posiciones.get(nombre)].hallarDireccion(ln);
			sb.append(linea + "\n");
		}
		System.out.print(new String(sb));
	}
}
