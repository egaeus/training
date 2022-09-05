package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 408
 * @problemName Uniform Generator
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 23/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa408 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for (String ln;(ln=in.readLine())!=null;) {
			StringTokenizer st=new StringTokenizer(ln);
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());
			boolean[] mod=new boolean[M];
			for(int s=0;;s=(s+N)%M)if(mod[s])break;else mod[s]=true;
			boolean ws=true;
			for(int i=0;i<M&&ws;i++)ws=mod[i];
			for(int i=(N+"").length();i<10;i++)sb.append(" ");
			sb.append(N);
			for(int i=(M+"").length();i<10;i++)sb.append(" ");
			sb.append(M);
			sb.append("    "+(ws?"Good Choice":"Bad Choice")+"\n\n");
		}
		System.out.print(new String(sb));
	}
}
