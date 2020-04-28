package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10126
 * @problemName Zipf's Law
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 03/01/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVa10126 {
	static class Escaner{
		BufferedReader in;
		StringTokenizer st;
		Escaner(){
			in = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}
		String next()throws Throwable{
			if(st.hasMoreTokens())return st.nextToken();
			String ln = in.readLine();
			if(ln == null)return ln;
			st = new StringTokenizer(ln);
			return next();
		}
	}
	public static void main(String[] args) throws Throwable{
		StringBuffer sb = new StringBuffer();
		Escaner sc = new Escaner();
		TreeMap<String, Integer> mapa = new TreeMap<String, Integer>();
		int N = parseInt(sc.next());
		int caso = 0;
		for(String next; (next = sc.next())!=null;){
			if(next.equals("EndOfText")){
				if(caso>0)sb.append("\n");
				boolean ws = false;
				for(Entry<String, Integer> entry: mapa.entrySet())
					if(entry.getValue()==N){
						ws=true;
						sb.append(entry.getKey()+"\n");
					}
				if(!ws)sb.append("There is no such word.\n");
				mapa = new TreeMap<String, Integer>();
				next = sc.next();
				if(next==null)break;
				N = parseInt(next);
				caso++;
			}
			String[] arr = next.toLowerCase().split("[^a-z]+");
			for(String str: arr)if(arr.length > 0)mapa.put(str, mapa.containsKey(str)?mapa.get(str)+1:1);
		}
		System.out.print(new String(sb));
	}
}
