package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 406
 * @problemName Prime Cuts
 * @judge http://uva.onlinejudge.org/
 * @category Simulation
 * @level easy
 * @date 26/07/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa406 {
	public static void main(String[] args) throws Throwable{
		boolean[] criba = new boolean[1000];
		ArrayList<Integer> primos = new ArrayList<Integer>();
		criba[0] = criba[1] = true;
		primos.add(1);
		for (int i = 0; i < criba.length; i++)
			if(!criba[i]){
				primos.add(i);
				for (int j = i + i; j < criba.length; j+=i)criba[j]=true;
			}
		Integer[] p = new Integer[primos.size()];
		primos.toArray(p);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine())!=null;){
			StringTokenizer st = new StringTokenizer(ln.trim());
			int N = parseInt(st.nextToken()), C = parseInt(st.nextToken());
			int cant = Arrays.binarySearch(p, N);
			cant++;
			cant = Math.abs(cant);
			System.out.print(N+ " " + C + ":");
			if(cant%2==0)
				for (int i = Math.max(cant/2 - C, 0); i < Math.min((cant/2 - C) + 2*C, cant); i++) System.out.print(" " + p[i]);
			else 
				for (int i = Math.max(cant/2 - C + 1, 0); i < Math.min(cant/2 - C + 1 + 2*C - 1, cant); i++) System.out.print(" " + p[i]);
			System.out.println("\n");
		}
	}
}
