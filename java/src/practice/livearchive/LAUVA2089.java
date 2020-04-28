package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2089
 * @problemName  N-Credible Mazes
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 16/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class LAUVA2089 {
	static boolean hayCamino(ArrayList<ArrayList<Integer>> lAdy){
		boolean[] visitados=new boolean[lAdy.size()];
		LinkedList<Integer> pila=new LinkedList<Integer>();
		pila.add(0);visitados[0]=true;
		for(;!pila.isEmpty();){
			int v=pila.pollLast();
			for(int u:lAdy.get(v))if(!visitados[u]){visitados[u]=true;pila.add(u);if(u==1)return true;}
		}
		return false;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int N,caso=1;(N=parseInt(in.readLine().trim()))!=0;caso++){
			TreeMap<int[],Integer> mapa=new TreeMap<int[], Integer>(new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					for(int i=0;i<o1.length;i++)if(o1[i]!=o2[i])return o1[i]-o2[i];
					return 0;
				}
			});
			ArrayList<ArrayList<Integer>> lAdy=new ArrayList<ArrayList<Integer>>();
			for(int c=0;;c++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				int[] desde=new int[N],hasta=new int[N];
				desde[0]=parseInt(st.nextToken());
				if(desde[0]==-1)break;
				for(int i=1;i<N;i++)desde[i]=parseInt(st.nextToken());
				for(int i=0;i<N;i++)hasta[i]=parseInt(st.nextToken());
				if(!mapa.containsKey(desde)){mapa.put(desde,mapa.size());lAdy.add(new ArrayList<Integer>());}
				if(!mapa.containsKey(hasta)){mapa.put(hasta,mapa.size());lAdy.add(new ArrayList<Integer>());}
				int d=mapa.get(desde),h=mapa.get(hasta);
				if(c>0){
					lAdy.get(h).add(d);
					lAdy.get(d).add(h);
				}
			}
			System.out.println("Maze #"+caso+" "+(hayCamino(lAdy)?"can be travelled":"cannot be travelled"));
		}
	}
}
