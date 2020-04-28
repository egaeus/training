package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 544
 * @problemName Heavy Cargo
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 10/04/2012
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVa544{
	static int dijkstra(int v,int h,int[][] mAdy,int n){
		boolean[] vis=new boolean[n];int sol[]=new int[n];
		PriorityQueue<int[]> cola=new PriorityQueue<int[]>(n,new Comparator<int[]>(){
			public int compare(int[] o1,int[] o2){
				return o1[1]!=o2[1]?o2[1]-o1[1]:o1[0]-o2[0];
			}
		});
		cola.add(new int[]{v,MAX_VALUE});vis[v]=true;sol[v]=MAX_VALUE;
		for(int u[],s;!cola.isEmpty();){
			s=(u=cola.poll())[0];vis[s]=true;
			for(int i=0;i<n;i++)
				if(!vis[i]&&sol[i]<min(sol[s],mAdy[s][i]))cola.add(new int[]{i,sol[i]=min(sol[s],mAdy[s][i])});
		}
		return sol[h];
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();int caso=1;
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;caso++){
			int n=parseInt(st.nextToken()),r=parseInt(st.nextToken());
			if(n==0&&r==0)break;
			TreeMap<String,Integer> mapa=new TreeMap<String,Integer>();
			int[][]mAdy=new int[n][n];
			for(int i=0;i<n;i++)mAdy[i][i]=MAX_VALUE;
			for(int i=0;i<r;i++){
				st=new StringTokenizer(in.readLine());
				String desde=st.nextToken(),hasta=st.nextToken();
				int costo=parseInt(st.nextToken());
				Integer d=mapa.get(desde),h=mapa.get(hasta);
				if(d==null){d=mapa.size();mapa.put(desde,d);}
				if(h==null){h=mapa.size();mapa.put(hasta,h);}
				mAdy[d][h]=mAdy[h][d]=costo;
			}
			st=new StringTokenizer(in.readLine());
			int d=mapa.get(st.nextToken()),h=mapa.get(st.nextToken());
			sb.append("Scenario #"+caso+"\n");
			sb.append(dijkstra(d,h,mAdy,n)+" tons\n\n");
		}
		System.out.print(new String(sb));
	}
}
