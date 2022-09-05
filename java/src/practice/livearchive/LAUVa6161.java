package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 6161
 * @problemName Decision Making
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Jul 9, 2013
 **/
import java.util.Scanner;
public class LAUVa6161 {
	public static void main(String args[]) throws Throwable {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for (int T=sc.nextInt(),t=0;t++<T;) {
			char[] arr=sc.next().toCharArray();
			System.out.println(arr[arr.length/2-1]==arr[arr.length/2]?"Do-it":"Do-it-Not");
		}
		System.out.print(new String(sb));
	}
}
