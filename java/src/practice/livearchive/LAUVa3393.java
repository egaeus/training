package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3393
 * @problemName Copier Reduction
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 30/07/2012
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa3393{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int x=parseInt(st.nextToken()),y=parseInt(st.nextToken()),m=parseInt(st.nextToken()),n=parseInt(st.nextToken());
			if(x==0&&y==0&&m==0&&n==0)break;
			sb.append((int)min(100,max(min(m*100./x,n*100./y),min(n*100./x,m*100./y)))+"%\n");
		}
		System.out.print(new String(sb));
	}
}
