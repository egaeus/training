package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3059
 * @problemName Speed Limit
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 26/07/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa3059{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int N;(N=parseInt(in.readLine().trim()))!=-1;){
			StringTokenizer st=new StringTokenizer(in.readLine());
			int s=parseInt(st.nextToken()),t=parseInt(st.nextToken());
			long res=s*t;
			for(int i=1;i<N;i++){
				st=new StringTokenizer(in.readLine());
				int S=parseInt(st.nextToken()),T=parseInt(st.nextToken());
				res+=(T-t)*S;
				t=T;
			}
			sb.append(res+" miles\n");
		}
		System.out.print(new String(sb));
	}
}
