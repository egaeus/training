package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 567
 * @problemName Risk
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 22/03/2012
 **/
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa567{
	static void lectura(StringTokenizer st,int[][] mAdy,int d){
		for(int i=0,j,N=parseInt(st.nextToken());i<N;i++)
			mAdy[d][j=(parseInt(st.nextToken())-1)]=mAdy[j][d]=min(1,mAdy[j][d]);
	}
	static int[][] floydWarshall(int[][] mAdy){
		int n,res[][]=new int[n=mAdy.length][n];
		for(int i=0;i<n;i++)for(int j=0;j<n;j++)res[i][j]=mAdy[i][j];
		for(int k=0;k<n;k++)
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					res[i][j]=min(res[i][j],res[i][k]+res[k][j]);
		return res;
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();int caso=1;
		for(String ln;(ln=in.readLine())!=null;caso++){
			sb.append("Test Set #"+caso+"\n");
			int[][] mAdy=new int[20][20];
			for(int i=0;i<20;i++){Arrays.fill(mAdy[i],1000);mAdy[i][i]=0;}
			StringTokenizer st=new StringTokenizer(ln);
			lectura(st,mAdy,0);
			for(int i=1;i<19;i++){
				st=new StringTokenizer(in.readLine());
				lectura(st,mAdy,i);
			}
			int r[][]=floydWarshall(mAdy),N=parseInt(in.readLine().trim());
			for(int i=0;i<N;i++){
				st=new StringTokenizer(in.readLine());
				int d=parseInt(st.nextToken()),h=parseInt(st.nextToken()),c=r[d-1][h-1];
				String D[]=new String[]{d+"",h+""};
				for(int k=0;k<2;k++)for(;D[k].length()<2;D[k]=" "+D[k]);
				sb.append(D[0]+" to "+D[1]+": "+c+"\n");
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
