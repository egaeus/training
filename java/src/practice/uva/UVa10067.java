package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10067
 * @problemName Playing with Wheels
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 20/12/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class UVa10067 {
	static class Tablero implements Comparable<Tablero>{
		int pos[], pasos;
		Tablero(int[] pos, int pasos){
			this.pos = new int[4];
			this.pos[0] = pos[0]==10?0:(pos[0]==-1?9:pos[0]);
			this.pos[1] = pos[1]==10?0:(pos[1]==-1?9:pos[1]);
			this.pos[2] = pos[2]==10?0:(pos[2]==-1?9:pos[2]);
			this.pos[3] = pos[3]==10?0:(pos[3]==-1?9:pos[3]);
			this.pasos = pasos;
		}
		public int compareTo(Tablero o) {
			if(pos[0] < o.pos[0])return -1;
			if(pos[0] > o.pos[0])return 1;
			if(pos[1] < o.pos[1])return -1;
			if(pos[1] > o.pos[1])return 1;
			if(pos[2] < o.pos[2])return -1;
			if(pos[2] > o.pos[2])return 1;
			if(pos[3] < o.pos[3])return -1;
			if(pos[3] > o.pos[3])return 1;
			return 0;
		}		
	}
	static class Escaner{
		BufferedReader in;
		StringTokenizer st;
		Escaner(){
			in = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}
		int nextInt() throws Throwable{
			if(st.hasMoreTokens())return parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			return nextInt();
		}
	}
	public static void main(String[] args) throws Throwable{
		Escaner sc = new Escaner();
		for (int c = 0, C = sc.nextInt(); c < C; c++) {
			TreeSet<Tablero> noVisitar = new TreeSet<Tablero>();
			TreeSet<Tablero> visitados = new TreeSet<Tablero>();
			LinkedList<Tablero> cola = new LinkedList<Tablero>();
			Tablero tabInicial = new Tablero(new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()}, 0);
			Tablero tabFinal = new Tablero(new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()}, 0);
			for(int i = 0, N = sc.nextInt(); i < N; i++)
				noVisitar.add(new Tablero(new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()}, 0));
			cola.add(tabInicial);
			visitados.add(tabInicial);
			while(!cola.isEmpty()){
				if(tabFinal.compareTo(cola.getFirst()) == 0)break;
				Tablero tab = cola.removeFirst();
				for (int i = 0; i < 4; i++) 
					for (int j = -1; j < 2; j+=2) {
						int[] temp = tab.pos.clone();
						temp[i]+=j;
						Tablero t = new Tablero(temp, tab.pasos + 1);
						if(!noVisitar.contains(t) && !visitados.contains(t)){
							cola.add(t);
							visitados.add(t);
						}
					}
			}
			if(cola.isEmpty())System.out.println(-1);
			else System.out.println(cola.getFirst().pasos);
		}
	}
}
