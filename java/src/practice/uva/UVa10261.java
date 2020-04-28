package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10261
 * @problemName Ferry Loading
 * @judge http://uva.onlinejudge.org/
 * @category DP
 * @level easy
 * @date 05/10/2010
 **/
import static java.lang.Integer.parseInt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVa10261 {
	static ArrayList<Integer> carros, sumas;
	static Point[][] mem;
	static int tam;
	static int function(int pos, int tamDer){
		if(pos == carros.size())return 0;
		int tamIzq = tam;
		if(pos > 0)
			tamIzq =  2 * tam - sumas.get(pos - 1) - tamDer;
		if(mem[pos][tamDer] != null)return mem[pos][tamDer].x; 
		int max = 0;
		if(carros.get(pos) <= tamDer){
			max = function(pos + 1, tamDer - carros.get(pos)) + 1;
			mem[pos][tamDer] = new Point(max, -1);
		}
		if(carros.get(pos) <= tamIzq){
			int val = function(pos + 1, tamDer) + 1;
			if(max < val){
				max = val;
				mem[pos][tamDer] = new Point(max, 1);
			}
		}
		return max;
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0, N = parseInt(in.readLine().trim()); i < N; i++) {
			in.readLine();
			tam = parseInt(in.readLine().trim()) * 100;
			carros = new ArrayList<Integer>();
			sumas = new ArrayList<Integer>();
			for (int j; (j = parseInt(in.readLine().trim())) != 0 ; ) {carros.add(j);sumas.add(j + (sumas.size() > 0? sumas.get(sumas.size()-1):0));}
			mem = new Point[carros.size()][tam+1];
			System.out.println(function(0, tam));
			for(int pos = 0, tamDer = tam; pos < function(0, tam); pos++){
				System.out.println(mem[pos][tamDer].y == -1?"port":"starboard");
				if(mem[pos][tamDer].y == -1)tamDer -= carros.get(pos);
			}
			if(i < N-1)System.out.println();
		}
	}
}
