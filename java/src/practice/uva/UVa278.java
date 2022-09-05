package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 278
 * @problemName Chess
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Aug 27, 2013
 **/
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa278 {
	static int rook() {
		return min(C,R);
	}
	static int R,C;
	static int queen() {
		return min(C,R);
	}
	static int king() {
		return (C/2+(C%2==0?0:1))*(R/2+(R%2==0?0:1));
	}
	static int knight() {
		return C%2==0?C/2*R:(C*(R/2));
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int t=0,T=parseInt(in.readLine().trim());t++<T;) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			char type=st.nextToken().charAt(0);
			R=parseInt(st.nextToken());
			C=parseInt(st.nextToken());
			if(type=='K')System.out.println(king());
			if(type=='Q')System.out.println(queen());
			if(type=='k')System.out.println(knight());
			if(type=='r')System.out.println(rook());
		}
	}
}
