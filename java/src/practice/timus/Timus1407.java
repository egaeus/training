package practice.timus; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict No enviado
 * @problemId 1407
 * @problemName One-two, One-two
 * @judge http://acm.timus.ru/
 * @category adhoc
 * @level easy
 * @date 03/08/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class Timus1407{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BigInteger sol[]=new BigInteger[101];
		sol[1]=BigInteger.valueOf(2);
		for(int i=2;i<sol.length;i++)
			if(new BigInteger("1"+sol[i-1]).mod(BigInteger.valueOf(2).pow(i)).equals(BigInteger.ZERO))
				sol[i]=new BigInteger("1"+sol[i-1]);
			else sol[i]=new BigInteger("2"+sol[i-1]);
		System.out.println(sol[parseInt(in.readLine().trim())]);
	}
}
