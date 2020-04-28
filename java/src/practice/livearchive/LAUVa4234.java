package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 4234
 * @problemName Binary Clock
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 07/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa4234 {
	static String llenarCeros(String s){
		for(;s.length()<6;)s="0"+s;
		return s;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int c=0,C=parseInt(in.readLine().trim());c++<C;){
			StringTokenizer st=new StringTokenizer(in.readLine().trim(),":");
			String H=Integer.toBinaryString(parseInt(st.nextToken())),M=Integer.toBinaryString(parseInt(st.nextToken())),S=Integer.toBinaryString(parseInt(st.nextToken()));
			H=llenarCeros(H);M=llenarCeros(M);S=llenarCeros(S);
			sb.append(c+" ");
			for(int i=0;i<6;i++)sb.append(H.charAt(i)+""+M.charAt(i)+""+S.charAt(i));
			sb.append(" "+H+M+S+"\n");
		}
		System.out.print(new String(sb));
	}
}
