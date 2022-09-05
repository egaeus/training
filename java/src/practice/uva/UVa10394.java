package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10394
 * @problemName Twin Primes
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 15/03/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10394{
	public static void main(String args[]) throws Throwable{
		boolean primos[]=new boolean[20000000];
		primos[0]=primos[1]=true;
		int MAX,sol[]=new int[MAX=100000];
		for(int i=0,c=0;c<MAX;i++)
			if(!primos[i]){
				if(!primos[i-2])sol[c++]=i;
				for(int j=i+i;j<20000000;j+=i)primos[j]=true;
			}
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;){
			int N=parseInt(ln.trim())-1;
			sb.append("("+(sol[N]-2)+", "+sol[N]+")\n");
		}
		System.out.print(new String(sb));
	}
}
