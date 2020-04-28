package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 294
 * @problemName Divisors
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 14/06/2011
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa294 {
	static long[] getPrimos(int cota) {
    	boolean[] arr = new boolean[cota + 1];
    	long[] res = new long[cota];
    	arr[0] = arr[1] = true;
    	int K = 0;
    	for (int i = 0; i < arr.length; i++)
          	if (!arr[i]) {
                	res[K++] = i;
                		for (int j = 2 * i; j < arr.length; j += i)arr[j] = true;
          	}
    	return Arrays.copyOfRange(res, 0, K);
	}
	static long numDivisores(long N, long[] primos){
    	long res = 0;long resAnt = 0;int sqrt = (int)Math.sqrt(N);
    	for (int i = 0; N > 1; i++) {
          		if(primos[i] > sqrt)N = 0;
          	if(N%primos[i]==0){
                		res += resAnt + 1;
                	N /= primos[i--];
          	}
          	else resAnt = res;
    	}
    	return res + 1;
	}
	public static void main(String[] args) throws Throwable{
		long[] primos = getPrimos((int)sqrt(1000000000)+10000);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c=0, C=parseInt(in.readLine().trim());c++<C;){
			StringTokenizer st = new StringTokenizer(in.readLine());
			long N = parseInt(st.nextToken()), M = parseInt(st.nextToken()), max = 0, val = 0;
			for(long i = N; i <= M; i++){
				long cant = numDivisores(i, primos);
				if(cant>max){max=cant;val=i;}
			}
			System.out.println("Between "+N+" and "+M+", "+val+" has a maximum of "+max+" divisors.");
		}
	}
}
