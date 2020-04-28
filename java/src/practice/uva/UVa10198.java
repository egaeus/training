package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10198
 * @problemName Counting
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 13/04/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class UVa10198{
	static BigInteger mem[];
	static BigInteger f(int n){
		if(n==0)return BigInteger.ONE;
		if(n<0)return BigInteger.ZERO;
		if(mem[n]!=null)return mem[n];
		return mem[n]=f(n-1).add(f(n-1)).add(f(n-2)).add(f(n-3));
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		mem=new BigInteger[1001];
		for(String ln;(ln=in.readLine())!=null;)System.out.println(f(parseInt(ln.trim())));
	}
}
