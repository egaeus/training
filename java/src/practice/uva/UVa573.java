package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 573
 * @problemName The Snail
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 28/07/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa573 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (; ; ) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			double H = parseInt(st.nextToken());
			if(H==0)break;
			double U = parseInt(st.nextToken()), D = parseInt(st.nextToken()), F = (U*parseInt(st.nextToken()))/100, pos = 0;
			int i;
			for (i = 0; pos <= H && pos >= 0; i++) {
				pos += U;
				if(pos>H)break;
				pos-=D;
				if(pos<0)break;
				U -= F;
				if(U<0)U=0;
			}
			System.out.println((pos>=0?"success":"failure") + " on day " + (i+1));
		}
	}
}
