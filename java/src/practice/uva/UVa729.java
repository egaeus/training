package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 729
 * @problemName The Hamming Distance Problem
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 10/10/2012
 **/
import static java.lang.Integer.bitCount;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa729{
	static String str(int a,int n){
		String s=toBinaryString(a)+"";
		for(;s.length()<n;s="0"+s);
		return s+"\n";
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int c=0,C=parseInt(in.readLine().trim());c<C;c++){
			if(c>0)sb.append("\n");
			in.readLine();
			StringTokenizer st=new StringTokenizer(in.readLine());
			int n=parseInt(st.nextToken()),h=parseInt(st.nextToken());
			for(int i=0;i<1<<n;i++)if(bitCount(i)==h)sb.append(str(i,n));
		}
		System.out.print(new String(sb));
	}
}
