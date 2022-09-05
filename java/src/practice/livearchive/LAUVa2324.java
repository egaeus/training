package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 2324
 * @problemName Human Gene Functions
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 18/04/2012
 **/
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class LAUVa2324{
	static char[] a,b;
	static int[][] mat=new int[][]{{5,-1,-2,-1,-3},{-1,5,-3,-2,-4},{-2,-3,5,-2,-2},{-1,-2,-2,5,-1},{-3,-4,-2,-1}};
	static int[][] mem;
	static int getPos(char x){
		if(x=='A')return 0;
		if(x=='C')return 1;
		if(x=='G')return 2;
		if(x=='T')return 3;
		return 4;
	}
	static int getVal(char x,char y){
		return mat[getPos(x)][getPos(y)];
	}
	static int f(int I,int J){
		if(mem[I][J]!=MIN_VALUE)return mem[I][J];
		if(I==a.length){
			int sol=0;
			for(int i=J;i<b.length;i++)sol+=getVal(' ',b[i]);
			return mem[I][J]=sol;
		}
		if(J==b.length){
			int sol=0;
			for(int i=I;i<a.length;i++)sol+=getVal(a[i],' ');
			return mem[I][J]=sol;
		}
		return mem[I][J]=max(max(f(I+1,J+1)+getVal(a[I],b[J]),f(I+1,J)+getVal(a[I],' ')),f(I,J+1)+getVal(' ',b[J]));
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int c=0,C=parseInt(in.readLine().trim());c++<C;){
			StringTokenizer st=new StringTokenizer(in.readLine());
			st.nextToken();a=st.nextToken().toCharArray();
			st=new StringTokenizer(in.readLine());
			st.nextToken();b=st.nextToken().toCharArray();
			mem=new int[a.length+1][b.length+1];
			for(int[] m:mem)Arrays.fill(m,MIN_VALUE);
			System.out.println(f(0,0));
		}
	}
}
