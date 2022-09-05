package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10137
 * @problemName The Trip 
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 06/12/2010
 **/
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
public class UVa10137 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int N; (N = parseInt(in.readLine().trim()))!=0; ) {
			double[] arr = new double[N];
			double sum = 0;
			for (int i = 0; i < N; i++){ 
				arr[i] = parseDouble(in.readLine().trim())*100;
				sum+=arr[i];
			}
			Arrays.sort(arr);
			sum=sum/N;
			long resPos = 0, resNeg = 0;
			for (int i = 0; i < N; i++) 
				if(arr[i]>sum)resPos += (arr[i] - sum);
				else resNeg += (sum - arr[i]);
			System.out.printf(Locale.US, "$%.2f%n", Math.max(resPos, resNeg)/100.);
		}
	}
}