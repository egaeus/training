package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2202
 * @problemName Vito's family
 * @judge http://livearchive.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 17/11/2011
 **/
import static java.lang.Integer.MAX_VALUE;

import java.util.Arrays;
import java.util.Scanner;
public class LAUVa2202 {
	public static void main(String[] args) throws Throwable{
		Scanner sc = new Scanner(System.in);
		for (int i = 0, N = sc.nextInt(); i < N; i++) {
			int[] arr = new int[sc.nextInt()];
			for (int j = 0; j < arr.length; j++)arr[j] = sc.nextInt();
			Arrays.sort(arr);
			int sum = 0, sum1 = MAX_VALUE;
			for (int j = 0; j < arr.length; j++) sum += Math.abs(arr[arr.length/2] - arr[j]);
			if(arr.length%2==0){
				sum1 = 0;
				for (int j = 0; j < arr.length; j++) sum1 += Math.abs(arr[arr.length/2 - 1] - arr[j]);
			}
			System.out.println(Math.min(sum, sum1));
		}
	}	
}
