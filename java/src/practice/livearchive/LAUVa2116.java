package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2116
 * @problemName The Mobius Function
 * @judge http://livearchive.onlinejudge.org/
 * @category math
 * @level easy
 * @date 16/11/2011
 **/
import java.util.Scanner;
public class LAUVa2116 {
	static int f(int N){
		if(N==1)return 1;int c=0;
		for(int i=2,ant=1;N>1;i++)if(N%i==0){if(ant==i)return 0;N/=i;ant=i--;c++;}
		if(c%2==0)return 1;
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int N,c=0;(N=sc.nextInt())!=-1;c++)
			System.out.println((c>0?"\n":"")+"M("+N+") = "+f(N));
	}
}
