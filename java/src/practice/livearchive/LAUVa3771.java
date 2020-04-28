package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3771
 * @problemName The Brave Sir Robin's cAsE cOrReCtOr
 * @judge http://livearchive.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 22/11/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa3771 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		boolean may=false;
		StringBuilder sb=new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;){
			if(ln.equals(""))may=false;
			char[] str=ln.toCharArray();
			for(int i=0;i<str.length;i++){
				if(str[i]=='.'||str[i]=='?'||str[i]=='!')may=true;
				if(Character.isDigit(str[i]))may=false;
				if(Character.isLetter(str[i])){
					if(may)sb.append(Character.toUpperCase(str[i]));
					else sb.append(Character.toLowerCase(str[i]));
					may=false;
				}
				else sb.append(str[i]);
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
