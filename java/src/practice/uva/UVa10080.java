package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10080
 * @problemName Gopher II
 * @judge http://uva.onlinejudge.org/
 * @category max-flow
 * @level easy
 * @date Jun 19, 2013
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class UVa10080 {
	static int maxFlow(int[][] cap,int s,int t,int N,ArrayList<Integer>[] lAdy) {
		int flow=0,r[][]=new int[N][N];
		for(int f;(f=maxFlow(cap,s,t,N,r,lAdy))>0;flow+=f);
		return flow;
	}
	static int maxFlow(int[][] cap,int s,int t,int N,int[][] r,ArrayList<Integer> lAdy[]) {
		LinkedList<Integer> cola=new LinkedList<Integer>();
		boolean[] visitados=new boolean[N];
		int[] ants=new int[N];
		int[] val=new int[N];
		val[s]=MAX_VALUE;
		visitados[s]=true;
		cola.add(s);
		Arrays.fill(ants, -1);
		for(;!cola.isEmpty();) {
			int u=cola.pollFirst();
			for(int v:lAdy[u])
				if(!visitados[v]&&cap[u][v]-r[u][v]>0) {
					cola.add(v);
					visitados[v]=true;
					val[v]=min(val[u],cap[u][v]-r[u][v]);
					ants[v]=u;
				}
		}
		int f=val[t];
		if(f>0) 
			for(;ants[t]>-1;t=ants[t]) {
				r[ants[t]][t]+=f;
				r[t][ants[t]]-=f;
			}
		return f;
	}
	static double dist(double[] a,double[] b) {
		return sqrt((a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]));
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String ln;(ln=in.readLine())!=null;) {
			StringTokenizer st=new StringTokenizer(ln);
			int n=parseInt(st.nextToken()),m=parseInt(st.nextToken()),s=parseInt(st.nextToken()),v=parseInt(st.nextToken());
			double[][] gopher=new double[n][];
			double[][] holes=new double[m][];
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(in.readLine());
				gopher[i]=new double[]{Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken())};
			}
			for(int i=0;i<m;i++) {
				st=new StringTokenizer(in.readLine());
				holes[i]=new double[]{Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken())};
			}
			int[][] cap=new int[n+m+2][n+m+2];
			ArrayList<Integer> [] lAdy=new ArrayList[n+m+2];
			for(int i=0;i<n+m+2;i++)lAdy[i]=new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++) {
					if(dist(gopher[i],holes[j])/v<=s) {
						cap[i][j+n]=1;
						lAdy[i].add(j+n);
						lAdy[j+n].add(i);
					} 
				}
			for(int i=0;i<n;i++) {
				cap[n+m][i]=1;
				lAdy[n+m].add(i);
				lAdy[i].add(n+m);
			}
			for(int j=0;j<m;j++) {
				cap[n+j][n+m+1]=1;
				lAdy[n+j].add(n+m+1);
				lAdy[n+m+1].add(n+j);
			}
			sb.append(n-maxFlow(cap,n+m,n+m+1,n+m+2,lAdy)).append("\n");
		}
		System.out.print(new String(sb));
	}
}
