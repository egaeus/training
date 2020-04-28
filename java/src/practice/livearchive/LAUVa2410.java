package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2410
 * @problemName IP Address Analysis
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 07/12/2011
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2410 {
	static String llenarCeros(String s){
		for(;s.length()<8;)s="0"+s;
		return s;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;){
			StringTokenizer st=new StringTokenizer(ln.trim(),".");
			String A=llenarCeros(toBinaryString(parseInt(st.nextToken()))),B=llenarCeros(toBinaryString(parseInt(st.nextToken()))),
			C=llenarCeros(toBinaryString(parseInt(st.nextToken()))),D=llenarCeros(toBinaryString(parseInt(st.nextToken())));
			int prefix=-1,sufix=-1;
			if(A.startsWith("0")){
				prefix=parseInt(A,2);
				sufix=parseInt(B+C+D,2);
			}
			else if(A.startsWith("10")){
				prefix=parseInt(A.substring(2)+B,2);
				sufix=parseInt(C+D,2);
			}
			else if(A.startsWith("110")){
				prefix=parseInt(A.substring(3)+B+C,2);
				sufix=parseInt(D,2);
			}
			sb.append("prefix = ");
			for(int i=(prefix+"").length();i<8;i++)sb.append(" ");
			sb.append(prefix+"  suffix = ");
			for(int i=(sufix+"").length();i<8;i++)sb.append(" ");
			sb.append(sufix+"\n");
		}
		System.out.print(new String(sb));
	}
}
