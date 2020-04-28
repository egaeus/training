package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10010
 * @problemName Where's Waldorf?
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 14/12/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa10010 {
	static public boolean function(char[][] arr, char[] str, int posI, int posJ, int posStr){
		if(posI < 0 || posI >= arr.length || posJ < 0 || posJ >= arr[0].length)return false;
		if(posStr == 0){
			if(arr[posI][posJ]==str[posStr]){
				boolean ws = true;
				//Izquierda
				for (int i = 1; i < str.length && ws; i++) 
					ws = function(arr, str, posI-i, posJ, i);
				if(ws)return ws;
				ws = true;
				//Derecha
				for (int i = 1; i < str.length && ws; i++) 
					ws = function(arr, str, posI+i, posJ, i);
				if(ws)return ws;
				ws = true;
				//Abajo
				for (int i = 1; i < str.length && ws; i++) 
					ws = function(arr, str, posI, posJ+i, i);
				if(ws)return ws;
				ws = true;
				//Arriba
				for (int i = 1; i < str.length && ws; i++) 
					ws = function(arr, str, posI, posJ-i, i);
				if(ws)return ws;
				ws = true;
				//Arriba-Izquierda
				for (int i = 1; i < str.length && ws; i++) 
					ws = function(arr, str, posI-i, posJ-i, i);
				if(ws)return ws;
				ws = true;
				//Arriba-Derecha
				for (int i = 1; i < str.length && ws; i++) 
					ws = function(arr, str, posI-i, posJ+i, i);
				if(ws)return ws;
				ws = true;
				//Abajo-Izquierda
				for (int i = 1; i < str.length && ws; i++) 
					ws = function(arr, str, posI+i, posJ-i, i);
				if(ws)return ws;
				ws = true;
				//Abajo-Derecha
				for (int i = 1; i < str.length && ws; i++) 
					ws = function(arr, str, posI+i, posJ+i, i);
				if(ws)return ws;
			}
			return false;
		}
		return arr[posI][posJ] == str[posStr];
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int c = 0, C = parseInt(in.readLine().trim()); c < C; c++) {
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
			char[][] arr = new char[N][];
			for (int i = 0; i < N; i++) 
				arr[i] = in.readLine().toLowerCase().toCharArray();
			for (int h = 0, H = parseInt(in.readLine().trim()); h < H; h++) {
				char[] str = in.readLine().toLowerCase().toCharArray();
				loop: for (int i = 0; i < N; i++) 
					for (int j = 0; j < M; j++) 
						if(function(arr, str, i, j, 0)){
							System.out.println((i+1) + " " + (j+1));
							break loop;
						}
			}
			if(c < C-1)System.out.println();
		}
	}
}
