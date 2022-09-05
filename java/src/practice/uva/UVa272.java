package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 272
 * @problemName TEX Quotes
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UVa272 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cont = 0;
		while (true) {
			String s = in.readLine();
			if (s == null)
				break;
			for (int i = 0; i < s.length(); i++)
				if (s.charAt(i) == '"') {
					cont++;
					if (cont % 2 == 0)
						System.out.print("''");
					else
						System.out.print("``");
				} else
					System.out.print(s.charAt(i));
			System.out.println();
		}
	}
}
