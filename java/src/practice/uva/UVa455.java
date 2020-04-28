package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict No enviado
 * @problemId 455
 * @problemName Periodic Strings
 * @judge http://uva.onlinejudge.org/
 * @category strings
 * @level easy
 * @date 17/6/2015
 **/
import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Math.*;
public class UVa455 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int T=parseInt(in.readLine().trim()),t=0;t<T;t++) {
			if(t>0)
				sb.append("\n");
			in.readLine();
			char[] str=in.readLine().trim().toCharArray();
			int res=-1;
			for(int i=1;i<=str.length&&res==-1;i++)
				if(str.length%i==0) {
					boolean ws=true;
					for(int j=0;j<str.length&&ws;j+=i) 
						ws=is(str, j, i);
					if(ws)
						res=i;
				}
			sb.append(res).append("\n");
		}
		System.out.print(new String(sb));
	}
	
	static boolean is(char[] str, int from, int length) {
		for(int i=from;i<from+length;i++) 
			if(str[i-from]!=str[i])
				return false;
		return true;
	}
}
