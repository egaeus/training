package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10465
 * @problemName Homer Simpson
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Nov 5, 2013
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa10465 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln;(ln=in.readLine())!=null;) {
			StringTokenizer st=new StringTokenizer(ln);
			int m=parseInt(st.nextToken()),n=parseInt(st.nextToken()),t=parseInt(st.nextToken()),min=min(m,n),max=max(m,n);
			int solMax=0,solMin=MAX_VALUE;
			for(int i=0;i*min<=t;i++) {
				if((t-(i*min))%max<=solMin) {
					solMax=max(solMax,i+(t-(i*min))/max);
					solMin=(t-(i*min))%max;
				}
			}
			System.out.println(solMax+(solMin>0?" "+solMin:""));
		}
	}
}
