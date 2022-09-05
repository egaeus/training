package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10220
 * @problemName I Love Big Numbers !
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 20/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class UVa10220 {
	static int[] f(){
		final int MAX=1001;int[] res=new int[MAX];
		BigInteger facts[]=new BigInteger[MAX];
		facts[0]=BigInteger.ONE;res[0]=1;
		for(int i=1;i<MAX;i++){
			facts[i]=BigInteger.valueOf(i).multiply(facts[i-1]);
			char[] n=facts[i].toString().toCharArray();
			for(char ch:n)res[i]+=ch-'0';
		}
		return res;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] res=f();
		for (String ln;(ln=in.readLine())!=null;)System.out.println(res[parseInt(ln.trim())]);
	}
}
