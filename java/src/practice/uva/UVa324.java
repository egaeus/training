package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 324
 * @problemName Factorial Frequencies
 * @judge http://uva.onlinejudge.org/
 * @category Math
 * @level easy
 * @date 2009
 **/
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
public class UVa324 {
	public static void main(String[] args) {
		BigInteger val = BigInteger.ONE;
		int[][] res = new int[367][10];
		long t = System.currentTimeMillis();
		for (int i = 1; i < 367; i++){ 
			val = val.multiply(new BigInteger(i + ""));
			char[] arr = (val + "").toCharArray();
			Arrays.sort(arr);
			for (int j = 0; j < 10; j++){
				int n = Arrays.binarySearch(arr, (char)(j + '0'));
				if(n>=0){
					int k = n;
					for (; k < arr.length && arr[k] == (char)(j + '0'); k++); 
					for (; n >= 0 && arr[n] == (char)(j + '0'); n--);
					res[i][j] = k - n - 1;
				}
			}
				
		}
		StringBuffer sb = new StringBuffer();
		for (Scanner sc = new Scanner(System.in); ; ){
			int n = sc.nextInt();
			if(n==0)break;
			sb.append(n + "! --");
			for (int i = 0; i < 10; i++) {
				sb.append((i%5==0?"\n   (":"    (") + i + ")");
				for (int j = 0; j < 5 - (res[n][i] + "").length(); j++) sb.append(" ");
				sb.append(res[n][i]);
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
			
	}
}
