package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict W.A.
 * @problemId 271
 * @problemName Simply Syntax
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level ?
 * @date 03/01/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa271 {
	static boolean function(char[] str, int pos1, int pos2){
		System.out.println(pos1 + " " + pos2);
		if(pos1 == pos2)return Character.isLowerCase(str[pos1]);
		if(str[pos1]=='N')return function(str, pos1+1, pos2);
		if(str[pos1]=='C'||str[pos1]=='D'||str[pos1]=='E'||str[pos1]=='I')
			for (int i = pos1 + 1; i < pos2; i++)
				if(!function(str, pos1+1, pos2) && function(str, pos1 + 1, i) && function(str, i + 1, pos2))return true;
		for(int i = pos1; i <= pos2; i++)if(Character.isUpperCase(str[i]))return false;
		return true;
	}
	static boolean function(char[] str){
		return new String(str).replaceAll("[p-zNCDEI]", "").length() == 0 && function(str, 0, str.length - 1);
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine()) != null; )
			System.out.println(function(ln.toCharArray())?"YES":"NO");
	}
}
