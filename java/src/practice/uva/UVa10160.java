package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict T.L.E.
 * @problemId 10160
 * @problemName Servicing Stations
 * @judge http://uva.onlinejudge.org/
 * @category Backtracking
 * @level ?
 * @date 05/10/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class UVa10160 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(;;){
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
			if(N==0&&M==0)break;
			ArrayList<Integer> lAdy[] = new ArrayList[N];
			TreeSet<Integer> noVisitados = new TreeSet<Integer>();
			for (int i = 0; i < lAdy.length; i++) {
				lAdy[i] = new ArrayList<Integer>();
				noVisitados.add(i);
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine().trim());
				int desde = parseInt(st.nextToken()) - 1, hasta = parseInt(st.nextToken()) - 1;
				lAdy[desde].add(hasta);
				lAdy[hasta].add(desde);
			}
			mem = new TreeSet<Long>();
			System.out.println(function(lAdy, (long)Math.pow(2, lAdy.length) - 1));
		}
	}
	static TreeSet<Long> mem;
	static int function(ArrayList<Integer> lAdy[], long noVisitados){
		class Paso{
			long noVisitados;
			int cont;
			Paso(long noVisitados, int cont){
				this.noVisitados = noVisitados;
				this.cont = cont;
			}
		}
		LinkedList<Paso> cola = new LinkedList<Paso>();
		cola.add(new Paso(noVisitados, 0));
		mem.add(noVisitados);
		while(true){
			Paso paso = cola.pollFirst();
			//System.out.println(Long.toBinaryString(paso.noVisitados) + " " + paso.cont);
			if(paso.noVisitados == 0)return paso.cont;
			long noVis = paso.noVisitados;
			for(long i = noVis, j = 0; i > 0; i = i>>1, j++){
				if(i%2!=0){
					noVis = noVis^(1<<j);
					for(int m: lAdy[(int)j])
						if((noVis>>m)%2!=0)noVis = noVis^(1<<m);
					if(!mem.contains(noVis)){
						mem.add(noVis);
						cola.add(new Paso(noVis, paso.cont + 1));
					}
				}
				noVis = paso.noVisitados;
			}
		}
		/*if(noVisitados == 0)return 0;
		if(mem.containsKey(noVisitados))return mem.get(noVisitados);
		long noVis = noVisitados;
		for(long i = noVis, j = 0; i > 0; i = i>>1, j++){
			if(i%2!=0){
				noVisitados = noVisitados^(1<<j);
				for(int m: lAdy[(int)j])
					if((noVisitados>>m)%2!=0)noVisitados = noVisitados^(1<<m);
				min = Math.min(min, function(lAdy, noVisitados) + 1);
			}
			noVisitados = noVis;
		}
		mem.put(noVisitados, min);
		return min;*/
	}
}
