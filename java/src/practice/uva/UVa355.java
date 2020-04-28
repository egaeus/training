package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 355
 * @problemName The Bases Are Loaded
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 12/04/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa355 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String ln;(ln=in.readLine())!=null;) {
			StringTokenizer st=new StringTokenizer(ln);
			int desde=parseInt(st.nextToken()),hasta=parseInt(st.nextToken());
			String n=st.nextToken();
			try{
				sb.append(n+" base "+desde+" = "+Long.toString(Long.parseLong(n.toLowerCase(),desde),hasta).toUpperCase()+" base "+hasta+"\n");
			}catch(Exception e){sb.append(n+" is an illegal base "+desde+" number\n");}
		}
		System.out.print(new String(sb));
	}
}
