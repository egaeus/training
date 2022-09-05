package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 113
 * @problemName Power of Cryptography
 * @judge http://uva.onlinejudge.org/
 * @category Math
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa113 {
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = in.readLine();
			if (str == null || str.equals(""))
				break;
			int n = Integer.parseInt(str.trim());
			double x = Double.parseDouble(in.readLine().trim());
			System.out.println((int)(Math.pow(x, 1./n)+Math.exp(-8)));
		}
	}
}
