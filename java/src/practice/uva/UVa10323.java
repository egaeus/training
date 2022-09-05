package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10323
 * @problemName Factorial! You Must be Kidding!!!
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level medium
 * @date 21/12/2011
 **/
import java.util.Scanner;
public class UVa10323 {
	//fact(n)=fact(n-1)*n -> fact(n-1)=fact(n)/n -> fact(-1)=1/0=Infinity -> fact(-2)=-Infinity ...
	public static void main(String args[]) throws Throwable {
		Scanner sc=new Scanner(System.in);
		long[] facts=new long[14];facts[0]=1;
		for(int i=1;facts[i-1]<6227020800L;i++)
			facts[i]=facts[i-1]*i;
		for (;sc.hasNextLong();) {
			long  n=sc.nextLong();
			if(n>=facts.length)System.out.println("Overflow!");
			else if(n>0)
				if(facts[(int)n]<10000)System.out.println("Underflow!");
				else System.out.println(facts[(int)n]);
			else if(n%2==0)System.out.println("Underflow!");
			else System.out.println("Overflow!");
		}
	}
}
