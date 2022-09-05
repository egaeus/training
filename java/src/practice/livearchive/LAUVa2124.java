package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2124
 * @problemName Base Addition
 * @judge http://livearchive.onlinejudge.org/
 * @category math
 * @level easy
 * @date 16/11/2011
 **/
import static java.lang.Long.parseLong;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa2124 {
	public static void main(String[] args) throws Throwable{
		char[] letraMinima=new char[37];
		for(int i=2;i<=10;i++)letraMinima[i]=(char)(i-1+'0');
		for(int i=11;i<37;i++)letraMinima[i]=(char)(i-11+'A');
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(String ln;!(ln=in.readLine().trim()).equals("0");){
			String a=ln,b=in.readLine().trim(),c=in.readLine().trim();
			char max='2';int baseDesde=2;
			for(int i=0;i<a.length();i++)max=(char)Math.max(max,a.charAt(i));
			for(int i=0;i<b.length();i++)max=(char)Math.max(max,b.charAt(i));
			for(int i=0;i<c.length();i++)max=(char)Math.max(max,c.charAt(i));
			for(;letraMinima[baseDesde]!=max;baseDesde++);
			for(;baseDesde<37;baseDesde++)if(parseLong(a,baseDesde)+parseLong(b,baseDesde)==parseLong(c,baseDesde))break;
			if(baseDesde<37)System.out.println(a+" + "+b+" = "+c+" in base "+baseDesde);
			else System.out.println(a+" + "+b+" != "+c);
		}
	}
}
