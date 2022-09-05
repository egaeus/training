package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 572
 * @problemName Oil Deposits
 * @judge http://uva.onlinejudge.org/
 * @category flood fill
 * @level easy
 * @date 13/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class UVa572 {
	static int[] vec=new int[]{0,-1,1};
	static int floodFill(char[][] mat){
		int m,n,r=0,i,j;boolean v[][]=new boolean[m=mat.length][n=mat[0].length];
		for(i=0;i<m;i++)for(j=0;j<n;j++)if(!v[i][j]&&mat[i][j]=='@'){floodFill(mat,i,j,v);r++;}
		return r;
	}
	static void floodFill(char[][] mat,int I,int J,boolean[][] v){
		LinkedList<int[]> cola=new LinkedList<int[]>();v[I][J]=true;
		cola.add(new int[]{I,J});
		for(int i,j,h,k,m=mat.length,n=mat[0].length;!cola.isEmpty();){
			i=cola.getFirst()[0];j=cola.pollFirst()[1];
			for(h=0;h<3;h++)for(k=0;k<3;k++)
				if(i+vec[h]>=0&&i+vec[h]<m&&j+vec[k]>=0&&j+vec[k]<n&&mat[i+vec[h]][j+vec[k]]=='@'&&!v[i+vec[h]][j+vec[k]]){
					v[i+vec[h]][j+vec[k]]=true;
					cola.add(new int[]{i+vec[h],j+vec[k]});
				}
		}
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int M=parseInt(st.nextToken());
			if(M==0)break;
			int N=parseInt(st.nextToken());
			char[][] mat=new char[M][];
			for(int i=0;i<M;i++)mat[i]=in.readLine().trim().toCharArray();
			System.out.println(floodFill(mat));
		}
	}
}
