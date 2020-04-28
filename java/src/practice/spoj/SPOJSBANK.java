package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict T.L.E.
 * @problemId practice.spoj.SPOJSBANK
 * @problemName Sorting Bank Accounts
 * @judge http://www.spoj.pl
 * @category sorting
 * @level easy
 * @date 24/02/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class SPOJSBANK {
	public static void main(String[] args) throws Throwable{
		Comparator<int[]> comp = new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				for(int i = 0; i < o1.length; i++)
					if(o1[i]<o2[i])return -1;
					else if(o1[i]>o2[i])return 1;
				return 0;
			}
		};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int c = 0, C = parseInt(in.readLine().trim()); c < C; c++){
			if(c>0)in.readLine();
			TreeMap<int[], Integer> mapa = new TreeMap<int[], Integer>(comp);
			for(int i = 0, I = parseInt(in.readLine().trim()); i++ < I;){
				StringTokenizer st = new StringTokenizer(in.readLine());
				int[] ln = new int[6];
				for(int j = 0; j < 6; j++)ln[j] = parseInt(st.nextToken());
				if(mapa.containsKey(ln))mapa.put(ln, mapa.get(ln) + 1);
				else mapa.put(ln, 1);
			}
			for(Entry<int[], Integer> entry: mapa.entrySet()){
				sb.append(new String(llenarCeros(entry.getKey()[0], 2)) + " ");
				sb.append(new String(llenarCeros(entry.getKey()[1], 8)) + " ");
				sb.append(new String(llenarCeros(entry.getKey()[2], 4)) + " ");
				sb.append(new String(llenarCeros(entry.getKey()[3], 4)) + " ");
				sb.append(new String(llenarCeros(entry.getKey()[4], 4)) + " ");
				sb.append(new String(llenarCeros(entry.getKey()[5], 3)) + " ");
				sb.append(entry.getValue() + "\n");
			}
			if(c<C-1)sb.append("\n");
		}
		System.out.print(new String(sb));
	}
	static char[] llenarCeros(int n, int num){
		char[] res = new char[num];
		for(int i = res.length - 1; i >= 0; n/=10, i--)
			res[i] = (char)(n%10 + '0');
		return res;
	}
}
