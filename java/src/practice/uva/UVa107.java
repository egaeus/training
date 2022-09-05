package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 107
 * @problemName The Cat in the Hat
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 31/03/2011
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa107 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st; (st = new StringTokenizer(in.readLine()))!=null; ){
			long A=parseInt(st.nextToken()), B=parseInt(st.nextToken());
			if(A==0&&B==0)break;
			int I = 1;
			for(; B>1; I++)
				if(abs(log(A)/log(I+1)-log(B)/log(I))<=1E-8)break;
			long res1 = 0, res2 = 0, cant = 0;
			for(long k = A, j = 1; k >= 1; res2+=j*k, k/=(I+1), j*=I, cant++);
			for(long i = 0, j = 1; i < cant-1; i++, res1+=j, j*=I);
			System.out.println(res1 + " " + res2);
		}
	}
}
