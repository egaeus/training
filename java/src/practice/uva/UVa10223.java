package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10223
 * @problemName How many nodes?
 * @judge http://uva.onlinejudge.org/
 * @category math, number theory
 * @level easy
 * @date 14/02/2011
 **/
import static java.lang.Long.parseLong;
import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class UVa10223 {
	//Maximo hasta 35
	static long[] getNumerosCatalan(int cantidadNumeros){
		long[] res = new long[cantidadNumeros];
		res[0] = 1;
		for(int i = 1; i < res.length; i++)
			for(int j = 0; j < i; j++)
				res[i] += res[j]*res[i-1-j];
		return res;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long[] catalan = getNumerosCatalan(20);
		for(String ln; (ln = in.readLine()) != null; ){
			long N = parseLong(ln.trim());
			System.out.println(max(1, Arrays.binarySearch(catalan, N)));
		}
	}
}
