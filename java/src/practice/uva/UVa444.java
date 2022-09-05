package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 444
 * @problemName Encoder and Decoder
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 22/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa444 {
	static String decode(char[] s){
		String r="";
		for(int i=s.length-1;i>=0;)
			if(s[i]=='1'){r+=(char)(parseInt(s[i]+""+s[i-1]+""+s[i-2]));i-=3;}
			else {r+=(char)(parseInt(s[i]+""+s[i-1]));i-=2;}
		return r;
	}
	static String encode(char[] s){
		String r="";
		for(int i=s.length-1;i>=0;i--)r+=new String(new StringBuilder(((int)s[i])+"").reverse());
		return r;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for (String ln;(ln=in.readLine())!=null;) {
			if(ln.length()>0&&Character.isDigit(ln.charAt(0)))sb.append(decode(ln.trim().toCharArray())+"\n");
			else sb.append(encode(ln.toCharArray())+"\n");
		}
		System.out.print(new String(sb));
	}
}
