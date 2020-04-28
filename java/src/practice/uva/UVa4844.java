package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 4844
 * @problemName String Popping
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date Jun 7, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa4844 {
	static char[] arr;
	static int[][][] mem;
	static boolean isAll(int i,int j,char a) {
		for(int k=i;k<=j;k++)
			if(arr[k]!=a)return false;
		return true;
	}
	static boolean f(int i,int j,int l) {
		if(l==0){
			if(i==j)return false;
			if(i>j)return true;
			if(isAll(i,j,'a')||isAll(i,j,'b'))return true;
		}
		if(l!=0&&isAll(i,j,l==1?'a':'b'))return true;
		if(mem[i][j][l]!=0)return mem[i][j][l]==1;
		boolean ws=false;
		for(int k=i;k<j&&!ws;k++) {
			if(l==0)ws=(f(i,k,0)&&f(k+1,j,0))||(f(i,k,1)&&f(k+1,j,1))||(f(i,k,2)&&f(k+1,j,2));
			else ws=(f(i,k,l)&&(f(k+1,j,0)||f(k+1,j,l)))||(f(k+1,j,l)&&(f(i,k,0)||f(i,k,l)));
		}
		mem[i][j][l]=ws?1:2;
		return ws;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t=0,T=parseInt(in.readLine().trim());t++<T;) {
			arr=in.readLine().trim().toCharArray();
			mem=new int[arr.length][arr.length][3];
			sb.append(f(0,arr.length-1,0)?"1":"0").append("\n");
		}
		System.out.print(new String(sb));
	}
}
