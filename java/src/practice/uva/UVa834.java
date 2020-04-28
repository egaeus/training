package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 834
 * @problemName Continued Fractions
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 20/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa834 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln;(ln=in.readLine())!=null;) {
			StringTokenizer st=new StringTokenizer(ln);
			int a=parseInt(st.nextToken()),b=parseInt(st.nextToken()),x;
			System.out.print("["+a/b+";");
			for(x=b,b=a%b,a=x;a>b&&b>0&&a%b>0;x=b,b=a%b,a=x)
				System.out.print(a/b+",");
			System.out.println(a+"]");
		}
	}
}
