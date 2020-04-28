package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 495
 * @problemName Fibonacci Freeze 
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class UVa495 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BigInteger[] arr = new BigInteger[5001];
		arr[0] = BigInteger.ZERO;
		arr[1] = BigInteger.ONE;
		for (int i = 2; i < arr.length; i++)
			arr[i] = arr[i-1].add(arr[i-2]);
		int caso = 0;
		for(String n; (n = in.readLine()) != null; caso++)
			System.out.println(/* (caso==0?"":"\n") + */"The Fibonacci number for " + n + " is " + arr[Integer.parseInt(n.trim())]);
	}			
}
