package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10161
 * @problemName Ant on a Chessboard
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 15/12/2011
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10161 {
	static int[] f(int N){
		int a=(int)sqrt(N);
		if(abs(a-sqrt(N))<1e-10)return new int[]{a%2==0?a:1,a%2==0?1:a};
		if(a%2==0)return new int[]{N-a*a<=a+1?a+1:(a+1)*(a+1)-N+1,N-a*a<=a+1?N-a*a:a+1};
		return new int[]{N-a*a<=a+1?N-a*a:a+1,N-a*a<=a+1?a+1:(a+1)*(a+1)-N+1};
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int N,r[];(N=parseInt(in.readLine()))!=0;) {
			System.out.println((r=f(N))[0]+" "+r[1]);
		}
	}
}
