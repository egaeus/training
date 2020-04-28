package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10300
 * @probleName Ecological Premium 
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UVa10300 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(in.readLine());
		for (int i = 0; i < c; i++) {
			int n = Integer.parseInt(in.readLine());
			int sum = 0;
			for (int j = 0; j < n; j++) {
				String[] arr = in.readLine().trim().split(" +");
				sum += (Integer.parseInt(arr[0])*Integer.parseInt(arr[2]));
			}
			System.out.println(sum);
		}
	}
}
