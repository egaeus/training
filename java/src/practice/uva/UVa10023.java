package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict T.L.E.
 * @problemId 10023
 * @problemName Square root
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level ?
 * @date 04/01/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class UVa10023 {
	static BigInteger sqrtBinarySearch(BigInteger n){
		BigInteger cotaSup = n, cotaInf = BigInteger.ZERO;
		while(true){
			BigInteger p = cotaSup.add(cotaInf).divide(BigInteger.valueOf(2));
			int pTemp = p.multiply(p).compareTo(n);
			if(pTemp==0)break;
			if(pTemp>0)cotaSup = p.subtract(BigInteger.ONE);
			if(pTemp<0)cotaInf = p.add(BigInteger.ONE);
		}
		return cotaSup.add(cotaInf).divide(BigInteger.valueOf(2));
	}
	public static void main(String[] args) throws Throwable{
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = Integer.parseInt(in.readLine().trim()); c < C; c++){
			in.readLine();
			BigInteger a = new BigInteger(in.readLine().trim());
			long t = System.currentTimeMillis();
			sb.append(sqrtBinarySearch(a) + ": " + (System.currentTimeMillis() - t) + "\n");
			if(c<C-1)sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
