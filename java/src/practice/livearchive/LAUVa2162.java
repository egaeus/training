package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2162
 * @problemName S-Trees
 * @judge http://livearchive.onlinejudge.org/
 * @category trees, adhoc
 * @level easy
 * @date 2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class LAUVa2162 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int N, caso = 1; (N = parseInt(in.readLine().trim())) != 0; caso++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			TreeMap<String, Integer> orden = new TreeMap<String, Integer>();
			for (int i = 0; i < N; i++) orden.put(st.nextToken(), i);
			String resp = in.readLine().trim();
			System.out.println("S-Tree #" + caso);
			for (int i = 0, M = parseInt(in.readLine().trim()); i < M; i++) {
				String ln = in.readLine().trim();
				int arr[] = new int[N];
				for (int j = 0; j < arr.length; j++) arr[orden.get("x" + (j+1))] = ln.charAt(j) - '0';
				int indexInicio = 0, indexFin = resp.length();
				for (int j = 0; j < arr.length; j++) 
					if(arr[j]==0)indexFin = (indexInicio + indexFin)/2;
					else indexInicio = (indexInicio + indexFin)/2;
				System.out.print(resp.substring(indexInicio, indexFin));
			}
			System.out.println("\n");
		}
	}
}
