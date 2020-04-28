package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10243
 * @problemName Fire! Fire!! Fire!!!
 * @judge http://uva.onlinejudge.org/
 * @category Graph, dp, max-flow
 * @level medium
 * @date 10/6/2015
 **/
import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
public class UVa10243 {
	static class Escaner {
		private BufferedReader in;
		private StringTokenizer st;
		public Escaner() {
			in=new BufferedReader(new InputStreamReader(System.in));
			st=new StringTokenizer("");
		}
		
		public int next() throws Throwable{
			if(st.hasMoreTokens())
				return parseInt(st.nextToken());
			st=new StringTokenizer(in.readLine());
			return next();
		}
	}
	
	public static void main(String args[]) throws Throwable {
		Escaner sc=new Escaner();
		StringBuilder sb = new StringBuilder();
		for (int N;(N=sc.next())!=0;) {
			ArrayList<Integer> lAdy[]=new ArrayList[N];
			for(int i=0;i<N;i++)
				lAdy[i]=new ArrayList<Integer>();
			for(int i=0;i<N;i++) {
				int K=sc.next();
				for(int j=0;j<K;j++)
					lAdy[i].add(sc.next()-1);
			}
			TreeSet<Integer> up=new TreeSet<Integer>();
			TreeSet<Integer> down=new TreeSet<Integer>();
			up.add(0);
			LinkedList<Integer> queue=new LinkedList<Integer>();
			queue.add(0);
			for(;!queue.isEmpty();) {
				int u=queue.poll();
				boolean isUp=up.contains(u);
				for(int v:lAdy[u]) {
					if(!up.contains(v)&&!down.contains(v)) {
						if(isUp)
							down.add(v);
						else
							up.add(v);
						queue.add(v);
					}
				}
			}
			if(N==1)
				System.out.println(1);
			else
				System.out.println(Math.min(f(up, down, lAdy, N), f(down, up, lAdy, N)));
		}
		System.out.print(new String(sb));
	}
	
	static int f(TreeSet<Integer> up, TreeSet<Integer> down, ArrayList<Integer> lAdy[], int N) {
		ArrayList<Integer> lAdy1[]=new ArrayList[N+2];
		for(int i=0;i<N+2;i++)
			lAdy1[i]=new ArrayList<Integer>();
		int[][] cap=new int[N+2][N+2];
		for(int u:up) {
			for(int v:lAdy[u]) {
				cap[u][v]=1;
				lAdy1[u].add(v);
				lAdy1[v].add(u);
			}
			lAdy1[u].add(N);
			lAdy1[N].add(u);
			cap[N][u]=1;
		}
		for(int u:down) {
			cap[u][N+1]=1;
			lAdy1[u].add(N+1);
			lAdy1[N+1].add(u);
		}
		return maxFlow(cap, N, N+1, lAdy1);
	}
	
	static int maxFlow(int[][] cap,int v,int t, ArrayList<Integer> lAdy[]) {
		int[][] r=new int[cap.length][cap.length];
		int f=0;
		for(int flow;(flow=maxFlow(cap, r, v, t, lAdy))!=0;f+=flow);
		return f;
	}
	static int maxFlow(int[][] cap,int[][] r,int v,int t, ArrayList<Integer> lAdy[]) {
		boolean[] vis=new boolean[cap.length];
		int[] ant=new int[cap.length];
		int[] val=new int[cap.length];
		val[v]=MAX_VALUE;
		vis[v]=true;
		LinkedList<Integer> cola=new LinkedList<Integer>();
		cola.add(v);
		Arrays.fill(ant, -1);
		for(;!cola.isEmpty();) {
			int u=cola.pollFirst();
			for(int i: lAdy[u])
				if(!vis[i]&&cap[u][i]-r[u][i]>0) {
					cola.add(i);
					val[i]=Math.min(val[u],cap[u][i]-r[u][i]);
					ant[i]=u;
					if(i==t){cola.clear();break;}
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
}
