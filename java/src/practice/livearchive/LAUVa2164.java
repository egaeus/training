package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2164
 * @problemName Cable Network
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 08/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class LAUVa2164 {
	static long prim(ArrayList<Integer>[] lAdy, int[][] mAdy, int X, int V){
		int n,p[]=new int[n=lAdy.length];double d[]=new double[n];boolean[] vis=new boolean[n];int v=0;long c=0;
		for(int i=1;i<n;i++)
			if((X&(1<<(i-1)))==0){vis[i]=true;c++;}
		PriorityQueue<double[]> cola=new PriorityQueue<double[]>(n,new Comparator<double[]>() {
			public int compare(double[] o1,double[] o2){
				return o1[1]!=o2[1]?(o1[1]<o2[1]?-1:1):(int)o1[0]-(int)o2[0];
			}
		});
		Arrays.fill(d, Double.POSITIVE_INFINITY);d[v]=0;vis[v]=true;
		Arrays.fill(p, -1);cola.add(new double[]{v,0});
		for(;!cola.isEmpty();){
			double[] ult=cola.poll();int s=(int)ult[0];vis[s]=true;
			for(int u:lAdy[s])
				if(!vis[u]&&d[u]>mAdy[s][u]){
					p[u]=s;
					cola.add(new double[]{u,d[u]=mAdy[s][u]});
				}
		}
		c*=V;
		for(int i=0;i<n;i++)if(p[i]>=0){c+=mAdy[i][p[i]];}
		return c;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();int caso=1;
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;caso++){
			int N=parseInt(st.nextToken()),V=parseInt(st.nextToken());
			if(N==0)break;
			ArrayList<Integer>[] lAdy=new ArrayList[N+1];
			int[][] mAdy=new int[N+1][N+1];
			for(int i=0;i<N+1;i++){
				lAdy[i]=new ArrayList<Integer>();
				for(int j=0;j<N+1;j++)if(i!=j)lAdy[i].add(j);
			}
			for(int i=0;i<N;i++){
				st=new StringTokenizer(in.readLine());
				for(int j=i+1;j<N+1;j++)mAdy[i][j]=mAdy[j][i]=parseInt(st.nextToken());
			}
			long min=N*V;
			for(int i=0;i<1<<N;i++)min=Math.min(prim(lAdy,mAdy,i,V),min);
			sb.append("Cable Net #"+caso+"\n"+V*N+"\n"+min+"\n\n");
		}
		System.out.print(new String(sb));
	}
}
