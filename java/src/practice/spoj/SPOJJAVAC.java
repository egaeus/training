package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId JAVAC
 * @problemName Java vs C ++
 * @judge http://www.spoj.pl
 * @category characters
 * @level easy
 * @date 22/02/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
public class SPOJJAVAC {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(String ln; (ln = in.readLine())!=null; ){
			char[] arr = ln.toCharArray();
			if(Pattern.compile("[a-z]+[a-zA-Z]+").matcher(ln).matches())
				for(char c: arr)
					if(Character.isLowerCase(c))sb.append(c);
					else sb.append("_" + Character.toLowerCase(c));
			else if(Pattern.compile("[a-z]+(_[a-z]+)*").matcher(ln).matches())
				for(int i = 0; i < arr.length; i++)
					if(arr[i] != '_')sb.append(arr[i]);
					else sb.append(Character.toUpperCase(arr[++i]));
			else sb.append("Error!");
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
