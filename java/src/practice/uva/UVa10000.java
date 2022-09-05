package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10000
 * @problemName Longest Paths
 * @judge http://uva.onlinejudge.org/
 * @category Graph
 * @level easy
 * @date 05/10/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class UVa10000 {
	public static void main(String[] args) throws Throwable{
		StringBuffer sb = new StringBuffer();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int N, cont = 1; (N = parseInt(in.readLine().trim())) != 0; cont++){
			ArrayList<Integer> lAdy[] = new ArrayList[N];
			for (int i = 0; i < lAdy.length; i++) lAdy[i] = new ArrayList<Integer>();
			int v = parseInt(in.readLine().trim());
			for(; ;){
				StringTokenizer st = new StringTokenizer(in.readLine().trim());
				int desde = parseInt(st.nextToken()) - 1, hasta = parseInt(st.nextToken()) - 1;
				if(desde == -1 && hasta == -1)break;
				lAdy[desde].add(hasta);
			}
			int[] solucion = new int[N];
			function(v - 1, lAdy, solucion, new boolean[N]);
			int max = 0, val = 0;
			for (int i = 0; i < solucion.length; i++)
				if(max < solucion[i]){
					max = solucion[i];
					val = i;
				}
			sb.append("Case " + cont + ": The longest path from " + v + " has length " + max + ", finishing at " + (val+1) + ".\n\n");
		}
		System.out.print(new String(sb));
	}
	static void function(int v, ArrayList<Integer> lAdy[], int[] solucion, boolean visitados[]){
		for(int i: lAdy[v]){
			if(solucion[v] + 1 > solucion[i]){
				solucion[i] = solucion[v] + 1;
				function(i, lAdy, solucion, visitados);
			}
		}
	}
}
