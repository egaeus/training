package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10302
 * @probleName Summation of Polynomials 
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 2009
 **/
import java.math.BigInteger;
import java.util.Scanner;
public class UVa10302 {
	public static void main(String[] args) throws Throwable{
		BigInteger[] arr = new BigInteger[50001];
		arr[0] = BigInteger.ZERO;
		for (int i = 1; i < arr.length; i++)
			arr[i] = arr[i-1].add(new BigInteger(i + "").pow(3));
		for (Scanner sc = new Scanner(System.in); sc.hasNextInt(); ) 
			System.out.println(arr[sc.nextInt()]);
	}
}
