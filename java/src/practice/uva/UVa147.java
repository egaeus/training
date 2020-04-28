package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 147
 * @problemName Dollars
 * @judge http://uva.onlinejudge.org/
 * @category pd
 * @level easy
 * @date 12/08/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa147 {
	public static void main(String[] args) throws Throwable{
		long[] arr = new long[30001];
		int[] costos = new int[]{10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5};
		arr[0]=1;
		for (int i = 0; i < costos.length; i++) 
			for (int j = costos[i]; j < arr.length; j++) 
				arr[j]+=arr[j-costos[i]];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int c; ; ) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim(), ".");
			c = parseInt(st.nextToken()) * 100 + parseInt(st.nextToken());
			if(c==0)break;
			for (int i = ("" + c).length() + (c<100?1:0) + (c<10?1:0); i < 5; i++)
				System.out.print(" ");
			System.out.printf(Locale.US, "%.2f", c/100.0);
			for (int i = ("" + arr[c]).length(); i < 17; i++)
				System.out.print(" ");
			System.out.println(arr[c]);
		}
	}
}
