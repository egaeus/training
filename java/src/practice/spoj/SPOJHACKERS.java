package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict W.A., T.L.E.
 * @problemId HACKERS
 * @problemName Hackers
 * @judge http://www.spoj.pl
 * @category graph
 * @level ?
 * @date 20/10/2010
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class SPOJHACKERS {
	static int[][] res;
	static ArrayList<Point> lAdy[];
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for(;;){
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int C = parseInt(st.nextToken()), L = parseInt(st.nextToken()), H = parseInt(st.nextToken());
			if(C == -1 && L == -1 && H == -1)break;
			lAdy = new ArrayList[C];
			for (int i = 0; i < lAdy.length; i++) lAdy[i] = new ArrayList<Point>();
			res = new int[C][C];
			for (int i = 0; i < res.length; i++)
				for (int j = 0; j < res.length; j++)
					if(i!=j)res[i][j] = MAX_VALUE;
			for(int i = 0; i < L; i++){
				st = new StringTokenizer(in.readLine().trim());
				int desde = parseInt(st.nextToken()) - 1, hasta = parseInt(st.nextToken()) - 1, V = parseInt(st.nextToken());
				lAdy[desde].add(new Point(hasta, V));
				lAdy[hasta].add(new Point(desde, V));
			}
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine().trim());
				int desde = parseInt(st.nextToken()) - 1, hasta = parseInt(st.nextToken()) - 1;
				//sb.append("[" + (desde + 1) + "," + (hasta + 1)+ "]:" + function(desde, hasta, new boolean[C]) + (i < H-1?" ":""));
				if(res[desde][hasta] == MAX_VALUE)dijkstraPriorityQueue(desde);
				sb.append(res[desde][hasta] + (i < H-1?" ":""));
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
	static int function(int desde, int hasta, boolean[] visitados){
		/*
		 * Caso W.A.:
		 * 4 4 4
		 * 1 2 1
		 * 2 3 3
		 * 3 4 2
		 * 1 4 2
		 * 1 2
		 * 1 3
		 * 1 4
		 * 2 3
		 * -1 -1 -1
		 */
		if(desde==hasta)return 0;
		if(res[desde][hasta] != 0)return res[desde][hasta];
		visitados[desde] = true;
		int min = MAX_VALUE;
		for(Point p: lAdy[desde])
			if(!visitados[p.x]){
				visitados[p.x] = true;
				min = min(min, max(p.y, function(p.x, hasta, visitados)));
				visitados[p.x] = false;
			}
		visitados[desde] = false;
		return res[hasta][desde] = res[desde][hasta] = min;
	}		
	static void dijkstraPriorityQueue(int v) {/*T.L.E.*/
		class Nodo implements Comparable<Nodo> {
			int i; int d; Nodo(int pi, int pd) {i=pi; d=pd;}
			public int compareTo(Nodo e) {return d!=e.d?(d<e.d?-1:1):i-e.i;}
		};
		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>(lAdy.length);
		int n= lAdy.length, f; boolean[] vis = new boolean[n];
		pq.add(new Nodo(v,0));
		while (!pq.isEmpty()) if (!vis[f=pq.poll().i]) {
			vis[f]=true;
			for (Point g: lAdy[f]) 
				if (!vis[g.x] && max(g.y, res[v][f])<res[v][g.x])
					pq.add(new Nodo(g.x, res[v][g.x]=max(g.y, res[v][f])));
		}
	}	
	static void function(int v){/*T.L.E.*/
		TreeSet<Integer> visitados = new TreeSet<Integer>();
		LinkedList<Integer> cola = new LinkedList<Integer>();
		cola.add(v);
		visitados.add(v);
		while(!cola.isEmpty()){
			int nodo = cola.poll();
			for(Point i: lAdy[nodo]){
				if(!visitados.contains(i.x) || max(i.y, res[v][nodo]) < res[v][i.x]){
					cola.add(i.x);
					int min = res[v][nodo];
					if(i.y > res[v][nodo])
						min = i.y;
					if(res[v][i.x] > min)
						res[v][i.x] = res[i.x][v] = min;
					visitados.add(i.x);
				}
			}
		}
	}
}
