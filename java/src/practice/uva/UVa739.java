package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 739
 * @problemName Soundex Indexing
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 10/08/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
public class UVa739 {
	public static void main(String[] args) throws Throwable{
		TreeMap<Character, Integer> tabla = new TreeMap<Character, Integer>();
		tabla.put('B', 1);tabla.put('P', 1);tabla.put('F', 1);tabla.put('V', 1);
		tabla.put('C', 2);tabla.put('S', 2);tabla.put('K', 2);tabla.put('G', 2);
		tabla.put('J', 2);tabla.put('Q', 2);tabla.put('X', 2);tabla.put('Z', 2);
		tabla.put('D', 3);tabla.put('T', 3);tabla.put('L', 4);tabla.put('M', 5);
		tabla.put('N', 5);tabla.put('R', 6);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String espIzq = "         ";
		sb.append("         NAME                     SOUNDEX CODE\n");
		for (String ln; (ln = in.readLine()) != null; ) {
			char[] ch = ln.trim().toCharArray();
			ArrayList<Character> res = new ArrayList<Character>(4);
			res.add(ch[0]);
			for (int i = 1; i < ch.length && res.size() < 4; i++) 
				if(tabla.containsKey(ch[i]))
					if(tabla.get(ch[i])!=tabla.get(ch[i-1]))
						res.add((char)(tabla.get(ch[i]) + '0'));
			for (int i = res.size(); i < 4; i++) res.add('0');
			sb.append(espIzq + ln.trim());
			for (int i = ch.length + 10; i < 35; i++)sb.append(" ");
			sb.append(Arrays.toString(res.toArray()).replaceAll("[\\[, \\]]", "") + "\n");			
		}
		sb.append("                   END OF OUTPUT\n");
		System.out.print(new String(sb));
	}
}
