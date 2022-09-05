package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10055
 * @problemName Hashmat the brave warrior
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UVa10055 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = in.readLine();
			if(s == null || s.equals(""))break;
			long n = Long.parseLong(s.substring(0, s.indexOf(" ")).trim()), m = Long.parseLong(s.substring(s.indexOf(" ")+1, s.length()).trim());
			System.out.println(Math.abs(n-m));
		}
	}
}
