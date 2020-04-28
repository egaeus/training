package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10004
 * @problemName Bicoloring
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;
public class UVa10004 {
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int n = Integer.parseInt(in.readLine().trim());
			if (n == 0)break;
			ArrayList<Integer>[] lAdy = new ArrayList[n];
			int m = Integer.parseInt(in.readLine().trim());
			boolean[][] mAdy = new boolean[n][n];
			for (int i = 0; i < m; i++) {
				String s[] = in.readLine().trim().split(" +");
				int u = Integer.parseInt(s[0]), v = Integer.parseInt(s[1]);
				if(lAdy[u]==null)lAdy[u] = new ArrayList<Integer>();
				if(lAdy[v]==null)lAdy[v] = new ArrayList<Integer>();
				lAdy[u].add(v);
				lAdy[v].add(u);
			}
			System.out.println(bicor(lAdy, new TreeSet<Integer>(), 1, 0, new int[n]) ? "BICOLORABLE." : "NOT BICOLORABLE.");
		}
	}
	public static boolean bicor(ArrayList<Integer>[] lAdy, TreeSet<Integer> visitados, int color, int nodo, int[] colores){
		boolean ws = true;
		if(!visitados.contains(nodo)){
			visitados.add(nodo);
			colores[nodo] = color;
			for (int i = 0; i < lAdy[nodo].size(); i++) ws = bicor(lAdy, visitados, color==1?2:1, lAdy[nodo].get(i), colores);
		}
		else if(colores[nodo]!=color && colores[nodo]!=0)ws = false; 
		return ws;
	}
}