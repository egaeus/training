package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId LASTDIG
 * @problemName Last Digit
 * @judge http://www.spoj.pl
 * @category Adhoc
 * @level easy
 * @date 21/02/2011
 **/
import java.util.Scanner;
public class SPOJLASTDIG {
	public static void main(String[] args) throws Throwable{
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[][]{{0},{1},{2,	4,	8,	6},{3,	9,	7,	1},{4,	6},{5},{6},{7,	9,	3,	1},{8,	4,	2,	6},{9,	1}};
		for(int c = 0, C = sc.nextInt(), N, B; c++ < C;){
			N = sc.nextInt();
			B = sc.nextInt();
			if(B == 0)System.out.println(1);
			else System.out.println(arr[N%10][(B-1)%arr[N%10].length]);
		}
	}
}
