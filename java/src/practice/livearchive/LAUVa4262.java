package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 4262
 * @problemName Road Networks
 * @judge http://www.spoj.pl | http://uva.onlinejudge.org/ | http://livearchive.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 25/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class LAUVa4262 {
	static int kosarajuCant(TreeSet<Integer> lAdy[]){
		int n=lAdy.length,res=0;boolean vis[]=new boolean[n];
		ArrayList<Integer> r=new ArrayList<Integer>(),l=new ArrayList<Integer>();
		for(int i=0;i<n;i++)if(!vis[i])dfs(lAdy,i,vis,r);
		lAdy=grafoT(lAdy);Arrays.fill(vis,false);
		for(int i=n-1;i>=0;i--)if(!vis[r.get(i)]){l.clear();dfs(lAdy,r.get(i),vis,l);res++;}
		return res;
	}
	static TreeSet<Integer>[] grafoT(TreeSet<Integer>[] lAdy){
		int n;TreeSet<Integer>[] res=new TreeSet[n=lAdy.length];
		for(int i=0;i<n;i++)res[i]=new TreeSet<Integer>();
		for(int i=0;i<n;i++)for(int v:lAdy[i])res[v].add(i);
		return res;
	}
	static void dfs(TreeSet<Integer> lAdy[], int v, boolean[] vis, ArrayList<Integer> r){
		vis[v]=true;for(int u:lAdy[v])if(!vis[u])dfs(lAdy,u,vis,r);r.add(v);
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int c=0,C=parseInt(in.readLine().trim());c++<C;){
			StringTokenizer st=new StringTokenizer(in.readLine());
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());
			TreeSet<Integer> lAdy[]=new TreeSet[N];
			for(int i=0;i<N;i++)lAdy[i]=new TreeSet<Integer>();
			for(int i=0;i<M;i++){
				st=new StringTokenizer(in.readLine());
				lAdy[parseInt(st.nextToken())-1].add(parseInt(st.nextToken())-1);
			}
			System.out.println(kosarajuCant(lAdy));
			in.readLine();
		}
	}
}
