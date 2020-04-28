package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 556
 * @problemName Amazing
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Jun 4, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa556 {
	public static void main(String args[]) throws Throwable {
		int[] direccion[]=new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
		int[] siguiente[]= new int[][]{{1,1},{-1,1},{-1,-1},{1,-1}};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;) {
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());
			if(N==0&&M==0)break;
			char[][] mat=new char[N+2][M+2];
			for(int i=0;i<N+2;i++)mat[i][0]=mat[i][M+1]='1';
			for(int i=0;i<M+2;i++)mat[0][i]=mat[N+1][i]='1';
			for(int i=0;i<N;i++) {
				char[] ln=in.readLine().trim().toCharArray();
				for(int j=0;j<M;j++)
					mat[i+1][j+1]=ln[j];
			}
			int[] p=new int[]{N,1,0};
			int[][] cant=new int[N+2][M+2];
			for(;p[0]+direccion[p[2]][0]!=N||p[1]+direccion[p[2]][1]!=1;) {
				if(mat[p[0]+direccion[p[2]][0]][p[1]+direccion[p[2]][1]]=='1')
					p[2]=(p[2]+1)%direccion.length;
				else {
					if(mat[p[0]+siguiente[p[2]][0]][p[1]+siguiente[p[2]][1]]=='1') {
						cant[p[0]][p[1]]++;
						p[0]+=direccion[p[2]][0];
						p[1]+=direccion[p[2]][1];
					}
					else {
						cant[p[0]][p[1]]++;
						cant[p[0]+direccion[p[2]][0]][p[1]+direccion[p[2]][1]]++;
						p[0]+=siguiente[p[2]][0];
						p[1]+=siguiente[p[2]][1];
						p[2]=(p[2]+direccion.length-1)%direccion.length;
					}
				}
			}
			cant[p[0]][p[1]]++;
			int[] sol=new int[5];
			for(int i=0;i<N+2;i++)
				for(int j=0;j<M+2;j++)
					if(mat[i][j]=='0'&&cant[i][j]<5)
						sol[cant[i][j]]++;
			for(int i=0;i<sol.length;i++)
				sb.append(llenar(sol[i]+""));
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
	static String llenar(String s) {
		for(;s.length()<3;s=" "+s);
		return s;
	}
}
