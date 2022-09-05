package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10346
 * @probleName Peter�s Smokes 
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa10346 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine()) != null; ){
			StringTokenizer st = new StringTokenizer(ln.trim());
			int n = parseInt(st.nextToken()), k = parseInt(st.nextToken());
			int sum = n;
			for(; n >= k; sum+=n/k, n-=((n/k)*(k-1)));
			System.out.println(sum);
		}
	}
}