package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 6320
 * @problemName Encrypted Password
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Sep 19, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa6320 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t=0,T=parseInt(in.readLine().trim());t++<T;) {
			char[] encrypted=in.readLine().trim().toCharArray();
			char[] pass=in.readLine().trim().toCharArray();
			int[] contPass=new int[26];
			int[] contEncrypt=new int[26];
			for(int i=0;i<pass.length;i++) {
				contPass[pass[i]-'a']++;
				contEncrypt[encrypted[i]-'a']++;
			}
			boolean ws=false;
			for(int i=0;i<encrypted.length-pass.length&&!ws;i++) {
				if(compare(contEncrypt, contPass)) 
					ws=true;
				if(!ws) {
					contEncrypt[encrypted[i]-'a']--;
					contEncrypt[encrypted[i+pass.length]-'a']++;
				}
			}
			ws|=compare(contPass,contEncrypt);
			sb.append(ws?"YES":"NO").append("\n");
		}
		System.out.print(new String(sb));
	}
	public static boolean compare(int[] p, int[] c) {
		for(int i=0;i<p.length;i++)
			if(p[i]!=c[i])
				return false;
		return true;
	}
}
