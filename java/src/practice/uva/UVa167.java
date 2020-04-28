package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 167
 * @problemName The Sultan's Successors
 * @judge http://uva.onlinejudge.org/
 * @category backtracking
 * @level easy
 * @date 21/12/2011
 **/
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;

import java.util.Scanner;
public class UVa167 {
	static boolean sePuede(boolean [][]mat,int I,int J){
		for(int i=1;i<=I;i++){
			if(mat[I-i][J])return false;
			if(J-i>=0&&mat[I-i][J-i])return false;
			if(J+i<8&&mat[I-i][J+i])return false;
		}
		return true;
	}
	static int f(boolean[][] mat, int f){
		if(f==8)return 0;
		int max=MIN_VALUE+1000000;
		for(int i=0;i<8;i++)
			if(sePuede(mat,f,i)){
				mat[f][i]=true;
				max=max(max,f(mat,f+1)+tab[f][i]);
				mat[f][i]=false;
			}
		return max;
	}
	static int[][] tab;
	public static void main(String args[]) throws Throwable {
		Scanner sc=new Scanner(System.in);
		for (int c=0,C=sc.nextInt();c++<C;) {
			tab=new int[8][8];
			for(int i=0;i<8;i++)for(int j=0;j<8;j++)tab[i][j]=sc.nextInt();
			int sol=f(new boolean[8][8],0);
			for(int i=(sol+"").length();i<5;i++)System.out.print(" ");
			System.out.println(sol);
		}
	}
}
