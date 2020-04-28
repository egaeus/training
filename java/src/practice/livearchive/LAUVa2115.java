package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2115
 * @problemName An Inductively-Defined Function
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 16/11/2011
 **/
import java.util.Scanner;
public class LAUVa2115 {
	static long f(long N){
		if(N==1)return 1;
		if(N%2==0)return N/2;
		return f(N/2)+f(N/2+1);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int N,c=0;(N=sc.nextInt())!=-1;c++)
			System.out.println((c>0?"\n":"")+"f("+N+") = "+f(N));
	}
}
