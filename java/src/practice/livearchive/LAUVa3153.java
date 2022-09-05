package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 3153
 * @problemName Long Night of Museums
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level medium
 * @date 30/08/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class LAUVa3153 {	
	static int N,c[];
	static int[][] floydWarshall(int[][] mAdy){
		int N; int[][] res = new int[N=mAdy.length][N];
		for(int i=0;i<N;i++)for(int j=0;j<N;j++)res[i][j]=mAdy[i][j];
		for(int k=0;k<N;k++)
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					if(res[i][k]<MAX_VALUE&&res[k][j]<Double.MAX_VALUE)
							res[i][j]=Math.min(res[i][j],res[i][k]+res[k][j]);
		return res;
	}
	static boolean prim(int h){
		int n,p[]=new int[n=mAdy.length];int d[]=new int[n];boolean[] vis=new boolean[n];
		PriorityQueue<int[]> cola=new PriorityQueue<int[]>(n,new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2){
				return o1[1]!=o2[1]?(o1[1]<o2[1]?-1:1):o1[0]-o2[0];
			}
		});int sum=0;
		ArrayList<Integer> V=new ArrayList<Integer>();
		for(int i=0;i<N;i++)if((h&(1<<i))!=0){sum+=c[i];V.add(i);}else vis[i]=true;
		if(sum>420)return false;
		boolean visitados[]=vis.clone();
		for(int v:V){
			int res=sum;
			vis=visitados.clone();
			cola.clear();
			Arrays.fill(d,MAX_VALUE);d[v]=0;vis[v]=true;
			Arrays.fill(p, -1);cola.add(new int[]{v,0});
			for(;!cola.isEmpty();){
				int[] ult=cola.poll();int s=ult[0];vis[s]=true;
				for(int u=0;u<N;u++)
					if(u!=s&&!vis[u]&&d[u]>mAdy[s][u]){
						p[u]=s;
						cola.add(new int[]{u,d[u]=mAdy[s][u]});
					}
			}
			for(int i=0;i<n;i++)if(p[i]>=0){res+=mAdy[p[i]][i];}
			if(res<=420)return true;
		}
		return false;
	}
	static int mAdy[][];
	static int function(int k,int s){
		if(k==s)return k;
		int p=(int)Math.ceil((k+s)/2.);
		for(int i=0;i<(1<<N);i++)if(Integer.bitCount(i)==p&&prim(i))return function(p,s);
		return function(k,p-1);
	}
	public static void main(String[] args) throws Throwable{
		int i,j;c=new int[20];
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(;(N=parseInt(in.readLine().trim()))!=0;){
			StringTokenizer st=new StringTokenizer(in.readLine());
			mAdy=new int[N][N];
			for(i=0;i<N;i++)c[i]=parseInt(st.nextToken());
			for(i=0;i<N;i++){
				st=new StringTokenizer(in.readLine());
				for(j=0;j<N;j++)mAdy[i][j]=parseInt(st.nextToken());
			}
			mAdy=floydWarshall(mAdy);
			System.out.println(function(0,N));
		}
	}
}
