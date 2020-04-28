package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10427
 * @problemName Naughty Sleepy Boys
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Jun 17, 2013
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class UVa10427 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cant=0,i=1,size=1,pot=10;
		int[] pos=new int[13888889];
		for(;cant<=100000000;i++) {
			if(i==pot) {
				pot*=10;
				size++;
			}
			pos[i]=cant+=size;
		}
		for (String ln;(ln=in.readLine())!=null;) {
			int N=parseInt(ln.trim());
			int bs=Arrays.binarySearch(pos, N);
			if(bs<0)bs=abs(bs)-1;
			String b=bs+"";
			sb.append(b.charAt(b.length()-pos[bs]+N-1)).append("\n");
		}
		System.out.print(new String(sb));
	}
}
