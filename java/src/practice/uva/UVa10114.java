package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10114
 * @problemName Loansome Car Buyer
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Jun 4, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa10114 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;) {
			int M=parseInt(st.nextToken());
			double V=Double.parseDouble(st.nextToken()),P=Double.parseDouble(st.nextToken());
			int N=parseInt(st.nextToken());
			if(M<0)break;
			double[][] dep=new double[N+1][];
			for(int i=0;i<N;i++){
				st=new StringTokenizer(in.readLine());
				dep[i]=new double[]{parseInt(st.nextToken()),Double.parseDouble(st.nextToken())};
			}
			dep[N]=new double[]{100000};
			double car=(V+P)*(1-dep[0][1]),month=P/M;
			int i=1;
			for(int j=1;i<=M&&P>car;i++) {
				if(i>=dep[j][0])j++;
				car*=(1-dep[j-1][1]);
				P-=month;
			}
			sb.append(i-1+" ");
			sb.append((i==2?"month":"months")+"\n");
		}
		System.out.print(new String(sb));
	}
}
