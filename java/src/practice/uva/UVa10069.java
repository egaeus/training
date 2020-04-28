package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10069
 * @problemName Distinct Subsequences
 * @judge http://uva.onlinejudge.org/
 * @category pd
 * @level easy
 * @date 18/03/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class UVa10069 {
	static char[] X, Z;
	static BigInteger[][] mem;
	static BigInteger function(int pos1, int pos2){
		if(pos2==Z.length)return BigInteger.ONE;
		if(pos1==X.length)return BigInteger.ZERO;
		if(mem[pos1][pos2]!=null)return mem[pos1][pos2];
		BigInteger res = function(pos1+1, pos2);
		if(X[pos1]==Z[pos2])res=res.add(function(pos1+1, pos2+1));
		return mem[pos1][pos2] = res;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = parseInt(in.readLine().trim()); c++ < C; ){
			X = in.readLine().trim().toCharArray();
			Z = in.readLine().trim().toCharArray();
			mem = new BigInteger[X.length][Z.length];
			System.out.println(function(0,0));
		}
	}
}
