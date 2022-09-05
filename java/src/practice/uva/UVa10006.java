package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10006
 * @problemName Carmichael Numbers
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 15/09/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class UVa10006 {		
	public static void main(String[] args) throws Throwable{
		StringBuffer sb = new StringBuffer();
		/*boolean primos[] = new boolean[65001];
		primos[0] = primos[1] = true;
		boolean mem[] = new boolean[65000];
		for (int i = 0; i < primos.length; i++) 
				if(!primos[i])for (int j = 2*i; j < primos.length; j+=i) primos[j] = true;
		for (int k = 2; k < mem.length; k++) {
			boolean ws = primos[k];
			for(int i = 2; i < k && ws; i++) 
				ws = BigInteger.valueOf(i).modPow(BigInteger.valueOf(k), BigInteger.valueOf(k)).equals(BigInteger.valueOf(i));
			mem[k] = ws && primos[k];
			if(ws)System.out.println(k);
		}		
		*/
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] chermicals = new int[]{561, 1105, 1729, 2465, 2821, 6601, 8911, 10585, 15841, 29341, 41041,
				46657, 52633, 62745, 63973};
		for (int N; (N = parseInt(in.readLine().trim())) != 0;) {
			if(Arrays.binarySearch(chermicals, N)>=0)
				sb.append("The number " + N + " is a Carmichael number.\n");
			else sb.append(N + " is normal.\n");
		}
		System.out.print(new String(sb));
	}
}
