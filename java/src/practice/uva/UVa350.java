package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 350
 * @problemName Pseudo-Random Numbers
 * @judge http://uva.onlinejudge.org/
 * @category Math
 * @level easy
 * @date 2009
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVa350 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int caso = 1;
		for (String ln; (ln = in.readLine().trim()) != null; caso++) {
			StringTokenizer st = new StringTokenizer(ln);
			long Z = parseInt(st.nextToken()), I = parseInt(st.nextToken()), M = parseInt(st.nextToken()), L = parseInt(st.nextToken());
			if(Z==0 && I==0 && M==0 && L==0)break;
			long cont = 0;
			TreeMap<Long, Long> arbol = new TreeMap<Long, Long>();
			long j = L;
			for (; !arbol.containsKey(j); j = (j * Z + I) % M, cont++)arbol.put(j, cont);
			System.out.println("Case " + caso + ": " + (cont - arbol.get(j)));
		}
	}
}
