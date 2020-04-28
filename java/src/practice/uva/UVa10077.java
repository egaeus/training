package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10077
 * @problemName The Stern-Brocot Number System
 * @judge http://uva.onlinejudge.org/
 * @category adhoc, math
 * @level easy
 * @date 14/02/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa10077 {
	static int arriba, abajo;
	static String function(int a1, int b1, int a2, int b2){
		if(a1 + a2 == arriba && b1 + b2 == abajo)return "";
		if(1.*(a1+a2)/(b1+b2)>1.*arriba/abajo)return "L"+function(a1, b1, a1+a2, b1+b2);
		return "R"+function(a1+a2, b1+b2, a2, b2);
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine().trim()) != null; ){
			StringTokenizer st = new StringTokenizer(ln);
			arriba = parseInt(st.nextToken());
			abajo = parseInt(st.nextToken());
			if(arriba==1&&abajo==1)break;
			System.out.println(function(0, 1, 1, 0));
		}
	}
}
