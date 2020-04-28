package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 6163
 * @problemName  Myth Busters
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Jul 15, 2013
 **/
import static java.lang.Integer.bitCount;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa6163 {
	static boolean f(int[] arr) {
		if(arr.length==1)return arr[0]==10;
		for(int i=0;i<arr.length-1;i++) {
			int[] s=new int[arr.length-1];
			for(int k=0;k<i;k++)s[k]=arr[k];
			for(int k=i+2;k<arr.length;k++)s[k-1]=arr[k];
			for(int k=0;k<4;k++)
				if(k!=3||arr[i+1]!=0) {
					s[i]=operar(arr[i],arr[i+1],k);
					if(f(s))return true;
				}
		}
		return false;
	}
	static int operar(int a,int b,int op) {
		if(op==0)return a+b;
		if(op==1)return a-b;
		if(op==2)return a*b;
		return a/b;
	}
	static int[] nums;
	static boolean sePuede(int c,int[] pos) {
		if(c==(1<<nums.length)-1) {
			int[] arr=new int[nums.length];
			for(int i=0;i<nums.length;i++)
				arr[i]=nums[pos[i]];
			return f(arr);
		}
		for(int i=0;i<nums.length;i++)
			if(((1<<i)&c)==0) {
				pos[bitCount(c)]=i;
				if(sePuede(c|(1<<i), pos))return true;
			}
		return false;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] sol=new boolean[10000];
		nums=new int[4];
		for(int i=0;i<sol.length;i++) {
			for(int k=0,h=i;k<4;k++,h/=10)
				nums[k]=h%10;
			sol[i]=sePuede(0,new int[4]);
		}
		for (int N;(N=parseInt(in.readLine().trim()))!=0;) {
			boolean ws=true;
			for(int i=0;i<N;i++)
				ws&=sol[parseInt(in.readLine().trim())];
			sb.append(ws?"TRUE":"BUSTED").append("\n");
		}
		System.out.print(new String(sb));
	}
}
