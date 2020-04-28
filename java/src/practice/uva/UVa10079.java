package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10079
 * @probleName Pizza Cutting
 * @judge http://uva.onlinejudge.org/
 * @category geometry
 * @level easy
 * @date 29/04/2010
 **/
import java.util.Scanner;
public class UVa10079 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (long N; (N = sc.nextInt()) >= 0; )System.out.println(((N)*(N+1))/2 + 1);		
	}
}
