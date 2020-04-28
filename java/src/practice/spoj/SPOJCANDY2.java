package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId CANDY2
 * @problemName Candy II
 * @judge http://www.spoj.pl
 * @category memoization
 * @level easy
 * @date 18/08/2012
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;
import static java.lang.Math.log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SPOJCANDY2{
	static int t,arr[][],s[];
	static long[][][] mem;
	static long f(int p,int h) {
		if(h==7)return 0;
		if(p==t)return MAX_VALUE;
		if(mem[p][h]!=null)return mem[p][h][0];
		long min=f(p+1,h),r=h;
		for(int i=0;i<3;i++)
			if(((1<<i)&h)==0&&min>f(p+1,h|(1<<i))+s[i]-arr[p][i]) { 
				min=f(p+1,h|(1<<i))+s[i]-arr[p][i];
				r=h|(1<<i);
			}
		mem[p][h]=new long[]{min,r};
		return min;
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;){
			t=parseInt(ln.trim());
			arr=new int[t][];s=new int[3];
			mem=new long[t][7][];
			for(int i=0;i<t;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				arr[i]=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken())};
				s[0]+=arr[i][0];s[1]+=arr[i][1];s[2]+=arr[i][2];
			}
			f(0,0);
			int[] sol=new int[3];
			for(int i=0,j=0;j<7&&i<t;j=(int)mem[i][j][1],i++)
				if(mem[i][j][1]!=j)sol[(int)(log(mem[i][j][1]^j)/log(2))]=i;
			System.out.println(sol[0]);
			System.out.println(sol[1]);
			System.out.println(sol[2]);
		}
		System.out.print(new String(sb));
	}
}
