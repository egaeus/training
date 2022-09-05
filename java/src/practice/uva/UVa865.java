package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 865
 * @problemName Substitution Cypher
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 23/12/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;
public class UVa865 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int c = 0, C = parseInt(in.readLine().trim()); c < C; c++){
			if(c == 0)in.readLine();
			TreeMap<Character, Character> cypher = new TreeMap<Character, Character>();
			char[] plainText = in.readLine().toCharArray();
			char[] substitution = in.readLine().toCharArray();
			for(int i = 0; i < plainText.length; i++)cypher.put(plainText[i], substitution[i]);
			sb.append(new String(substitution) + "\n");
			sb.append(new String(plainText) + "\n");
			for(String ln; (ln = in.readLine()) != null && !ln.equals("");){
				char[] str = ln.toCharArray();
				for(char ch:str)
					if(cypher.containsKey(ch))sb.append(cypher.get(ch));
					else sb.append(ch);
				sb.append("\n");
			}
			if(c<C-1)sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
