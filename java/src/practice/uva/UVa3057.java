package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 3057
 * @problemName Permutation Code
 * @judge http://livearchive.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 26/07/2012
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa3057{
	static int p(char[] S,char ch){
		for(int i=0;i<S.length;i++)if(S[i]==ch)return i;
		return -1;
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int x,n,d;(x=parseInt(in.readLine().trim()))!=0;){
			char[] S=in.readLine().toCharArray(),P=in.readLine().toCharArray(),C=in.readLine().toCharArray(),M=new char[C.length];
			n=M.length;
			d=(int)(pow(n,1.5)+x)%n;
			M[d]=P[p(S,C[d])];
			for(int i=d-1;i>=0;i--)
				M[i]=P[p(S,C[i])^p(S,M[i+1])];
			for(int i=n-1;i>d;i--)
				M[i]=P[p(S,C[i])^p(S,M[(i+1)%n])];
			sb.append(new String(M)+"\n");
		}
		System.out.print(new String(sb));
	}
}
