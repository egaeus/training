package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 4776
 * @problemName This Can't Go On Forever
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 21/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa4776 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			int a=0,b=1,s=0;
			for(int c;s==0||a!=0||b!=1;s++){
				c=(a+b)%N;
				a=b;b=c;
			}
			System.out.println(N+" "+s);
		}
	}
}
