package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10193
 * @problemName All You Need Is Love
 * @judge http://uva.onlinejudge.org/
 * @category numbers theory
 * @level easy
 * @date 5/01/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10193 {
	static int mcd(int a,int b){
		if(b==0)return a;
		return mcd(b,a%b);
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int c=0,C=parseInt(in.readLine().trim());c++<C;) 
			System.out.println("Pair #"+c+": "+(mcd(parseInt(in.readLine().trim(),2),parseInt(in.readLine().trim(),2))>1?"All you need is love!":"Love is not all you need!"));
	}
}
