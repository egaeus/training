package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict dp
 * @problemId 2451
 * @problemName Brackets sequence
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 17/04/2012
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa2451{
	static char[] str;
	static int[][][] mem;
	static int f(int i,int s){
		if(i>s)return 0;
		if(mem[i][s]!=null)return mem[i][s][0];
		if(str[i]==')'||str[i]==']'){
			mem[i][s]=new int[]{f(i+1,s)+1,1};
			return mem[i][s][0];
		}
		if(str[s]=='('||str[s]=='['){
			mem[i][s]=new int[]{f(i,s-1)+1,2};
			return mem[i][s][0];
		}
		int min=MAX_VALUE-1000000,p=-1;
		if(((str[i]=='('&&str[s]==')')||(str[i]=='['&&str[s]==']'))&&min>f(i+1,s-1)){min=f(i+1,s-1);p=3;}
		if((str[i]=='('||str[i]=='[')&&min>f(i+1,s)+1){min=f(i+1,s)+1;p=4;}
		if((str[s]==')'||str[s]==']')&&min>f(i,s-1)+1){min=f(i,s-1)+1;p=5;}
		for(int I=i+1;I<s;I++)
			if(min>f(i,I)+f(I+1,s)){
				min=f(i,I)+f(I+1,s);
				p=-I;
			}		
		mem[i][s]=new int[]{min,p};
		return min;
	}
	static String sol(int i,int s){
		if(i>s)return "";
		if(mem[i][s][1]==1)return (str[i]==')'?"()":"[]")+sol(i+1,s);
		if(mem[i][s][1]==2)return sol(i,s-1)+(str[s]=='('?"()":"[]");
		if(mem[i][s][1]==3)return str[i]+sol(i+1,s-1)+str[s];
		if(mem[i][s][1]==4)return str[i]+sol(i+1,s)+(str[i]=='('?")":"]");
		if(mem[i][s][1]==5)return (str[s]==')'?"(":"[")+sol(i,s-1)+str[s];
		return sol(i,-mem[i][s][1])+sol(-mem[i][s][1]+1,s);
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int t=0,T=parseInt(in.readLine().trim());t<T;t++){
			in.readLine();
			if(t>0)sb.append("\n");
			str=in.readLine().trim().toCharArray();
			mem=new int[str.length][str.length][];
			f(0,str.length-1);
			sb.append(sol(0,str.length-1)+"\n");
		}
		System.out.print(new String(sb));
	}
}
