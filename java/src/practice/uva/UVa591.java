package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 591
 * @problemName Box of Bricks 
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa591 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int caso = 1;
		while(true){
			int n = Integer.parseInt(in.readLine());
			if(n==0)break;
			String s[] = in.readLine().trim().split(" +");
			int sum = 0;
			for (int i = 0; i < s.length; i++) {
				sum += Integer.parseInt(s[i]);
			}
			int res = 0;
			for (int i = 0; i < s.length; i++) {
				if(Integer.parseInt(s[i])>sum/n)res+=Integer.parseInt(s[i])-(sum/n);
			}
			System.out.println("Set #"+caso+"\nThe minimum number of moves is "+res+ ".\n");
			caso++;
		}
	}
}
