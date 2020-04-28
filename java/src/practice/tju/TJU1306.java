package practice.tju; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 1306
 * @problemName Fire Net
 * @judge http://acm.tju.edu.cn/
 * @category backtracking
 * @level easy
 * @date 11/08/2012
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class TJU1306{
	static int f(char[][] mat,int I,int J){
		if(J==mat.length){
			I++;
			J=0;
		}
		if(I==mat.length)return 0;
		boolean ws=mat[I][J]=='.';
		for(int i=I;i>=0&&mat[i][J]!='X'&&ws;i--)ws=mat[i][J]!='o';
		for(int i=I;i<mat.length&&mat[i][J]!='X'&&ws;i++)ws=mat[i][J]!='o';
		for(int i=J;i>=0&&mat[I][i]!='X'&&ws;i--)ws=mat[I][i]!='o';
		for(int i=J;i<mat.length&&mat[I][i]!='X'&&ws;i++)ws=mat[I][i]!='o';
		int max=0;
		if(ws){
			mat[I][J]='o';
			max=f(mat,I,J+1)+1;
			mat[I][J]='.';
		}
		return max(max,f(mat,I,J+1));
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			char[][] mat=new char[N][];
			for(int i=0;i<N;i++)mat[i]=in.readLine().trim().toCharArray();
			System.out.println(f(mat,0,0));
		}
	}
}
