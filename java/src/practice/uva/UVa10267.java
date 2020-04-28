package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10267
 * @problemName Graphical Editor
 * @judge http://uva.onlinejudge.org/
 * @category simulation, fill
 * @level easy
 * @date 07/12/2010
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class UVa10267 {
	public static char[][] cambiarTamano(int R, int C){
		char[][] matriz = new char[R][C];
		for (int i = 0; i < R; i++) 
			for (int j = 0; j < C; j++) 
				matriz[i][j] = 'O';
		return matriz;		
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int R = 0, C = 0;
		char[][] matriz = new char[R][C];
		loop: for(;;){
			String ln = in.readLine();
			StringTokenizer st = new StringTokenizer(ln);
			char caso = st.nextToken().charAt(0);
			switch(caso){
				case 'I':{
					C = parseInt(st.nextToken());
					R = parseInt(st.nextToken());
					matriz = cambiarTamano(R, C);
					break;
				}
				case 'C':{ 
					matriz = cambiarTamano(R, C);
					break;
				}
				case 'L':{
					int X = parseInt(st.nextToken()) - 1;
					int Y = parseInt(st.nextToken()) - 1;
					matriz[Y][X] = st.nextToken().charAt(0);
					break;
				}
				case 'V':{
					int X = parseInt(st.nextToken()) - 1;
					int Y1 = parseInt(st.nextToken()) - 1;
					int Y2 = parseInt(st.nextToken()) - 1;
					char color = st.nextToken().charAt(0);
					for (int i = min(Y1, Y2); i <= max(Y2, Y1); i++)
						matriz[i][X] = color;
					break;
				}
				case 'H':{
					int X1 = parseInt(st.nextToken()) - 1;
					int X2 = parseInt(st.nextToken()) - 1;
					int Y = parseInt(st.nextToken()) - 1;
					char color = st.nextToken().charAt(0);
					for (int i = min(X1, X2); i <= max(X2, X1); i++)
						matriz[Y][i] = color;
					break;
				}
				case 'K':{
					int X1 = parseInt(st.nextToken()) - 1;
					int Y1 = parseInt(st.nextToken()) - 1;
					int X2 = parseInt(st.nextToken()) - 1;
					int Y2 = parseInt(st.nextToken()) - 1;
					char color = st.nextToken().charAt(0);
					for (int i = min(Y1, Y2); i <= max(Y2, Y1); i++)
						for (int j = min(X1, X2); j <= max(X2, X1); j++)
						matriz[i][j] = color;
					break;
				}
				case 'F':{
					int X = parseInt(st.nextToken()) - 1;
					int Y = parseInt(st.nextToken()) - 1;
					char color = st.nextToken().charAt(0);
					if(matriz[Y][X] != color){
						TreeSet<int[]> cola = new TreeSet<int[]>(new Comparator<int[]>() {
							public int compare(int[] o1, int[] o2) {
								if(o1[0] > o2[0])return 1;
								if(o1[0] < o2[0])return -1;
								if(o1[1] > o2[1])return 1;
								if(o1[1] < o2[1])return -1;
								return 0;
							}							
						});
						cola.add(new int[]{Y, X});
						char colorAnt = matriz[Y][X];
						while(!cola.isEmpty()){
							int[] t = cola.first();
							cola.remove(t);
							matriz[t[0]][t[1]] = color;
							if(t[0] > 0 && matriz[t[0]-1][t[1]] == colorAnt)cola.add(new int[]{t[0]-1,t[1]});
							if(t[0] < R - 1 && matriz[t[0]+1][t[1]] == colorAnt)cola.add(new int[]{t[0]+1,t[1]});
							if(t[1] > 0 && matriz[t[0]][t[1]-1] == colorAnt)cola.add(new int[]{t[0],t[1]-1});
							if(t[1] < C - 1 && matriz[t[0]][t[1]+1] == colorAnt)cola.add(new int[]{t[0],t[1]+1});
						}
					}
					break;
				}
				case 'S':{
					sb.append(ln.substring(2)+"\n");
					for (int i = 0; i < R; i++) {
						for (int j = 0; j < C; j++) 
							sb.append(matriz[i][j]);
						sb.append("\n");
					}
					System.out.print(new String(sb));
					sb = new StringBuilder();
					break;
				}
				case 'X':
					break loop;
			}
		}
	}
}
