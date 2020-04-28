package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 473
 * @problemName Raucous Rockers
 * @judge http://uva.onlinejudge.org/
 * @category dynamyc programming
 * @level easy
 * @date 2008
 **/
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa473 {
	static int N, T, M;
	static int[] times;
	static int mem[][];
	static int function(int cancion, int tiempo){
		if (cancion==N)return 0;
		if(tiempo >= T*M)return 0;
		if(mem[cancion][tiempo]>0)return mem[cancion][tiempo];
		int valor = tiempo + times[cancion];
		if(valor/T > tiempo/T && valor%T!=0)valor += T - (tiempo%T);
		return mem[cancion][tiempo] = Math.max(valor <= T*M?function(cancion+1, valor)+1:MIN_VALUE, function(cancion+1,tiempo));
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0, C = parseInt(in.readLine().trim()); i < C; i++) {
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			N = parseInt(st.nextToken()); T = parseInt(st.nextToken()); M = parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine().trim().replaceAll(",", " "));
			times = new int[N];
			for (int j = 0; j < N; j++) times[j] = parseInt(st.nextToken());
			mem = new int[N][T*M];
			System.out.println(function(0,0));
			if(i < C - 1)System.out.println();
		}
	}
}
