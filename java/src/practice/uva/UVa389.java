package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 389
 * @problemName Basically Speaking
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 5/01/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa389 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for (String ln;(ln=in.readLine())!=null;) {
			StringTokenizer st=new StringTokenizer(ln);
			String N=st.nextToken(),R;int B=parseInt(st.nextToken()),C=parseInt(st.nextToken());
			R=Integer.toString(parseInt(N,B),C).toUpperCase();
			if(R.length()>7)R="ERROR";
			for(int i=R.length();i<7;i++)sb.append(" ");
			sb.append(R+"\n");
		}
		System.out.print(new String(sb));
	}
}
