package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 5682
 * @problemName Class Statistics
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Jul 24, 2013
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class LAUVa5682 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int N=parseInt(in.readLine().trim()),n=0;n++<N;) {
			sb.append("Class ").append(n).append("\n");
			StringTokenizer st=new StringTokenizer(in.readLine());
			int K=parseInt(st.nextToken()),arr[]=new int[K];
			for(int i=0;i<K;i++)arr[i]=parseInt(st.nextToken());
			Arrays.sort(arr);
			int max=0;
			for(int i=1;i<K;i++)max=max(max,arr[i]-arr[i-1]);
			sb.append("Max ").append(arr[K-1]).append(", Min ").append(arr[0]).append(", Largest gap ").append(max).append("\n");
		}
		System.out.print(new String(sb));
	}
}
