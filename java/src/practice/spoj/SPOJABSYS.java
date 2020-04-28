package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId ABSYS
 * @problemName Anti-Blot System
 * @judge http://www.spoj.pl
 * @category Adhoc
 * @level easy
 * @date 22/02/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SPOJABSYS {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = parseInt(in.readLine().trim()); c++ < C;){
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine().replaceAll(" ", ""), "+");
			String izq = st.nextToken(), der, res;
			st = new StringTokenizer(st.nextToken(), "=");
			der = st.nextToken();
			res = st.nextToken();
			if(izq.contains("machula"))
				System.out.println((parseInt(res)-parseInt(der)) + " + " + der + " = " + res);
			else if(der.contains("machula"))
				System.out.println(izq + " + " + (parseInt(res)-parseInt(izq)) + " = " + res);
			else if(res.contains("machula"))
				System.out.println(izq + " + " + der + " = " + (parseInt(izq)+parseInt(der)));
			else System.out.println(izq + " + " + der + " = " + res);
		}
	}
}
