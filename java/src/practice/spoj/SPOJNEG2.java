package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId NEG2
 * @problemName The Moronic Cowmpoute
 * @judge http://www.spoj.pl
 * @category adhoc
 * @level easy
 * @date 10/03/2011
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.ceil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class SPOJNEG2 {
	static long[] arr = new long[16];
	static String function(long N){
		if(N == 0)return "0";
		if(N < 0) return function((long)ceil((abs(N))/2.0)) + (abs(N))%2;
		if(N == 1)return "1";
		String[] res = new String[]{"01", "10", "11", "00"};
		int bs = Arrays.binarySearch(arr, N);
		if(bs>0)bs--;
		else bs=abs(bs) - 2;
		return (bs>0?function(arr[bs-1]+(N-arr[bs]-1)/4+1):"1") + res[(int)(N-arr[bs])%4];
	}
	public static void main(String[] args) throws Throwable {
		StringBuilder sb = new StringBuilder();
		arr[0] = 1;
		for(long cont = 1, i = 1; i < arr.length; i++)arr[(int)i] = arr[(int)i-1] + (cont*=4);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine()) != null; )
			sb.append(function(parseInt(ln))+"\n");
		System.out.print(new String(sb));
	}
}
