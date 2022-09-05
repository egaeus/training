package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 11689
 * @problemName Soda Surpler
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Aug 26, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa11689 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int t=0,T=parseInt(in.readLine().trim());t++<T;) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			int e=parseInt(st.nextToken())+parseInt(st.nextToken()),c=parseInt(st.nextToken()),s=0;
			for(;c<=e;s+=e/c,e=e/c+e%c);
			System.out.println(s);
		}
	}
}
