package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10295
 * @problemName Hay Points
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 03/01/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVa10295 {
	static class Escaner{
		BufferedReader in;
		StringTokenizer st;
		Escaner(){
			in = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}
		String next()throws Throwable{
			if(st.hasMoreTokens())return st.nextToken();
			st = new StringTokenizer(in.readLine());
			return next();
		}
	}
	public static void main(String[] args) throws Throwable{
		Escaner sc = new Escaner();
		int N = parseInt(sc.next()), n = parseInt(sc.next());
		TreeMap<String, Integer> mapa = new TreeMap<String, Integer>();
		for (int i = 0; i < N; i++) 
			mapa.put(sc.next(), parseInt(sc.next()));
		for(int i = 0; i < n; i++){
			long res = 0;
			for(String next; (next = sc.next()).replaceAll("[a-z]", "").length() == 0;)
				res += mapa.containsKey(next)?mapa.get(next):0;
				System.out.println(res);
		}
	}
}
