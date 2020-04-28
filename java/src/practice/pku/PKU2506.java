package practice.pku; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2506
 * @judge http://acm.pku.edu.cn/JudgeOnline/
 * @category dynamic programming
 * @level easy
 * @date 16/04/2010
 **/
import java.math.BigInteger;
import java.util.Scanner;
public class PKU2506{
	public static void main(String[] args) {
		BigInteger arr[] = new BigInteger[251], cuad[] = new BigInteger[251];
		arr[0] = arr[1] = BigInteger.ONE;
		cuad[0] = BigInteger.ONE; 
		for (int i = 2; i < arr.length; i++) {
			cuad[i-1]=cuad[i-2].multiply(BigInteger.valueOf(2));
			arr[i] = cuad[i-1].add(arr[i-2]);
		}
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		for (; sc.hasNextInt(); ) sb.append(arr[sc.nextInt()] + "\n");
		System.out.print(new String(sb));
	}
}
