package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10196
 * @problemName Check The Check 
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 07/12/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10196 {
	public static boolean[] getGanador(char[][] tablero, int i, int j){
		boolean ganaNegro = false, ganaBlanco = false;
		if(Character.toUpperCase(tablero[i][j]) == 'P')
			if(Character.isLowerCase(tablero[i][j]))
				ganaNegro = i < tablero.length - 1 && ((j > 0 && tablero[i+1][j-1] == 'K') || (j < tablero[i].length - 1 && tablero[i+1][j+1] == 'K'));
			else
				ganaBlanco = i > 0 && ((j > 0 && tablero[i-1][j-1] == 'k') || (j < tablero[i].length - 1 && tablero[i-1][j+1] == 'k'));
		else if(Character.toUpperCase(tablero[i][j]) == 'R'){
			for (int k = i + 1; k < tablero.length && !ganaBlanco && !ganaNegro; k++) {
				ganaNegro = tablero[i][j] == 'r' && tablero[k][j] == 'K';
				ganaBlanco = tablero[i][j] == 'R' && tablero[k][j] == 'k';
				if(tablero[k][j] != '.')break;
			}
			for (int k = i - 1; k >= 0 && !ganaBlanco && !ganaNegro; k--) {
				ganaNegro = tablero[i][j] == 'r' && tablero[k][j] == 'K';
				ganaBlanco = tablero[i][j] == 'R' && tablero[k][j] == 'k';
				if(tablero[k][j] != '.')break;
			}
			for (int k = j + 1; k < tablero[i].length && !ganaBlanco && !ganaNegro; k++) {
				ganaNegro = tablero[i][j] == 'r' && tablero[i][k] == 'K';
				ganaBlanco = tablero[i][j] == 'R' && tablero[i][k] == 'k';
				if(tablero[i][k] != '.')break;
			}
			for (int k = j - 1; k >= 0 && !ganaBlanco && !ganaNegro; k--) {
				ganaNegro = tablero[i][j] == 'r' && tablero[i][k] == 'K';
				ganaBlanco = tablero[i][j] == 'R' && tablero[i][k] == 'k';
				if(tablero[i][k] != '.')break;
			}
		}
		else if(Character.toUpperCase(tablero[i][j]) == 'B'){
			for (int h = i + 1, k = j + 1; k < tablero.length && h < tablero.length && !ganaBlanco && !ganaNegro; k++, h++) {
				ganaNegro = tablero[i][j] == 'b' && tablero[h][k] == 'K';
				ganaBlanco = tablero[i][j] == 'B' && tablero[h][k] == 'k';
				if(tablero[h][k] != '.')break;
			}
			for (int h = i + 1, k = j - 1; h < tablero.length && k >= 0 && !ganaBlanco && !ganaNegro; h++, k--) {
				ganaNegro = tablero[i][j] == 'b' && tablero[h][k] == 'K';
				ganaBlanco = tablero[i][j] == 'B' && tablero[h][k] == 'k';
				if(tablero[h][k] != '.')break;
			}
			for (int h = i - 1, k = j - 1; k >= 0 && h >= 0 && !ganaBlanco && !ganaNegro; k--, h--) {
				ganaNegro = tablero[i][j] == 'b' && tablero[h][k] == 'K';
				ganaBlanco = tablero[i][j] == 'B' && tablero[h][k] == 'k';
				if(tablero[h][k] != '.')break;
			}
			for (int h = i - 1, k = j + 1; h >= 0 && k < tablero.length && !ganaBlanco && !ganaNegro; h--, k++) {
				ganaNegro = tablero[i][j] == 'b' && tablero[h][k] == 'K';
				ganaBlanco = tablero[i][j] == 'B' && tablero[h][k] == 'k';
				if(tablero[h][k] != '.')break;
			}
		}
		else if(Character.toUpperCase(tablero[i][j]) == 'Q'){
			if(Character.isUpperCase(tablero[i][j]))tablero[i][j] = 'R';
			else tablero[i][j] = 'r';
			boolean ganador[] = getGanador(tablero, i, j);
			ganaBlanco = ganador[0]; ganaNegro = ganador[1];
			if(!ganaBlanco && !ganaNegro){
				if(Character.isUpperCase(tablero[i][j]))tablero[i][j] = 'B';
				else tablero[i][j] = 'b';
				ganador = getGanador(tablero, i, j);
				ganaBlanco = ganador[0]; ganaNegro = ganador[1];
			}
			if(Character.isUpperCase(tablero[i][j]))tablero[i][j] = 'Q';
			else tablero[i][j] = 'q';
		}
		else if(Character.toUpperCase(tablero[i][j]) == 'K'){
			for (int k = -1; k < 2 && !ganaBlanco && !ganaNegro; k++) 
				for (int h = -1; h < 2 && !ganaBlanco && !ganaNegro; h++) 
					if(i+k >= 0 && i+k < tablero.length && j+h >= 0 && j+h < tablero[i].length && tablero[i][j] == 'K')
						ganaBlanco = tablero[i+k][j+h] == 'k';
					else if(i+k >= 0 && i+k < tablero.length && j+h >= 0 && j+h < tablero[i].length && tablero[i][j] == 'k')
						ganaNegro = tablero[i+k][j+h] == 'K';
		}
		else if(Character.toUpperCase(tablero[i][j]) == 'N'){
			int[] arr = {-1, 1, -2, 2};
			for (int k = 0; k < arr.length && !ganaBlanco && !ganaNegro; k++) 
				for (int h = 0; h < arr.length && !ganaBlanco && !ganaNegro; h++)
					if(Math.abs(arr[k]) != Math.abs(arr[h])){
						if(i+arr[k] >= 0 && i+arr[k] < tablero.length && j+arr[h] >= 0 && j+arr[h] < tablero[i].length && tablero[i][j] == 'N')
							ganaBlanco = tablero[i+arr[k]][j+arr[h]] == 'k';
						else if(i+arr[k] >= 0 && i+arr[k] < tablero.length && j+arr[h] >= 0 && j+arr[h] < tablero[i].length && tablero[i][j] == 'n')
							ganaNegro = tablero[i+arr[k]][j+arr[h]] == 'K';
					}
		}
		return new boolean[]{ganaBlanco, ganaNegro};
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int C = 1; ; C++) {
			char[][] tablero = new char[8][];
			for (int i = 0; i < tablero.length; i++) 
				tablero[i] = in.readLine().trim().toCharArray();
			boolean ws = true;
			for (int i = 0; i < tablero.length && ws; i++) 
				for (int j = 0; j < tablero[i].length && ws; j++) 
					ws = tablero[i][j] == '.';
			if(ws)break;
			in.readLine();
			boolean ganaBlanco = false;
			boolean ganaNegro = false;
			for (int i = 0; i < tablero.length && !ganaBlanco && !ganaNegro; i++) 
				for (int j = 0; j < tablero[i].length && !ganaBlanco && !ganaNegro; j++){
					boolean[] ganador = getGanador(tablero, i, j);
					ganaBlanco = ganador[0];
					ganaNegro = ganador[1];
				}
			System.out.println("Game #" + C + ": " + (ganaNegro?"white":(ganaBlanco?"black":"no")) + " king is in check.");
		}
	}
}
