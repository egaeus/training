package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2887
 * @problemName Telecommunication Partners
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 24/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class LAUVa2887 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),P=parseInt(st.nextToken());
			if(N==0&&P==0)break;
			int K=parseInt(st.nextToken());
			TreeSet<Integer>[] lAdy=new TreeSet[N];TreeSet<Integer> set=new TreeSet<Integer>();
			for(int i=0;i<N;i++){lAdy[i]=new TreeSet<Integer>();set.add(i);}
			for(int i=0;i<P;i++){
				st=new StringTokenizer(in.readLine());
				int desde=parseInt(st.nextToken())-1,hasta=parseInt(st.nextToken())-1;
				lAdy[desde].add(hasta);lAdy[hasta].add(desde);
			}
			boolean[] eliminadas=new boolean[N];
			for(boolean ws=true;ws;){
				ws=false;
				for(int i=0;i<N;i++)
					if(!eliminadas[i]){
						int k=0;
						for(int u:lAdy[i])if(!eliminadas[u])k++;
						if(k<K){ws=true;eliminadas[i]=true;}
					}
			}			
			System.out.println(componentesConexas(lAdy, eliminadas));
		}
	}
	static int componentesConexas(TreeSet<Integer> lAdy[], boolean vis[]){
		int max=0;
		for(int i=0;i<vis.length;i++)if(!vis[i])max=Math.max(max,componentesConexas(lAdy, i, vis).size());
		return max;
	}
	static TreeSet<Integer> componentesConexas(TreeSet<Integer> lAdy[],int v,boolean[] vis){
		TreeSet<Integer> res=new TreeSet<Integer>();
		vis[v]=true;res.add(v);
		LinkedList<Integer> cola=new LinkedList<Integer>();
		cola.add(v);
		for(;!cola.isEmpty();){
			int u=cola.pollFirst();
			for(int i:lAdy[u])if(!vis[i]){res.add(i);vis[i]=true;cola.add(i);}
		}
		return res;
	}
}
