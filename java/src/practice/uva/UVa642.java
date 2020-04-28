package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 642
 * @problemName Word Amalgamation
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 21/12/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
public class UVa642 {
	static TreeMap<Character, Integer> getMap(char[] str){
		TreeMap<Character, Integer> res = new TreeMap<Character, Integer>();
		for(char a: str)
			res.put(a, res.containsKey(a)?res.get(a)+1:1);
		return res;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TreeMap<String, TreeMap<Character, Integer>> palabras = new TreeMap<String, TreeMap<Character,Integer>>();
		for(String ln; !(ln = in.readLine().trim()).equals("XXXXXX");)
			palabras.put(ln, getMap(ln.toCharArray()));
		for(String ln; !(ln = in.readLine().trim()).equals("XXXXXX");){
			TreeMap<Character, Integer> mapa = getMap(ln.toCharArray());
			TreeSet<String> soluciones = new TreeSet<String>();
			for(Entry<String, TreeMap<Character, Integer>> palabra: palabras.entrySet()){
				boolean ws = palabra.getValue().size() == mapa.size();
				for(Entry<Character, Integer> entry: palabra.getValue().entrySet()){
					if(!ws)break;
					ws = mapa.containsKey(entry.getKey()) && entry.getValue() == mapa.get(entry.getKey());
				}
				if(ws)soluciones.add(palabra.getKey());
			}
			if(soluciones.isEmpty())sb.append("NOT A VALID WORD\n");
			else for(String str: soluciones)sb.append(str + "\n");
			sb.append("******\n");
		}
		System.out.print(new String(sb));
	}
}
