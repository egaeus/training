package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 3279
 * @problemName Dice
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 09/08/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa3279{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			String a=st.nextToken(),b=st.nextToken(),c=st.nextToken();
			if(a.equals("#")&&b.equals("#")&&c.equals("#"))break;
			int N=parseInt(in.readLine().trim()),c1=0,d=c.equals("even")?1:0;
			st=new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++)c1+=parseInt(st.nextToken())%2==d?1:0;
			sb.append(a+" "+c1+" "+b+" "+(N-c1)+"\n");
		}
		System.out.print(new String(sb));
	}
}
