package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId GIRLSNBS
 * @problemName Girls and Boys
 * @judge http://www.spoj.pl
 * @category Adhoc
 * @level easy
 * @date 19/10/2010
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;
import static java.lang.Math.ceil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SPOJGIRLSNBS {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(;;){
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int G = parseInt(st.nextToken()), B = parseInt(st.nextToken());
			if(G==-1&&B==-1)break;
			System.out.println((int)ceil(1.*max(G,B)/(min(B,G)+1)));
		}
	}
}
