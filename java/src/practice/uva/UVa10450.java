package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10450
 * @problemName World Cup Noise
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 5/01/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10450 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long[] f=new long[52];f[0]=1;f[1]=2;
		for(int i=2;i<f.length;i++)f[i]=f[i-1]+f[i-2];
		for (int c=0,C=parseInt(in.readLine().trim());c++<C;) 
			System.out.println("Scenario #"+c+":\n"+f[parseInt(in.readLine().trim())]+"\n");
	}
}
