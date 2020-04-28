package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 846
 * @problemName Steps
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 14/02/2011
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa846 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = parseInt(in.readLine().trim()); c < C; c++){
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int cotaInf = parseInt(st.nextToken()), cotaSup = parseInt(st.nextToken());
			int dist = cotaSup - cotaInf;
			int dist2 = dist/2;
			int n = (int)floor((-1+sqrt(1+8*dist2))/2);
			System.out.println(2*n + (int)(dist - n*(n+1) > 0?ceil((dist*1. - n*(n+1))/(n+1)):0));
		}
	}
}
