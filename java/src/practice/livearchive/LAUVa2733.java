package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2733
 * @problemName Caesar Cipher
 * @judge http://livearchive.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 31/07/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2733{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;!(ln=in.readLine()).equals("#");){
			StringTokenizer st=new StringTokenizer(ln,":");
			int n=parseInt(st.nextToken().trim());
			for(char s:st.nextToken().toCharArray())
				if(n>0) 
					if(Character.isUpperCase(s))sb.append((char)((s-'A'+n)%26+'A'));
					else if(Character.isLowerCase(s))sb.append((char)((s-'a'+n)%26+'a'));
					else if(Character.isDigit(s))sb.append((char)((s-'0'+n)%10+'0'));
					else sb.append(s);
				else
					if(Character.isUpperCase(s))sb.append((char)(25-(25-s+'A'-n)%26+'A'));
					else if(Character.isLowerCase(s))sb.append((char)(25-(25-s+'a'-n)%26+'a'));
					else if(Character.isDigit(s))sb.append((char)(9-(9-s+'0'-n)%10+'0'));
					else sb.append(s);
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
