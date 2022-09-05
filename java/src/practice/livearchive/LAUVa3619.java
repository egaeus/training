package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 3619
 * @problemName Sum of Different Primes
 * @judge http://livearchive.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 25/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class LAUVa3619 {
	static int[] primos;
	static int[][][] mem;
	static int f(int k,int i,int j){
		if(k==0&&j==0)return 1;
		if(k<0)return 0;
		if(i<0)return 0;
		if(j<=0)return 0;
		if(mem[k][i][j]>-1)return mem[k][i][j];
		return mem[k][i][j]=f(k-primos[i],i-1,j-1)+f(k,i-1,j);
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in)); 
		boolean[] p=new boolean[1120];primos=new int[187];
		p[0]=p[1]=true;int c=0;mem=new int[1121][187][15];
		for(int [][]m:mem)for(int []r:m)Arrays.fill(r,-1);
		for(int i=0;i<p.length;i++)if(!p[i]){primos[c++]=i;for(int j=2*i;j<p.length;j+=i)p[j]=true;}
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int K=parseInt(st.nextToken()),J=parseInt(st.nextToken());
			if(K==0&&J==0)break;
			System.out.println(f(K,186,J));
		}
	}
}
