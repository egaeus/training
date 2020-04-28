package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3093
 * @problemName IP Address
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 27/07/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa3093{
	static String s(String s,int a,int b){
		return s.substring(a,b);
	}
	static int b(String s){
		return parseInt(s,2);
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int t=0,T=parseInt(in.readLine().trim());t++<T;){
			String ln=in.readLine();
			sb.append(b(s(ln,0,8))).append(".").append(b(s(ln,8,16))).append(".");
			sb.append(b(s(ln,16,24))).append(".").append(b(s(ln,24,32))).append("\n");
		}
		System.out.print(new String(sb));
	}
}
