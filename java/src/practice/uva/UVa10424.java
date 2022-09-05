package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10424
 * @problemName Love Calculator
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 20/12/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
public class UVa10424 {
	static int sum(char[] str){
		int p=0;for(int i=0;i<str.length;i++)if(Character.isLetter(str[i]))p+=Character.toLowerCase(str[i])-'a'+1;
		for(int h=0;p>=10;p=h,h=0)
			for(;p>0;h+=(p%10),p/=10);
		return p;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln;(ln=in.readLine())!=null;) {
			int p=sum(ln.toCharArray()),k=sum(in.readLine().toCharArray());			
			System.out.printf(Locale.US,"%.2f %%\n",p>k?100.*k/p:100.*p/k);
		}
	}
}
