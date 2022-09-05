package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId COINS
 * @problemName Bytelandian gold coins
 * @judge http://www.spoj.pl
 * @category memoization
 * @level easy
 * @date 27/07/2012
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class SPOJCOINS{
	static long[] mem=new long[2000000];
	static long f(int n){
		if(n==0)return n;
		if(n<mem.length&&mem[n]>-1)return mem[n];
		return n<mem.length?mem[n]=max(n,f(n/2)+f(n/3)+f(n/4)):max(n,f(n/2)+f(n/3)+f(n/4));
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		Arrays.fill(mem,-1);
		for(String ln;(ln=in.readLine())!=null;)
			System.out.println(f(parseInt(ln.trim())));
	}
}
