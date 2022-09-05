package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 534
 * @problemName Frogger
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 22/03/2012
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class UVa534{
	static double distancia(int[] a,int[] b){
		return sqrt((a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]));
	}
	static double dijkstra(int v, int u, double[][] mAdy){
		int n;double res[]=new double[n=mAdy.length];
		class Nodo implements Comparable<Nodo>{
			int v;double d;
			Nodo(int v,double d){this.v=v;this.d=d;}
			public int compareTo(Nodo o){return d<o.d?-1:(d>o.d?1:v-o.v);}
			public String toString(){return v+":"+d;}
		}
		Arrays.fill(res,Double.POSITIVE_INFINITY);res[v]=0;
		PriorityQueue<Nodo> cola=new PriorityQueue<Nodo>();
		boolean[] vis=new boolean[n];vis[v]=true;cola.add(new Nodo(v,0));
		for(Nodo h;!cola.isEmpty();){
			h=cola.poll();
			for(int i=0;i<n;i++)
				if(i!=h.v&&res[i]>max(mAdy[h.v][i],res[h.v]))
					cola.add(new Nodo(i,res[i]=max(mAdy[h.v][i],res[h.v])));				
		}
		return res[u];
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int N,caso=1;(N=parseInt(in.readLine().trim()))!=0;caso++){
			int[][] pts=new int[N][];
			double[][] mAdy=new double[N][N];
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				pts[i]=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken())};
			}
			for(int i=0;i<N;i++)
				for(int j=i+1;j<N;j++)
					mAdy[i][j]=mAdy[j][i]=distancia(pts[i],pts[j]);
			in.readLine();
			System.out.printf("Scenario #%d\n",caso);
			System.out.printf(Locale.US,"Frog Distance = %.3f\n\n",dijkstra(0,1,mAdy));
		}
	}
}
