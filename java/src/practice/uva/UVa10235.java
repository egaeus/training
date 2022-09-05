package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 10235
 * @problemName Simply Emirp
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 20/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10235 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final int MAX=10000000;
		boolean[] primos=new boolean[MAX];
		primos[0]=primos[1]=true;
		for(int i=0;i<MAX;i++)if(!primos[i])for(int j=i+i;j<MAX;j+=i)primos[j]=true;
		for(String ln;(ln=in.readLine())!=null;) {
			int N=parseInt(ln.trim());
			if(primos[N])System.out.println(ln+" is not prime.");
			else if(parseInt(new String(new StringBuffer(ln.trim()).reverse()))==N||primos[parseInt(new String(new StringBuffer(ln.trim()).reverse()))])System.out.println(ln+" is prime.");
			else System.out.println(ln+" is emirp.");
		}
	}
}
