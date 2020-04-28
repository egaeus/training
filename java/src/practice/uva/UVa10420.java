package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10420
 * @problemName List of Conquests
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 14/02/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
public class UVa10420 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, TreeSet<String>> mapa = new TreeMap<String, TreeSet<String>>();
		for(int c = 0, C = parseInt(in.readLine().trim()); c < C; c++){
			String ln = in.readLine();
			String pais = ln.substring(0, ln.indexOf(" "));
			TreeSet<String> set = mapa.get(pais);
			if(set==null){set = new TreeSet<String>();mapa.put(pais, set);}
			set.add(ln.substring(ln.indexOf(" ")));
		}
		for(Entry<String, TreeSet<String>> entry: mapa.entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue().size());
	}
}
