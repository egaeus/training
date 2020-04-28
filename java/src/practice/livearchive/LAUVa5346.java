package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 5346
 * @problemName Big Mod
 * @judge http://livearchive.onlinejudge.org/
 * @category math
 * @level easy
 * @date 24/11/2011
 **/
import java.util.Scanner;
public class LAUVa5346 {
	static int M,B;
	static long f(int P){
		if(P==0)return 1;
		long s=f(P/2);
		if(P%2==0)return ((s%M)*(s%M))%M;
		return ((((s%M)*(s%M))%M)*(B%M))%M;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(;sc.hasNextInt();){
			B=sc.nextInt();int P=sc.nextInt();M=sc.nextInt();
			System.out.println(f(P));
		}
	}
}
