package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 6169
 * @problemName Class Packing
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Jul 10, 2013
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class LAUVa6169 {
	static int[] size=new int[]{20,20,20,25,25,30,30},arr,mem[];
	static int f(int p,int ll) {
		if(p==size.length)
			return ll/size[p-1]+min(ll%size[p-1],1);
		if(mem[ll][p]>=0)return mem[ll][p];
		int min=1000000,div=min(size[p],p>0?size[p-1]:MAX_VALUE);
		for(int i=0;i<=arr[p];i++) 
			min=min(min,f(p+1,arr[p]-i)+(ll+i)/div+min((ll+i)%div,1));
		return mem[ll][p]=min;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		mem=new int[1401][7];
		for (StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;) {
			arr=new int[7];
			int s=0;
			for(int i=0;i<arr.length;i++)s+=(arr[i]=parseInt(st.nextToken()));
			if(s==0)break;
			for(int[] m:mem)Arrays.fill(m, -1);
			System.out.println(f(0,0));
		}
		System.out.print(new String(sb));
	}
}
