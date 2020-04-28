package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict T.L.E.
 * @problemId 10181
 * @problemName 15-Puzzle
 * @judge http://uva.onlinejudge.org/
 * @category Backtracking
 * @level ?
 * @date 05/10/2010
 **/
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;
public class UVa10181 {
	static class Tablero implements Comparable<Tablero>{
		long tab;
		int cont;
		int pos0;
		long ant;
		char mov;
		int[] getTablero(){
			int[] res = new int[16];
			long tablero = tab;
			for(int i = 0; i < res.length; i++){
				res[i] = (int)(tablero & 15);
				tablero = tablero >>> 4;
			}
			return res;
		}
		Tablero(int[] tab, int cont, int pos0, long ant, char mov){
			for (int i = tab.length - 1; i >= 0; i--){
				this.tab = (this.tab << 4) | tab[i];
			}
			this.cont = cont;
			this.pos0 = pos0;
			this.mov = mov;
			this.ant = ant;
		}
		public int compareTo(Tablero o) {
			Comparator<int[]> comparador = new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					for (int i = 0; i < o2.length; i++) 
						if(o1[i]==0 && o2[i]!=0)return 1;
						else if(o2[i]==0 && o1[i]!=0)return -1;
						else if(o1[i] < o2[i])return -1;
						else if(o2[i] < o1[i])return 1;
					return 0;
				}
			};
			int cont0 = 0, cont1 = 0;
			int[] o1 = getTablero();
			int[] o2 = o.getTablero();
			for (int i = 0; i < o1.length; i++)  
				cont0 += Math.abs((o1[i] - 1)/4 - i/4) + Math.abs((o1[i] - 1)%4 - i%4);
			for (int i = 0; i < o2.length; i++)  
				cont0 += Math.abs((o2[i] - 1)/4 - i/4) + Math.abs((o2[i] - 1)%4 - i%4);
			return new Integer(cont0).compareTo(new Integer(cont1))==0?comparador.compare(o1, o2):new Integer(cont0).compareTo(new Integer(cont1));
		}
	}
	static TreeMap<Long, Tablero> mapa = new TreeMap<Long, Tablero>();
	static String solucionar(int[] tabInicial){
		if(!esSolucionable(tabInicial))return "This puzzle is not solvable.";
		TreeSet<Tablero> colaPrioridad = new TreeSet<Tablero>();
		int pos0 = 0;
		for (; pos0 < tabInicial.length; pos0++) if(tabInicial[pos0]==0)break;;
		colaPrioridad.add(new Tablero(tabInicial, 0, pos0, -1L , '\0'));
		Tablero map = mapa.get(colaPrioridad.first().tab);
		int contInicial = 0;
		if(map == null)
			mapa.put(colaPrioridad.first().tab, colaPrioridad.first());
		else{
			contInicial = map.cont;
		}
		long solucion = new Tablero(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0}, 0, 0, -1L, '\0').tab;
		while(!colaPrioridad.isEmpty()){
			System.out.println(colaPrioridad.size() + " " + colaPrioridad.first().cont);
			Tablero tablero = colaPrioridad.pollFirst();
			int[] tab = tablero.getTablero();
			pos0 = tablero.pos0;
			if(tablero.cont <= 50){
				//Arriba
				if(pos0 > 3){
					tab[pos0] = tab[pos0-4];
					tab[pos0-4] = 0;
					Tablero nuevo = new Tablero(tab, tablero.cont + 1, pos0-4, tablero.tab, 'U');
					Tablero tableroMapa = mapa.get(nuevo.tab);
					if(tableroMapa == null || nuevo.cont < tableroMapa.cont){
						mapa.put(nuevo.tab, nuevo);
						colaPrioridad.add(nuevo);
					}
					tab[pos0-4] = tab[pos0];
					tab[pos0] = 0;
				}
				//Abajo
				if(pos0 < 12){
					tab[pos0] = tab[pos0+4];
					tab[pos0+4] = 0;
					Tablero nuevo = new Tablero(tab, tablero.cont + 1, pos0+4, tablero.tab, 'D');
					Tablero tableroMapa = mapa.get(nuevo.tab);
					if(tableroMapa == null || nuevo.cont < tableroMapa.cont){
						mapa.put(nuevo.tab, nuevo);
						colaPrioridad.add(nuevo);
					}
					tab[pos0+4] = tab[pos0];
					tab[pos0] = 0;
				}
				//Derecha
				if(pos0%4 < 3){
					tab[pos0] = tab[pos0+1];
					tab[pos0+1] = 0;
					Tablero nuevo = new Tablero(tab, tablero.cont + 1, pos0+1, tablero.tab, 'R');
					Tablero tableroMapa = mapa.get(nuevo.tab);
					if(tableroMapa == null || nuevo.cont < tableroMapa.cont){
						mapa.put(nuevo.tab, nuevo);
						colaPrioridad.add(nuevo);
					}
					tab[pos0+1] = tab[pos0];
					tab[pos0] = 0;
				}
				//Izquierda
				if(pos0%4 > 0){
					tab[pos0] = tab[pos0-1];
					tab[pos0-1] = 0;
					Tablero nuevo = new Tablero(tab, tablero.cont + 1, pos0-1, tablero.tab, 'L');
					Tablero tableroMapa = mapa.get(nuevo.tab);
					if(tableroMapa == null || nuevo.cont < tableroMapa.cont){
						mapa.put(nuevo.tab, nuevo);
						colaPrioridad.add(nuevo);
					}
					tab[pos0-1] = tab[pos0];
					tab[pos0] = 0;
				}
			}
		}
		if(colaPrioridad.isEmpty())return "This puzzle is not solvable.";
		Tablero tablero = colaPrioridad.first();
		String sol = "";
		char mov = tablero.mov;
		while(mov != '\0'){
			sol = mov + sol;
			tablero = mapa.get(tablero.ant);
			mov = tablero.mov;
		}
		return sol;
	}
	public static boolean esSolucionable(int[] estado){
		int sum = 0;
		int[] posiciones = new int[16];
		for (int i = 0; i < estado.length; i++)
			if (estado[i] != 0) posiciones[(estado[i]) - 1] = i + 1;
			else  posiciones[15] = i + 1;
		for (int i = 0; i < estado.length; i++) {
			if (estado[i] == 0) 
				if (((i/4) + 1) % 2 != 0) {if (((i % 4) + 1) % 2 == 0) sum++;}
				else if (((i % 4) + 1) % 2 != 0)sum++;
			for (int j = 0; j < i; j++)
				if (posiciones[j] > posiciones[i]) sum++;
		}
		return sum % 2 == 0;
	}
	public static void main(String[] args) throws Throwable{
		long t = System.currentTimeMillis();
		solucionar(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0});
		System.out.println(System.currentTimeMillis() - t);
		/*BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int c = 0, C = parseInt(in.readLine().trim()); c < C; c++) {
			int[] inicial = new int[16];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine().trim());
				inicial[i*4] = parseInt(st.nextToken());
				inicial[i*4+1] = parseInt(st.nextToken());
				inicial[i*4+2] = parseInt(st.nextToken());
				inicial[i*4+3] = parseInt(st.nextToken());
			}
			System.out.println(solucionar(inicial));
		}*/
	}
}
