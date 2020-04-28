package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 1A
 * @problemName Theater Square
 * @judge http://codeforces.com/
 * @category adhoc
 * @level easy
 * @date Sep 9, 2013
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.ceil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class CF1A {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		double n=parseInt(st.nextToken()),m=parseInt(st.nextToken()),a=parseInt(st.nextToken());
		System.out.println((long)ceil(n/a)*(long)ceil(m/a));
	}
}
