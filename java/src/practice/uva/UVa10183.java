package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10183
 * @problemName How Many Fibs?
 * @judge http://uva.onlinejudge.org/
 * @category math, binary search
 * @level easy
 * @date 20/12/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa10183 {
	public static void main(String[] args) throws Throwable{
		BigInteger arr[] = new BigInteger[1000];
		arr[0] = BigInteger.ONE;
		arr[1] = BigInteger.valueOf(2);
		for (int i = 2; i < arr.length; i++) arr[i] = arr[i-2].add(arr[i-1]);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln;(ln = in.readLine().trim()) != null;){
			StringTokenizer st = new StringTokenizer(ln);
			BigInteger A = new BigInteger(st.nextToken()), B = new BigInteger(st.nextToken());
			if(A.equals(BigInteger.ZERO) && B.equals(BigInteger.ZERO))break;
			int bsA = Arrays.binarySearch(arr, A);
			int bsB = Arrays.binarySearch(arr, B);
			if(bsA < 0)bsA = -1*bsA - 1;
			if(bsB < 0)bsB = -1*bsB - 2;
			System.out.println(bsB - bsA + 1);
		}
	}
}
