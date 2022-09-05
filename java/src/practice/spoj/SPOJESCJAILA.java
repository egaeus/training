package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId practice.spoj.SPOJESCJAILA
 * @problemName Escape from Jail Again
 * @judge http://www.spoj.pl
 * @category bfs
 * @level easy
 * @date 20/10/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class SPOJESCJAILA {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(;;){
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
			if(N==-1&&M==-1)break;
			char[][] mat = new char[N][];
			for (int i = 0; i < mat.length; i++)mat[i] = in.readLine().trim().toCharArray();
			System.out.println(solucionar(mat));
		}
	}
	static int solucionar(char[][] tab){
		class Tablero implements Comparable<Tablero>{
			boolean estadoPuertas;
			int posX, posY;
			int pasos;
			Tablero(int posX, int posY, boolean estadoPuertas, int pasos){
				this.estadoPuertas = estadoPuertas;
				this.pasos = pasos;
				this.posX = posX;
				this.posY = posY;
			}
			public int compareTo(Tablero o) {
				if(posX < o.posX)return -1;
				if(posX > o.posX)return 1;
				if(posY < o.posY)return -1;
				if(posY > o.posY)return 1;
				if(estadoPuertas != o.estadoPuertas)return estadoPuertas?-1:1;
				return 0;
			}
		}
		LinkedList<Tablero> cola = new LinkedList<Tablero>();
		TreeSet<Tablero> mem = new TreeSet<Tablero>();
		int posX = 0, posY = 0;
		loop: for (; posX < tab.length; posX++) 
				for (posY = 0; posY < tab[posX].length; posY++)
					if(tab[posX][posY]=='H')break loop;
		tab[posX][posY]='.';
		cola.add(new Tablero(posX, posY, false, 0));
		mem.add(new Tablero(posX, posY, false, 0));
		while(!cola.isEmpty()){
			Tablero tablero = cola.pollFirst();
			if(tablero.posX == 0 || tablero.posY == 0 || tablero.posX == tab.length - 1 || tablero.posY == tab[0].length - 1)return tablero.pasos + 1;
			posX = tablero.posX;
			posY = tablero.posY;
			//Arriba
			if(posX > 0 && tab[posX-1][posY] != 'W' && (tablero.estadoPuertas || (!tablero.estadoPuertas && tab[posX-1][posY] != 'D'))){
				Tablero newTablero = new Tablero(posX-1, posY, (tab[posX-1][posY]=='O' || tablero.estadoPuertas) && !(tab[posX-1][posY] == 'C'), tablero.pasos+1);
				if(!mem.contains(newTablero)){
					cola.add(newTablero);
					mem.add(newTablero);
				}
			}
			//Abajo
			if(posX < tab.length - 1 && tab[posX+1][posY] != 'W' && (tablero.estadoPuertas || (!tablero.estadoPuertas && tab[posX+1][posY] != 'D'))){
				Tablero newTablero = new Tablero(posX+1, posY, (tab[posX+1][posY]=='O' || tablero.estadoPuertas) && !(tab[posX+1][posY] == 'C'), tablero.pasos+1);
				if(!mem.contains(newTablero)){
					cola.add(newTablero);
					mem.add(newTablero);
				}
			}
			//Derecha
			if(posY < tab[0].length - 1 && tab[posX][posY+1] != 'W' && (tablero.estadoPuertas || (!tablero.estadoPuertas && tab[posX][posY+1] != 'D'))){
				Tablero newTablero = new Tablero(posX, posY+1, (tab[posX][posY+1]=='O' || tablero.estadoPuertas) && !(tab[posX][posY+1] == 'C'), tablero.pasos+1);
				if(!mem.contains(newTablero)){
					cola.add(newTablero);
					mem.add(newTablero);
				}
			}
			//Izquierda
			if(posY > 0 && tab[posX][posY-1] != 'W' && (tablero.estadoPuertas || (!tablero.estadoPuertas && tab[posX][posY-1] != 'D'))){
				Tablero newTablero = new Tablero(posX, posY-1, (tab[posX][posY-1]=='O' || tablero.estadoPuertas) && !(tab[posX][posY-1] == 'C'), tablero.pasos+1);
				if(!mem.contains(newTablero)){
					cola.add(newTablero);
					mem.add(newTablero);
				}
			}
		}
		return -1;
	}
}
