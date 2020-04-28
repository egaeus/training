package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3502
 * @problemName The mysterious X network
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 6/09/2011
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
public class LAUVa3502 {
	static int[] dijkstra(ArrayList<Integer> lAdy[], int v){
		int n; boolean visitados[] = new boolean[n=lAdy.length];
		int[] sol = new int[n];
		PriorityQueue<int[]> cola = new PriorityQueue<int[]>(n, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[1]!=o2[1]?(o1[1]<o2[1]?-1:1):(int)o1[0]-(int)o2[0];
			}
		});
		Arrays.fill(sol,MAX_VALUE-1000000);sol[v]=0;visitados[v]=true;
		cola.add(new int[]{v, 0});
		for(;!cola.isEmpty();){
			int[] ult = cola.poll();
			visitados[ult[0]]=true;
			for(int u: lAdy[ult[0]])
				if(!visitados[u]&&sol[u]-1e-10>sol[ult[0]]+1){
					cola.add(new int[]{u,sol[u]=sol[ult[0]]+1});
				}
		}
		return sol;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int c=0,C=parseInt(in.readLine().trim());c++<C;){
			in.readLine();
			int N=parseInt(in.readLine().trim());
			ArrayList<Integer>[] lAdy=new ArrayList[N];
			for(int i=0;i<N;i++)lAdy[i]=new ArrayList<Integer>();
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				int desde=parseInt(st.nextToken()),M=parseInt(st.nextToken());
				for(int j=0;j<M;j++)
					lAdy[desde].add(parseInt(st.nextToken()));				
			}
			StringTokenizer st=new StringTokenizer(in.readLine());
			int desde=parseInt(st.nextToken()),hasta=parseInt(st.nextToken());
			sb.append(desde+" "+hasta+" "+(dijkstra(lAdy,desde)[hasta]-1)+"\n"+(c<C?"\n":""));
		}
		System.out.print(new String(sb));
	}
}
