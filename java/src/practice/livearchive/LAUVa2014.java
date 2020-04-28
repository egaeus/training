package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2014
 * @problemName Are We There Yet?
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 27/07/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2014 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int c=1;;c++){
			StringTokenizer st=new StringTokenizer(in.readLine());
			int C=parseInt(st.nextToken());
			if(Math.abs(C)>=5280)break;
			if(c>1)sb.append("\n");
			int d=Math.abs(C),ant=0;
			for(int n;(n=parseInt(st.nextToken()))!=C;){
				sb.append("Moving from "+ant+" to "+n+": ");
				if(d==Math.abs(C-n))sb.append("same");
				else if(d>Math.abs(C-n))sb.append("warmer");
				else sb.append("colder");
				sb.append(".\n");
				ant=n;d=Math.abs(C-n);
			}
			sb.append("Moving from "+ant+" to "+C+": found it!\n");
		}
		System.out.print(new String(sb));
	}
}
