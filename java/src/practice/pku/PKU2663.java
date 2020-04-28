package practice.pku; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2663
 * @judge http://acm.pku.edu.cn/JudgeOnline/
 * @category dynamic programming
 * @level easy
 * @date 19/04/2010
 **/
import java.math.BigInteger;
import java.util.Scanner;
public class PKU2663 {
	public static void main(String[] args) {
		BigInteger arr[] = new BigInteger[50];
		arr[0] = BigInteger.ONE;
		arr[2] = BigInteger.valueOf(3);
		for (int i = 4; i < arr.length; i+=2)
			arr[i] = (BigInteger.valueOf(4).multiply(arr[i - 2])).subtract(arr[i-4]);
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		for (int n; (n = sc.nextInt()) != -1; ) sb.append((n%2==0?arr[n]:0) + "\n");
		System.out.print(new String(sb));
	}
}
