package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict No enviado
 * @problemId 481
 * @problemName What Goes Up
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date Nov 5, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
public class UVa481 {
	static ArrayList<Integer> list=new ArrayList<Integer>();
	static long[] lis() { 
		 int n=list.size(),res=0, i=1; long val[]=new long[n+1]; val[0]=Long.MIN_VALUE;
		 int[] inds=new int[n+1], ants=new int[n+1];
		 Arrays.fill(inds, -1);
		 inds[0]=0;
		 for (long v:list) { 
			 int j=Arrays.binarySearch(val,0,res+1,v); 
			 j=(j<0?-j-1:j)-1; 
			 ants[i]=inds[j]; 
			 if (j==res||v<val[j+1]) {
				 val[j+1]=v; 
				 res=Math.max(res,j+1);
				 inds[j+1]=i;
			} 
			i++;
		 }
		 long[] sol=new long[res];
		 for(int j=res-1,I=inds[res];j>=0;j--) {
			 sol[j]=list.get(I-1);
			 I=ants[I];
		 }
		 return sol; 
	} 
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String ln;(ln=in.readLine())!=null;) 
			list.add(parseInt(ln.trim()));
		long[] res=lis();
		sb.append(res.length).append("\n-\n");
		for(long a:res)
			sb.append(a).append("\n");
		System.out.print(new String(sb));
	}
}
