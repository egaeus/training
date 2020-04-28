package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 499
 * @problemName What's The Frequency, Kenneth? 
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;
public class UVa499 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = in.readLine();
			TreeMap<Character, Integer> arbol = new TreeMap<Character, Integer>();
			int may = 0;
			if (s == null)
				break;
			for (int i = 0; i < s.length(); i++) {
				if (Character.isLetter(s.charAt(i))
						&& arbol.containsKey(s.charAt(i))) {
					int val = arbol.get(s.charAt(i));
					arbol.put(s.charAt(i), val + 1);
					if (val + 1 > may)
						may = val + 1;
				} else if (Character.isLetter(s.charAt(i))) {
					arbol.put(s.charAt(i), 1);
					if (1 > may)
						may = 1;
				}
			}
			String res = "";
			for (Entry entry : arbol.entrySet())
				if (((Integer) entry.getValue()).equals(may))
					res += entry.getKey();
			System.out.println(res + " " + may);
		}
	}
}
