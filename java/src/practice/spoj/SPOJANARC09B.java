package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId ANARC09B
 * @problemName Tiles of Tetris, Not!
 * @judge http://www.spoj.pl
 * @category numbers theory
 * @level easy
 * @date 22/03/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SPOJANARC09B {
	static long mcd(long a, long b){
		for(long t;b!=0;t=a%b,a=b,b=t);
		return a;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine())!=null;){
			StringTokenizer st = new StringTokenizer(ln);
			long N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
			if(N==0&&M==0)break;
			long mcd = mcd(N, M);
			System.out.println((N/mcd)*(M/mcd));
		}
	}
}
