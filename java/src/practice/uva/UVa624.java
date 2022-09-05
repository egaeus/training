package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 624
 * @problemName CD
 * @judge http://uva.onlinejudge.org/
 * @category dynamic programming
 * @level easy
 * @date 28/04/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVa624 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for (String ln; (ln = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(ln.trim());
			int V = parseInt(st.nextToken());
			int[] arr = new int[V + 1]; 
			arr[0]=1;	
			TreeMap<Integer, Integer> caminos[] = new TreeMap[V+1];
			caminos[0] = new TreeMap<Integer, Integer>();
			caminos[0].put(1,0);
			int[] pesos = new int[parseInt(st.nextToken())];
			for (int i = 0; i < pesos.length; i++) pesos[i] = parseInt(st.nextToken());
			for (int i = 0; i < pesos.length; i++)
				for (int j = arr.length - pesos[i] - 1; j >= 0; j--)
					if(arr[j]>0){
						if(caminos[j+pesos[i]]==null)caminos[j+pesos[i]] = new TreeMap<Integer, Integer>();
						arr[j+pesos[i]] = Math.max(arr[j+pesos[i]], arr[j] + 1);
						if(!caminos[j+pesos[i]].containsKey(arr[j+pesos[i]]))
							caminos[j+pesos[i]].put(arr[j+pesos[i]], j);
					}
			int val = -1;
			for (int i = arr.length - 1; i >= 0 && val == -1; i--)if(caminos[i]!=null)val = i;
			int cant = caminos[val].lastKey(), ant = caminos[val].lastEntry().getValue();
			String res = "sum:" + val; 
			for (; val > 0; ) {
				res = val - ant + " " + res;
				val = ant;
				ant = caminos[ant].get(--cant);
			}
			sb.append(res + "\n");
		}
		System.out.print(new String(sb));
	}
}
