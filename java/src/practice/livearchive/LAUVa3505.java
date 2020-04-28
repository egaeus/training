package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3505
 * @problemName Buy or Build
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level medium
 * @date 07/09/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class LAUVa3505 {
	static int prim(boolean[] vis){
		int n,p[]=new int[n=mAdy.length];int d[]=new int[n];
		PriorityQueue<int[]> cola=new PriorityQueue<int[]>(n,new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2){
				return o1[1]!=o2[1]?(o1[1]<o2[1]?-1:1):o1[0]-o2[0];
			}
		});
		Arrays.fill(d,MAX_VALUE);
		Arrays.fill(p,-1);boolean ws=false;
		for(int i=0;i<n;i++)if(vis[i]){cola.add(new int[]{i,0});ws=true;}
		if(!ws){vis[0]=true;cola.add(new int[]{0,0});}
		for(;!cola.isEmpty();){
			int[] ult=cola.poll();int s=ult[0];vis[s]=true;
			for(int u=0;u<n;u++)
				if(u!=s&&!vis[u]&&d[u]>mAdy[s][u]){
					p[u]=s;
					cola.add(new int[]{u,d[u]=mAdy[s][u]});
				}
		}
		int res=0;
		for(int i=0;i<n;i++)if(p[i]>=0)res+=mAdy[p[i]][i];
		return res;
	}
	static int f(int p, boolean[] v, int c){
		if(p==vis.length)return prim(v)+c;
		boolean[] cp=new boolean[v.length];
		int min=MAX_VALUE;
		for(int i=0;i<v.length;i++)
			for(int j=0;j<v.length;j++)
				if(v[i]&&vis[p][j])min=Math.min(min,mAdy[i][j]);
		for(int i=0;i<v.length;i++)cp[i]=v[i]||vis[p][i];
		return Math.min(f(p+1,v,c),f(p+1,cp,c+costo[p]+(min==MAX_VALUE?0:min)));
	}
	static int[][] mAdy;
	static int[][] mAdyEntre;
	static boolean vis[][];
	static int[] costo;
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int c=0,C=parseInt(in.readLine().trim());c++<C;){
			in.readLine();
			StringTokenizer st=new StringTokenizer(in.readLine());
			int N=parseInt(st.nextToken()),Q=parseInt(st.nextToken());
			vis=new boolean[Q][N];mAdyEntre=new int[Q][Q];
			costo=new int[Q];
			for(int i=0;i<Q;i++){
				st=new StringTokenizer(in.readLine());
				int M=parseInt(st.nextToken());costo[i]=parseInt(st.nextToken());
				for(int j=0;j<M;j++)vis[i][parseInt(st.nextToken())-1]=true;
			}
			mAdy=new int[N][N];
			int[][] pts=new int[N][];
			for(int i=0;i<N;i++){
				st=new StringTokenizer(in.readLine());
				pts[i]=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken())};
			}
			for(int i=0;i<N;i++)for(int j=i+1;j<N;j++)mAdy[i][j]=mAdy[j][i]=(pts[i][0]-pts[j][0])*(pts[i][0]-pts[j][0])+(pts[i][1]-pts[j][1])*(pts[i][1]-pts[j][1]);
			System.out.println(f(0,new boolean[N],0)+(c<C?"\n":""));
		}
	}
}
