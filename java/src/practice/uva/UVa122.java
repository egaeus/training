package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 122
 * @problemName Trees on the level
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc, bfs
 * @level easy
 * @date 28/10/2010
 **/
import static java.lang.Integer.parseInt;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class UVa122 {
	static class Nodo implements Comparable<Nodo>{
		char[] ubicacion;
		int N;
		Nodo(String dato){
			StringTokenizer st = new StringTokenizer(dato.replaceAll("[\\(\\)]", ""), ",");
			N = parseInt(st.nextToken());
			if(st.hasMoreTokens())ubicacion = st.nextToken().toCharArray();
			else ubicacion = new char[0];
		}
		Nodo(String ubicacion, int N){
			this.N = N;
			this.ubicacion = ubicacion.toCharArray();
		}
		public int compareTo(Nodo o) {
			if(ubicacion.length < o.ubicacion.length)return -1;
			if(ubicacion.length > o.ubicacion.length)return 1;
			return new String(ubicacion).compareTo(new String(o.ubicacion));
		}			
	}
	static class Arbol{
		int nodo;
		Arbol arbIzq, arbDer;
		Arbol(int nodo, Arbol arbIzq, Arbol arbDer){
			this.nodo = nodo;
			this.arbIzq = arbIzq;
			this.arbDer = arbDer;
		}
	}
	static boolean agregarNodo(Arbol arb, int cabecera, char[] ubicacion, int pos){
		if(pos == ubicacion.length - 1){
			if(ubicacion[pos]=='L')arb.arbIzq = new Arbol(cabecera, null, null);
			if(ubicacion[pos]=='R')arb.arbDer = new Arbol(cabecera, null, null);
			return true;
		}
		if(ubicacion[pos]=='L' && arb.arbIzq == null)return false;
		if(ubicacion[pos]=='L' && arb.arbIzq != null)return agregarNodo(arb.arbIzq, cabecera, ubicacion, pos+1);
		if(ubicacion[pos]=='R' && arb.arbDer == null)return false;
		if(ubicacion[pos]=='R' && arb.arbDer != null)return agregarNodo(arb.arbDer, cabecera, ubicacion, pos+1);
		return true;
	}
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		TreeSet<Nodo> arbol = new TreeSet<Nodo>();
		boolean ws = true;
		while(sc.hasNext()){
			String parte = sc.next();
			if(parte.equals("()")){
				ws = ws && arbol.first().ubicacion.length == 0;
				Arbol arb = null;
				if(ws)arb = new Arbol(arbol.first().N, null, null);
				arbol.remove(arbol.first());
				for (Nodo n: arbol) {
					if(!ws)break;
					ws = agregarNodo(arb, n.N, n.ubicacion, 0);
				}
				if(ws){
					LinkedList<Arbol> cola = new LinkedList<Arbol>();
					cola.add(arb);
					while(!cola.isEmpty()){
						Arbol poll = cola.pollFirst();
						if(poll.arbIzq != null)cola.add(poll.arbIzq);
						if(poll.arbDer != null)cola.add(poll.arbDer);
						sb.append(poll.nodo + (cola.isEmpty()?"":" "));
					}
					sb.append("\n");
				}
				else sb.append("not complete\n");
				arbol = new TreeSet<Nodo>();
				ws = true;
			}
			else {
				Nodo nodo = new Nodo(parte); 
				if(arbol.contains(nodo))ws = false;
				arbol.add(nodo);
			}
		}
		System.out.print(new String(sb));
	}
}
