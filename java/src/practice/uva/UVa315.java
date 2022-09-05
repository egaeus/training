package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 315
 * @problemName Network
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 29/03/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class UVa315 {
	static int f(TreeSet<Integer> lAdy[],int n){
		int c=cantidadComponentes(lAdy,n,-1),r=0;
		for(int i=0;i<n;i++)if(cantidadComponentes(lAdy,n,i)>c)r++;
		return r;
	}
	static int cantidadComponentes(TreeSet<Integer> lAdy[],int n,int v){
		boolean[] vis=new boolean[n];
		if(v!=-1)vis[v]=true;int res=0;
		for(int i=0;i<n;i++)if(!vis[i]){componente(lAdy,i,vis);res++;}
		return res;
	}
	static void componente(TreeSet<Integer> lAdy[],int v,boolean[] vis){
		vis[v]=true;LinkedList<Integer> cola=new LinkedList<Integer>();
		cola.add(v);
		for(;!cola.isEmpty();){
			v=cola.pollFirst();
			for(int u:lAdy[v])
				if(!vis[u]){
					vis[u]=true;
					cola.add(u);
				}
		}
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int N;(N=parseInt(in.readLine().trim()))!=0;) {
			TreeSet<Integer> lAdy[]=new TreeSet[N];
			for(int i=0;i<N;i++)lAdy[i]=new TreeSet<Integer>();
			for(StringTokenizer st;;){
				st=new StringTokenizer(in.readLine());
				int desde=parseInt(st.nextToken())-1;
				if(desde==-1)break;
				for(int hasta;st.hasMoreTokens();){
					hasta=parseInt(st.nextToken())-1;
					lAdy[desde].add(hasta);lAdy[hasta].add(desde);
				}
			}
			System.out.println(f(lAdy,N));
		}
	}
}
