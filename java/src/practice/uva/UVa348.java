package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict No enviado
 * @problemId 348
 * @problemName Optimal Array Multiplication Sequence
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 8/03/2012
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa348{
	static int[][] mat;
	static int[][][] mem;
	static int f(int i,int j){
		if(i==j)return 0;
		if(mem[i][j][0]>0)return mem[i][j][0];
		int min=MAX_VALUE,p=-1;
		for(int k=i;k<j;k++){
			if(min>f(i,k)+f(k+1,j)+mat[i][0]*mat[j][1]*mat[k][1]){
				min=f(i,k)+f(k+1,j)+mat[i][0]*mat[j][1]*mat[k][1];
				p=k;
			}
		}
		mem[i][j][0]=min;
		mem[i][j][1]=p;
		return min; 
	}
	static String resultado(int i,int j){
		if(i==j)return "A"+(i+1);
		return "("+resultado(i,mem[i][j][1])+" x "+resultado(mem[i][j][1]+1,j)+")";
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		mem=new int[10][10][2];
		for(int N,c=1;(N=parseInt(in.readLine().trim()))!=0;c++){
			for(int i=0;i<10;i++)for(int j=0;j<10;j++)Arrays.fill(mem[i][j],0);
			mat=new int[N][];
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				mat[i]=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken())};
			}
			f(0,N-1);
			sb.append("Case "+c+": "+resultado(0,N-1)+"\n");
		}
		System.out.print(new String(sb));
	}
}
