package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 5737
 * @problemName Pills
 * @judge http://livearchive.onlinejudge.org/
 * @category dp
 * @level easy
 * @date Aug 21, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa5737 {
	static long[][] mem=new long[31][62];
	static long f(int w,int h) {
		if(w==0&&h==0)return 1;
		if(mem[w][h]>0)return mem[w][h];
		long s=0;
		if(h>0)s+=f(w,h-1);
		if(w>0)s+=f(w-1,h+1);
		return mem[w][h]=s;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long[] sol=new long[31];
		for(int i=1;i<=30;i++)
			sol[i]=f(i-1,1);
		for (int N;(N=parseInt(in.readLine().trim()))!=0;) 
			sb.append(sol[N]).append("\n");
		System.out.print(new String(sb));
	}
}
