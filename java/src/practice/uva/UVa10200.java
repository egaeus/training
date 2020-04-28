package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10200
 * @problemName Prime Time
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Jun 18, 2013
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa10200 {
	static int MAX=10000000,MAX_PRIMES=1230;
	static boolean[] primes=new boolean[MAX];
	static int[] lstPrimes=new int[MAX_PRIMES];
	static boolean isPrime(int n) {
		if(n<MAX)return !primes[n];
		for(int i=0;lstPrimes[i]<sqrt(n)+1;i++)
			if(n%lstPrimes[i]==0)
				return false;
		return true;
	}
	public static void main(String args[]) throws Throwable {
		primes[0]=primes[1]=true;
		for(int i=0,c=0;i<MAX;i++)
			if(!primes[i]) {
				if(c<MAX_PRIMES)
					lstPrimes[c++]=i;
				for(int j=i+i;j<MAX;j+=i)
					primes[j]=true;
			}
		int MAX_SOL=10001;
		int[] euler=new int[MAX_SOL];
		for(int i=0;i<MAX_SOL;i++)
			euler[i]=(isPrime(i*i+i+41)?1:0)+(i>0?euler[i-1]:0);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln;(ln=in.readLine())!=null;) {
			StringTokenizer st=new StringTokenizer(ln);
			int A=parseInt(st.nextToken()),B=parseInt(st.nextToken());
			System.out.printf(Locale.US,"%.2f\n",100.*(euler[B]-(A>0?euler[A-1]:0))/(B-A+1));
		}
	}
}
