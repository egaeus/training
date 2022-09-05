package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 893
 * @problemName Y3K Problem
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Jun 4, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
public class UVa893 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;) {
			int N=parseInt(st.nextToken()),D=parseInt(st.nextToken()),M=parseInt(st.nextToken()),Y=parseInt(st.nextToken());
			if(N==0&&D==0&&M==0&&Y==0)break;
			Calendar cal=GregorianCalendar.getInstance();
			cal.set(Y,M-1,D);
			cal.add(Calendar.DAY_OF_YEAR, N);
			sb.append(cal.get(Calendar.DATE)).append(" ");
			sb.append(cal.get(Calendar.MONTH)+1).append(" ");
			sb.append(cal.get(Calendar.YEAR));
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
