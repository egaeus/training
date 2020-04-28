package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 5141
 * @problemName Repeating Decimals
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 10/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa5141 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;){
			StringTokenizer st=new StringTokenizer(ln);
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken()),n=N%M,c=1;
			int[] pos=new int[M];
			String rep="";
			for(;pos[n%M]==0;c++){
				pos[n]=c;n*=10;
				rep+=""+n/M;
				n%=M;
			}
			sb.append(N+"/"+M+" = "+N/M+"."+rep.substring(0,Math.min(pos[n]-1,50)));
			if(pos[n]-1<50)sb.append("("+rep.substring(pos[n]-1,Math.min(50,rep.length()))+(rep.length()>=50?"...)":")"));
			sb.append("\n");
			sb.append("   "+(c-pos[n%M])+" = number of digits in repeating cycle\n\n");
		}
		System.out.print(new String(sb));
	}
}
