package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 895
 * @problemName Word Problem
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 21/12/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;
public class UVa895 {
	static TreeMap<Character, Integer> getMap(char[] str){
		TreeMap<Character, Integer> res = new TreeMap<Character, Integer>();
		for(char a: str)
			res.put(a, res.containsKey(a)?res.get(a)+1:1);
		return res;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<TreeMap<Character, Integer>> palabras = new ArrayList<TreeMap<Character,Integer>>();
		for(String ln; !(ln = in.readLine().trim()).equals("#");)
			palabras.add(getMap(ln.toCharArray()));
		for(String ln; !(ln = in.readLine().trim()).equals("#");){
			TreeMap<Character, Integer> mapa = getMap(ln.toCharArray());
			int cont = 0;
			for(TreeMap<Character, Integer> palabra: palabras){
				boolean ws = true;
				for(Entry<Character, Integer> entry: palabra.entrySet()){
					ws = mapa.containsKey(entry.getKey()) && entry.getValue() <= mapa.get(entry.getKey());
					if(!ws)break;
				}
				if(ws)cont++;
			}
			System.out.println(cont);
		}
	}
}
