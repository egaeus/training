package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2158
 * @problemName Factorial
 * @judge http://livearchive.onlinejudge.org/
 * @category math
 * @level easy
 * @date 16/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa2158 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int c=0,C=parseInt(in.readLine().trim());c++<C;){
			int n=parseInt(in.readLine().trim());
			long s=0;for(;n>0;s+=n/5,n/=5);
			System.out.println(s);
		}
	}
}
