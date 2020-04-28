package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3882
 * @problemName And Then There Was One
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 08/08/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa3882{
	static int g(int n,int k){
		if(n==1)return 0;
		return (g(n-1,k)+k)%n;
	}
	static int f(int n,int k,int m){
		int p=g(n,k),i=m-1,j=k-1;
		for(;p!=j;i=(i+1)%n,j=(j+1)%n);
		return i+1;
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int n=parseInt(st.nextToken()),k=parseInt(st.nextToken()),m=parseInt(st.nextToken());
			if(n==0&&m==0&&k==0)break;
			System.out.println(f(n,k,m));
		}
	}
}
