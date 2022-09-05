package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 494
 * @problemName Kindergarten Counting Game 
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa494 {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String line; (line = in.readLine()) != null;) {
			String arr[] = line.trim().split("[^a-zA-z]+");
			int cont = 0;
			for (String m : arr)
				cont += m.length() == 0 ? 0 : 1;
			System.out.println(cont);
		}
	}
}
