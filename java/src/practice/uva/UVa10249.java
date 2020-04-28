package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict TLE
 * @problemId 10249
 * @problemName The Grand Dinner
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date Jul 24, 2013
 **/
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa10249 {
	static boolean[] visitados=new boolean[122];
	static int cola[]=new int[122];
	static int ants[]=new int[122];
	static int valor[]=new int[122];
	static int[][] r=new int[122][122];
	static int maxFlow(int[][] cap,int s,int t) {
		int flow=0;
		for(int i=0;i<cap.length;i++)
			for(int j=0;j<cap.length;j++)
				r[i][j]=0;
		for(int f;(f=maxFlow(cap, s, t, r))>0;flow+=f);
		return flow;
	}
	static int maxFlow(int[][] cap,int s,int t,int[][] r) {
		Arrays.fill(visitados, 0, cap.length, false);
		Arrays.fill(ants, 0, cap.length, -1);
		Arrays.fill(valor, 0, cap.length, 0);
		int p=0,c=0;
		cola[c++]=s;
		visitados[s]=true;
		valor[s]=10000;
		for(;p<c;) {
			int u=cola[p++];
			for(int i=0;i<cap.length;i++)
				if(!visitados[i]&&cap[u][i]-r[u][i]>0) {
					cola[c++]=i;
					visitados[i]=true;
					ants[i]=u;
					valor[i]=min(valor[u],cap[u][i]-r[u][i]);
					if(i==t){
						p=c+1;
						break;
					}
				}
		}
		if(ants[t]>=0) {
			int f=valor[t];
			for(;ants[t]>-1;t=ants[t]) {
				r[ants[t]][t]+=f;
				r[t][ants[t]]-=f;
			}
			return f;
		}
		return 0;
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;) {
			int M=parseInt(st.nextToken()),N=parseInt(st.nextToken());
			if(M==0&&N==0)break;
			int[][] cap=new int[M+N+2][M+N+2];
			int[] teams=new int[M];
			int[] tables=new int[N];
			int cant=0;
			st=new StringTokenizer(in.readLine());
			for(int i=0;i<M;i++) {
				teams[i]=parseInt(st.nextToken());
				cant+=teams[i];
			}
			st=new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++)
				tables[i]=parseInt(st.nextToken());
			for(int i=0;i<M;i++) {
				cap[M+N][i]=teams[i];
				for(int j=0;j<N;j++)
					cap[i][j+M]=1;
			}
			for(int i=0;i<N;i++)
				cap[M+i][M+N+1]=tables[i];
			int maxFlow=maxFlow(cap, N+M, N+M+1);
			if(maxFlow==cant){
				for(int i=0;i<M;i++) {
					for(int j=0,c=0;j<N;j++)
						if(r[i][j+M]>0) {
							sb.append(c>0?" ":"").append(j+1);
							c++;
						}
					sb.append("\n");
				}
				
			} else sb.append("0\n");
		}
		System.out.print(new String(sb));
	}
}
