package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10393
 * @problemName The One-Handed Typist
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 22/12/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
public class UVa10393 {
	static class Escaner{
		BufferedReader in;
		StringTokenizer st;
		Escaner(){
			in = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}
		int nextInt() throws Throwable{
			return parseInt(next());
		}
		String next() throws Throwable{
			if(st.hasMoreTokens())return st.nextToken();
			String ln = in.readLine();
			if(ln == null) return null;
			st = new StringTokenizer(ln);
			return next();
		}
	}
	public static void main(String[] args) throws Throwable{
		Escaner sc = new Escaner();
		char[][] arr = new char[][] { "qaz".toCharArray(), "wsx".toCharArray(),
		"edc".toCharArray(), "rfvtgb".toCharArray(), " ".toCharArray(),
		" ".toCharArray(), "yhnujm".toCharArray(), "ik,".toCharArray(),
		"ol.".toCharArray(), "p;/".toCharArray() };
		StringBuilder sb = new StringBuilder();
		for(; ;){
			String nx = sc.next();
			if(nx == null)break;
			int M = parseInt(nx), N = sc.nextInt();
			TreeSet<Character> noUsables = new TreeSet<Character>();
			TreeMap<Integer, TreeSet<String>> res = new TreeMap<Integer, TreeSet<String>>();
			res.put(-1, new TreeSet<String>());
			for(int k = 0; k < M; k++)for(int i = 0, n = sc.nextInt() - 1; i < arr[n].length; i++)noUsables.add(arr[n][i]);
			for (int i = 0; i < N; i++) {
				char[] str = sc.next().toCharArray();
				boolean ws = true;
				for(char a: str)if(noUsables.contains(a)){ws = false; break;}
				if(ws){
					TreeSet<String> temp = res.get(str.length);
					if(temp==null)temp = new TreeSet<String>();
					temp.add(new String(str));
					res.put(str.length, temp);
				}
			}
			sb.append(res.lastEntry().getValue().size() + "\n");
			for(String str: res.lastEntry().getValue())
				sb.append(str + "\n");
		}
		System.out.print(new String(sb));
	}
}
