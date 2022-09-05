package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 488
 * @problemName Triangle Wave 
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2008
 **/
import java.util.Scanner;
public class UVa488 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		for (int i = 0, N = sc.nextInt(); i < N; i++) {
			int A = sc.nextInt(), F = sc.nextInt();
			for (int k = 0; k < F; k++) {
				for (int j = 1; j <= A; j++) {
					for (int j2 = 0; j2 < j; j2++)
						sb.append(j);
					sb.append("\n");
				}
				for (int j = A - 1; j > 0; j--) {
					for (int j2 = 0; j2 < j; j2++)
						sb.append(j);
					sb.append("\n");
				}
				if(k < F - 1 || i < N - 1)sb.append("\n");
			}
		}
		System.out.print(new String(sb));
	}
}
