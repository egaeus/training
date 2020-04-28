package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId ARMY
 * @problemName Army Strength
 * @judge http://www.spoj.pl
 * @category Adhoc
 * @level easy
 * @date 22/02/2011
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SPOJARMY {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = parseInt(in.readLine().trim()); c++ < C;){
			in.readLine();in.readLine();
			int maxG = 0, maxM = 0;
			for(StringTokenizer st = new StringTokenizer(in.readLine()); st.hasMoreTokens(); ) maxG = max(maxG, parseInt(st.nextToken()));
			for(StringTokenizer st = new StringTokenizer(in.readLine()); st.hasMoreTokens(); ) maxM = max(maxM, parseInt(st.nextToken()));
			System.out.println(maxG>=maxM?"Godzilla":"MechaGodzilla");
		}
	}
}
