package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId BYTESM2
 * @problemName Philosophers Stone
 * @judge http://www.spoj.pl
 * @category dp
 * @level esasy
 * @date 27/07/2012
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SOPJBYTESM2{
	static class Escaner {
		BufferedReader in;
		StringTokenizer st;
		Escaner(){
			in=new BufferedReader(new InputStreamReader(System.in));
			st=new StringTokenizer("");
		}
		public int nextInt() throws Throwable {
			if(st.hasMoreTokens())return parseInt(st.nextToken());
			st=new StringTokenizer(in.readLine());
			return nextInt();
		}
	}
	public static void main(String args[]) throws Throwable{
		Escaner sc=new Escaner();
		for(int t=0,T=sc.nextInt();t++<T;){
			int H=sc.nextInt(),W=sc.nextInt();
			int[][] mat=new int[H+1][W+2];
			for(int i=1;i<mat.length;i++){
				for(int j=1;j<W+1;j++)
					mat[i][j]=max(max(mat[i-1][j-1],mat[i-1][j]),mat[i-1][j+1])+sc.nextInt();
			}
			int s=0;
			for(int i=0;i<W+2;i++)s=max(s,mat[H][i]);
			System.out.println(s);
		}
	}
}
