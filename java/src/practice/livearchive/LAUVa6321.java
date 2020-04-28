package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 6321
 * @problemName Kids Love Candies
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Sep 17, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa6321 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t=0,T=parseInt(in.readLine().trim());t++<T;) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			int N=parseInt(st.nextToken()), K=parseInt(st.nextToken());
			st=new StringTokenizer(in.readLine());
			int sol=0;
			for(int i=0;i<N;i++)
				sol+=parseInt(st.nextToken())/K;
			sb.append(sol).append("\n");
		}
		System.out.print(new String(sb));
	}
}
