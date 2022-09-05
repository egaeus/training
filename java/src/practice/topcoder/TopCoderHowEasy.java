package practice.topcoder; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId HowEasy
 * @problemName HowEasy
 * @judge http://www.topcoder.com
 * @category Adhoc
 * @level easy
 * @date 02/12/2010
 **/
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TopCoderHowEasy {
	public int pointVal(String str){
		StringTokenizer st = new StringTokenizer(str.trim());
		Pattern p = Pattern.compile("[A-Za-z]+[^a-z]?");
		int i = 0, cont = 0;
		for (; st.hasMoreTokens(); ) {
			String temp = st.nextToken();
			Matcher m = p.matcher(temp);
			if(m.matches()){cont+=temp.length();i++;if(!Character.isLetter(temp.charAt(temp.length() - 1)))cont--;}
		}
		return i == 0 || cont/i<=3?250:(cont/i<6?500:1000);
	}
}
