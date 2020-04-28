package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId AE00
 * @problemName Rectangles
 * @judge http://www.spoj.pl
 * @category Adhoc
 * @level easy
 * @date 22/02/2011
 **/
import java.util.Arrays;
import java.util.Scanner;
public class SPOJAE00 {
	static long numDivisores(long N, long[] primos) {
		long res = 0;
		long resAnt = 0;
		int sqrt = (int) Math.sqrt(N);
		for (int i = 0; N > 1; i++) {
			if (primos[i] > sqrt) N=0;
			if (N % primos[i] == 0) {
				res += resAnt + 1;
				N /= primos[i--];
			} else
				resAnt = res;
		}
		return res + 1;
	}
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
	public static void main(String[] args) {
		int res = 1; long[] primos = getPrimos(10000);
		Scanner sc = new Scanner(System.in);
		for (int i = 2, N = sc.nextInt(); i <= N; res+=(int)Math.ceil(numDivisores(i, primos)/2.0), i++);
		System.out.println(res);
	}
}
