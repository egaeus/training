package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10044
 * @problemName Erdos Numbers 
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 13/12/2010
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
public class UVa10044 {
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int c = 0, C = parseInt(in.readLine().trim()); c < C; c++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
			TreeMap<String, Integer> mapa = new TreeMap<String, Integer>();
			ArrayList<TreeSet<Integer>> lAdy = new ArrayList<TreeSet<Integer>>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine().trim(), ":");
				st = new StringTokenizer(st.nextToken(), ",");
				ArrayList<String> nombres = new ArrayList<String>();
				for (boolean ws = true; st.hasMoreTokens(); ws=!ws)
					if(ws)nombres.add(st.nextToken().trim());
					else nombres.set(nombres.size() - 1, nombres.get(nombres.size() - 1) + "," + st.nextToken());
				for (int j = 0; j < nombres.size(); j++) 
					for (int k = j + 1; k < nombres.size(); k++) 
						if(!nombres.get(j).equals(nombres.get(k))){
							if(!mapa.containsKey(nombres.get(j))){
								mapa.put(nombres.get(j), lAdy.size());
								lAdy.add(new TreeSet<Integer>());
							}
							if(!mapa.containsKey(nombres.get(k))){
								mapa.put(nombres.get(k), lAdy.size());
								lAdy.add(new TreeSet<Integer>());
							}
							int desde = mapa.get(nombres.get(j)), hasta = mapa.get(nombres.get(k));
							lAdy.get(desde).add(hasta);
							lAdy.get(hasta).add(desde);
						}
			}
			dijkstra = new int[lAdy.size()];
			Integer erdos = mapa.get("Erdos, P.");
			Arrays.fill(dijkstra, MAX_VALUE);
			if(erdos != null){
				dijkstra[erdos] = 0;
				getDijkstra(lAdy, erdos);
			}
			sb.append("Scenario " + (c+1) + "\n");
			for (int j = 0; j < M; j++) {
				String nombre = in.readLine();
				Integer man = mapa.get(nombre);
				sb.append(nombre + " ");
				if(man == null)sb.append("infinity");
				else sb.append(dijkstra[man]<MAX_VALUE?dijkstra[man]:"infinity");
				sb.append("\n");
			}
		}
		System.out.print(new String(sb));
	}
	static int[] dijkstra;
	static void  getDijkstra(ArrayList<TreeSet<Integer>> lAdy, int desde){
		for(int hasta: lAdy.get(desde)){
			if(dijkstra[hasta] > dijkstra[desde] + 1){
				dijkstra[hasta] = dijkstra[desde] + 1;
				getDijkstra(lAdy, hasta);
			}
		}
	}
}
