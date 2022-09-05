package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10072
 * @problemName Back to High School Physics
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UVa10071 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = in.readLine();
			if(s == null || s.equals(""))break;
			String arr[] = s.trim().split(" +");
			int n = Integer.parseInt(arr[0]), m = Integer.parseInt(arr[1]);
			System.out.println(n*m*2);
		}
	}
}
