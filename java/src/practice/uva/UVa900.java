package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 900
 * @problemName Brick Wall Patterns
 * @judge http://uva.onlinejudge.org/
 * @category dynamic programming
 * @level easy
 * @date 14/04/2010
 **/
import java.util.Scanner;
public class UVa900 {
	public static void main(String[] args) {
		long[] res = new long[51];
		res[0] = 1; res[1] = 1;
		for (int i = 2; i < res.length; i++)res[i]=res[i-2]+res[i-1];
		Scanner sc = new Scanner(System.in);
		for(int n; (n = sc.nextInt())!=0;)System.out.println(res[n]);
	}
}
