package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 186
 * @problemName Trip Routing
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 28/03/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVa186 {
	public static void main(String[] args) throws Throwable{
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, Integer> vertices = new TreeMap<String, Integer>();
		TreeMap<Integer, String> verticesV = new TreeMap<Integer, String>();
		ArrayList<String> lineas = new ArrayList<String>();
		for(String ln; !(ln = in.readLine().trim()).equals(""); ){
			lineas.add(ln);
			StringTokenizer st = new StringTokenizer(ln, ",");
			String desde = st.nextToken(), hasta = st.nextToken();
			if(!vertices.containsKey(desde)){
				verticesV.put(vertices.size(), desde);
				vertices.put(desde, vertices.size());
			}
			if(!vertices.containsKey(hasta)){
				verticesV.put(vertices.size(), hasta);
				vertices.put(hasta, vertices.size());
			}
		}
		int N = vertices.size(); int mAdy[][] = new int[N][N];
		for(int i=0;i<N;i++)for(int j=0;j<N;j++)mAdy[i][j]=MAX_VALUE;
		String[][] rutas = new String[N][N];
		for(String ln: lineas){
			StringTokenizer st = new StringTokenizer(ln, ",");
			int desde = vertices.get(st.nextToken()), hasta = vertices.get(st.nextToken());
			String ruta = st.nextToken();
			int costo = parseInt(st.nextToken());
			if(mAdy[desde][hasta]>costo){
				rutas[desde][hasta] = rutas[hasta][desde] = ruta;
				mAdy[desde][hasta] = mAdy[hasta][desde] = costo;
			}
		}
		res = floydWarshall(mAdy);
		for(String ln; (ln = in.readLine())!=null;){
			StringTokenizer st = new StringTokenizer(ln, ",");
			int desde = vertices.get(st.nextToken()), hasta = vertices.get(st.nextToken());
			ArrayList<Integer> sol = new ArrayList<Integer>();
			sol.add(desde);sol.addAll(function(desde, hasta));
			sb.append("\n\n");
			sb.append("From                 To                   Route      Miles\n");
			sb.append("-------------------- -------------------- ---------- -----\n");
			for(int i = 0; i < sol.size() - 1; i++){
				String d = verticesV.get(sol.get(i));
				sb.append(d);
				for(int j = d.length(); j < 21; j++)
					sb.append(" ");
				d = verticesV.get(sol.get(i+1));
				sb.append(d);
				for(int j = d.length(); j < 21; j++)
					sb.append(" ");
				d = rutas[sol.get(i)][sol.get(i+1)];
				sb.append(d);
				for(int j = d.length(); j < 11; j++)
					sb.append(" ");
				d = mAdy[sol.get(i)][sol.get(i+1)]+"";
				for(int j = d.length(); j < 5; j++)
					sb.append(" ");
				sb.append(d+"\n");				
			}
			String d = res[desde][hasta][0]+"";
			sb.append("                                                     -----\n");
			sb.append("                                          Total      ");
			for(int j = d.length(); j < 5; j++)
				sb.append(" ");
			sb.append(d+"\n");
		}
		System.out.print(new String(sb));
	}
	static int[][][] res;
	static int[][][] floydWarshall(int[][] mAdy){
		int N; int[][][] res = new int[N=mAdy.length][N][2];
		for(int i=0;i<N;i++)for(int j=0;j<N;j++)res[i][j]=new int[]{mAdy[i][j], j};
		for(int k=0;k<N;k++)
			for(int i=0;i<N;i++)for(int j=0;j<N;j++)
				if(res[i][k][0]<MAX_VALUE&&res[k][j][0]<MAX_VALUE)
					if(res[i][j][0]>res[i][k][0]+res[k][j][0])
						res[i][j]=new int[]{res[i][k][0]+res[k][j][0], k};
		return res;
	}
	static ArrayList<Integer> function(int desde, int hasta){
		ArrayList<Integer> sol = new ArrayList<Integer>();
		if(res[desde][hasta][1]==hasta){
			sol.add(hasta);
			return sol;
		}
		sol.addAll(function(desde, res[desde][hasta][1]));
		sol.addAll(function(res[desde][hasta][1], hasta));
		return sol;
	}
}
