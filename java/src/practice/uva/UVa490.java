package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 490
 * @problemName Rotating Sentences
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 30/08/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVa490 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> arr = new ArrayList<String>();
		int max = 0;
		for (String ln; (ln = in.readLine()) != null; ) {
			max = Math.max(max, ln.length());
			arr.add(ln);
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < max; i++) {
			for (int j = arr.size() - 1; j >= 0; j--) 
				sb.append(i < arr.get(j).length()?arr.get(j).charAt(i):" ");
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
