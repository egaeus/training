package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3151
 * @problemName Land Division Tax
 * @judge http://livearchive.onlinejudge.org/
 * @category pd
 * @level medium
 * @date 29/08/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;
public class LAUVa3151 {
	static int[] arrC,sums,mem[];
	static int N; static double F;
	static int f(int i,int j){
		if(i==j)return 0;
		if(mem[i][j]>0)return mem[i][j];
		int min=MAX_VALUE-1000000;
		for(int k=(i+1)%N;k!=(j+1)%N;k=(k+1)%N){
			int val1,val2;
			if(k-1>=i)val1=sums[k-1]-(i>0?sums[i-1]:0);
			else val1=sums[N-1]-sums[i-1]+(k>0?sums[k-1]:0);
			if(j>=k)val2=sums[j]-(k>0?sums[k-1]:0);
			else val2=sums[N-1]-sums[k-1]+sums[j];
			min=min(min,f(i,(k+N-1)%N)+f(k,j)+max(val1,val2));
		}
		return mem[i][j]=min;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		arrC=new int[200];int []arr=new int[200];int i;sums=new int[200];
		mem=new int[200][200];
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			N=parseInt(st.nextToken());F=Double.parseDouble(st.nextToken());
			if(N==0&&F==0)break;
			st=new StringTokenizer(in.readLine());
			for(i=0;i<N;i++)sums[i]=(arr[i]=parseInt(st.nextToken())+(i>0?sums[i-1]:0));
			int min=MAX_VALUE;
			for(i=0;i<N;i++)Arrays.fill(mem[i],0);
			for(i=0;i<N;i++)
				min=min(f(i,(i+N-1)%N),min);
			System.out.printf(Locale.US,"%.2f%n",min*F);
		}
	}
}
