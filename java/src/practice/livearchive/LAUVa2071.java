package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2071
 * @problemName Safe Packing
 * @judge http://livearchive.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 03/08/2011
 **/
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class LAUVa2071 {
	static int[] fib,arr;static int W,F,S;
	public static void main(String[] args) throws Throwable{
		fib=new int[41];fib[1]=1;
		for(int i=2;fib[i-1]<100000000;fib[i]=fib[i-1]+fib[i-2],i++);
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			W=parseInt(st.nextToken());F=parseInt(st.nextToken());S=parseInt(st.nextToken());
			if(W==0&&F==0&&S==0)break;
			arr=new int[W];
			st=new StringTokenizer(in.readLine());
			for(int i=0;i<W;i++)arr[i]=parseInt(st.nextToken());
			int mem[]=new int[F+1],max=0;
			Arrays.fill(mem, MIN_VALUE);
			mem[0]=0;
			for(int i=0;i<W;i++){
				int val=0,bs=Arrays.binarySearch(fib, arr[i]);
				if(bs<0)val=fib[abs(bs)-1]-arr[i];
				for(int j=F-val;j>=0;j--)if(mem[j]>=0)max=max(max,mem[j+val]=max(mem[j+val],mem[j]+1));
			}
			System.out.println(max);
		}
	}
}
