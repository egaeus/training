package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict T.L.E.
 * @problemId ANARC09G
 * @problemName Stock Chase
 * @judge http://www.spoj.pl
 * @category graph
 * @level ???
 * @date 24/03/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class SPOJANARC09G {
	static TreeSet<Integer>[] lAdy;
	static TreeSet<Integer>[] padres;
	static boolean visitados[]/* = new boolean[N=lAdy.length]*/;
	static boolean sePuedeAgregar(int desde, int hasta){
		visitados[desde]=true;
		if(desde==hasta)return false;
		for(int n: lAdy[desde]){
			if(!visitados[n]){
				if(!sePuedeAgregar(n, hasta))
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long t = System.currentTimeMillis();
		int caso = 1;
		for(String ln; (ln = in.readLine())!=null; caso++){
			//if(caso==2)break;
			StringTokenizer st = new StringTokenizer(ln);
			int N = parseInt(st.nextToken()), T = parseInt(st.nextToken());
			if(N==0&&T==0)break;
			lAdy = new TreeSet[N];
			padres = new TreeSet[N];
			int res = 0;
			for(int i = 0; i < N; i++){lAdy[i] = new TreeSet<Integer>();padres[i] = new TreeSet<Integer>();}
			for(int i = 0; i < T; i++){
				st = new StringTokenizer(in.readLine());
				int desde = parseInt(st.nextToken()) - 1, hasta = parseInt(st.nextToken()) - 1;
				visitados = new boolean[N];
				if(!sePuedeAgregar(hasta, hasta))res++;
				else lAdy[desde].add(hasta);
			}
			System.out.println(caso+". "+res);
		}
		System.out.println(System.currentTimeMillis()-t);
	}
}
