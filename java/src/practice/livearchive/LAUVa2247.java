package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2247
 * @problemName Prime Digital Roots
 * @judge http://livearchive.onlinejudge.org/
 * @category math
 * @level easy
 * @date 17/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa2247 {
	static boolean[] primos=new boolean[1000000];
	static int[] mem=new int[1000000];
	static int f(int n){
		if(mem[n]!=0)return mem[n];
		if(!primos[n])return mem[n]=n;
		if(n<10)return mem[n]=-1;
		int s=0;
		for(;n>0;n/=10)s+=n%10;
		return mem[n]=f(s);
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		primos[0]=primos[1]=true;
		for(int i=0;i<primos.length;i++)if(!primos[i])for(int j=i+i;j<primos.length;j+=i)primos[j]=true;
		StringBuilder sb=new StringBuilder();
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			for(int i=(N+"").length();i<7;i++)sb.append(" ");
			sb.append(N);int r=f(N);String res=r==-1?"none":r+"";
			for(int i=res.length();i<8;i++)sb.append(" ");
			sb.append(res+"\n");
		}
		System.out.print(new String(sb));
	}
}
