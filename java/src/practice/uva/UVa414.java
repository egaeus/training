package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 414
 * @problemName Machined Surfaces
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 30/08/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa414 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int N = 0; (N = parseInt(in.readLine().trim())) != 0; ) {
			long sum = 0, may = 0;
			for (int i = 0; i < N; i++){
				String ln = (in.readLine().replaceAll(" ", "")); 
				sum+=ln.length();
				may = Math.max(may, ln.length());
			}
			System.out.println(may*N - sum);
		}
	}
}
