package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 5691
 * @problemName Oil Skimming
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level easy
 * @date Jul 24, 2013
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class LAUVa5691 {
	static int[] cola=new int[1500];
	static int maxFlow(int[][] cap,int v,int t) {
		int[][] r=new int[cap.length][cap.length];
		int f=0;
		for(int flow;(flow=maxFlow(cap, r, v, t))!=0;f+=flow);
		return f;
	}
	static int maxFlow(int[][] cap,int[][] r,int v,int t) {
		boolean[] vis=new boolean[cap.length];
		int[] ant=new int[cap.length];
		int[] val=new int[cap.length];
		int p=0,c=0;
		val[v]=MAX_VALUE;
		vis[v]=true;
		cola[c++]=v;
		Arrays.fill(ant, -1);
		for(;p<c;) {
			int u=cola[p++];
			for(int i=0;i<cap.length;i++)
				if(!vis[i]&&cap[u][i]-r[u][i]>0) {
					cola[c++]=i;
					val[i]=min(val[u],cap[u][i]-r[u][i]);
					ant[i]=u;
					if(i==t){p=c;break;}
				}
		}
		int f=val[t];
		if(val[t]>0) {
			for(;ant[t]!=-1;t=ant[t]) {
				r[ant[t]][t]+=f;
				r[t][ant[t]]-=f;
			}
		}
		return f;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int N=parseInt(in.readLine().trim()),n=0;n++<N;) {
			int C=parseInt(in.readLine().trim());
			char[][] mat=new char[C][];
			for(int i=0;i<C;i++)
				mat[i]=in.readLine().trim().toCharArray();
			int[][] cap=new int[2*C+2][2*C+2];
			for(int i=0;i<C;i++)
				for(int j=0;j<C;j++)
					if(mat[i][j]=='#')
						for(int k=-1;k<2;k+=2) {
							if(k+i>=0&&k+i<C&&mat[i+k][j]=='#')cap[i*C+j][(i+k)*C+j]=1;
							if(k+j>=0&&k+j<C&&mat[i][j+k]=='#')cap[i*C+j][i*C+j+k]=1;
						}
			for(int i=0;i<C;i++) {
				cap[2*C][i]=1;
				cap[C+i][2*C+1]=1;
			}
			System.out.println(maxFlow(cap, 2*C, 2*C+1));
		}
		System.out.print(new String(sb));
	}
}
