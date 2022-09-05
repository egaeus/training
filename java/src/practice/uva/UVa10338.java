package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10338
 * @problemName Mischievous Children
 * @judge http://uva.onlinejudge.org/
 * @category permutations
 * @level easy
 * @date 3/01/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class UVa10338 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BigInteger[] fact=new BigInteger[21];
		fact[0]=BigInteger.ONE;
		for(int i=1;i<21;i++)fact[i]=BigInteger.valueOf(i).multiply(fact[i-1]);
		for(int c=0,C=parseInt(in.readLine().trim());c++<C;) {
			char[] str=in.readLine().trim().toCharArray();
			int[] p=new int[26];
			for(int i=0;i<str.length;i++)p[str[i]-'A']++;
			BigInteger div=BigInteger.ONE;
			for(int i=0;i<26;i++)div=div.multiply(fact[p[i]]);
			System.out.println("Data set "+c+": "+fact[str.length].divide(div));
		}
	}
}
