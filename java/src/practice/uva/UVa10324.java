package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10324
 * @problemName Zeros and Ones
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 27/12/2011
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa10324 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();int caso=1;
		for (String ln;(ln=in.readLine())!=null;caso++) {
			char[] str=ln.trim().toCharArray();
			int n,s[]=new int[n=str.length];
			s[0]=str[0]-'0';
			for(int i=1;i<n;i++)s[i]=s[i-1]+(str[i]-'0');
			int M=parseInt(in.readLine().trim());
			sb.append("Case "+caso+":\n");
			for(int i=0;i<M;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				int A=parseInt(st.nextToken()),B=parseInt(st.nextToken()),I=min(A,B),J=max(A,B),
				suma=s[J]-(I>0?s[I-1]:0);
				sb.append(suma==0||suma==J-I+1?"Yes\n":"No\n");
			}
		}
		System.out.print(new String(sb));
	}
}
