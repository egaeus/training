package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2085
 * @problemName Digital Roots
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 16/11/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa2085 {
	static String f(String s){
		if(s.length()==1)return s;
		char[] str=s.toCharArray();
		int r=0;
		for(int i=0;i<str.length;i++)r+=str[i]-'0';
		return f(r+"");
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(String ln;!(ln=in.readLine().trim()).equals("0");)
			System.out.println(f(ln));
	}
}
