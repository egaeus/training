package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10019
 * @problemName Funny Encryption Method
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10019 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < n; i++) {
			String str = in.readLine().trim();
			System.out.println(Integer.bitCount(Integer.parseInt(str)) + " " + Integer.bitCount(Integer.parseInt(str, 16)));
		}
	}
}