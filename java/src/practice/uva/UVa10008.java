package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10008
 * @problemName What's Cryptanalysis?
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;
public class UVa10008 {	
	public static void ordenar(String[][] arbol){
		for (int i = 1; i < arbol.length; i++) {
			if(Integer.parseInt(arbol[i][1])>Integer.parseInt(arbol[i-1][1])){
				String valTemp = arbol[i][1], keyTemp = arbol[i][0];
				arbol[i][1] = arbol[i-1][1];
				arbol[i][0] = arbol[i-1][0];
				arbol[i-1][1] = valTemp;
				arbol[i-1][0] = keyTemp;
				ordenar(arbol);
			}
			else if(Integer.parseInt(arbol[i][1])==Integer.parseInt(arbol[i-1][1])&&arbol[i][0].charAt(0)<arbol[i-1][0].charAt(0)){
				String valTemp = arbol[i][1], keyTemp = arbol[i][0];
				arbol[i][1] = arbol[i-1][1];
				arbol[i][0] = arbol[i-1][0];
				arbol[i-1][1] = valTemp;
				arbol[i-1][0] = keyTemp;
				ordenar(arbol);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, Integer> arbol = new TreeMap<String, Integer>();
		int n = Integer.parseInt(in.readLine());
		for (int j = 0; j < n; j++) {
			String s = in.readLine();
			for (int i = 0; i < s.length(); i++) {
				if (Character.isLetter(s.charAt(i))) {
					String letra = Character.toString(s.charAt(i)).toUpperCase();
					if(arbol.containsKey(letra)){
						int val = arbol.get(letra);
						arbol.put(letra, val+1);
					}
					else arbol.put(letra, 1);
				}
			}
		}
		String[][] arr = new String[arbol.size()][2];
		int k = 0;
		for (Entry res: arbol.entrySet()) {
			arr[k][0] = (String)res.getKey();
			arr[k][1] = res.getValue() + "";
			k++;
		}
		ordenar(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i][0] + " " + arr[i][1]);
	}
}