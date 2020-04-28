package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict No enviado/Incompleto
 * @problemId 2044
 * @problemName Courses
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level medium
 * @date 15/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
public class LAUVa2044 {
	static int[][] kosaraju(int[][] lAdy){
		int n=lAdy.length;boolean vis[]=new boolean[n];
		ArrayList<Integer> ord=new ArrayList<Integer>(n),l=new ArrayList<Integer>();
		ArrayList<int[]> res=new ArrayList<int[]>();
		for(int i=0;i<n;i++)if(!vis[i])dfsKosaraju(lAdy,ord,vis,i);
		lAdy=grafoTraspuesto(lAdy);Arrays.fill(vis,false);
		for(int i=n-1,u;i>=0;i--)if(!vis[u=ord.get(i)]){l.clear();dfsKosaraju(lAdy,l,vis,u);res.add(toList(l));}
		return res.toArray(new int[0][]);
	}
	static int[] toList(List<Integer> l){
		int i=0,res[]=new int[l.size()];for(int n:l)res[i++]=n;
		return res;
	}
	static int[][] grafoTraspuesto(int[][] lAdy){
		int n,s[][]=new int[n=lAdy.length][],c[]=new int[n];
		for(int[] w:lAdy)for(int i:w)c[i]++;for(int i=0;i<n;i++)s[i]=new int[c[i]];
		Arrays.fill(c,0);for(int i=0;i<n;i++)for(int u:lAdy[i])s[u][c[u]++]=i;
		return s;
	}
	static void dfsKosaraju(int[][] lAdy, ArrayList<Integer> ord, boolean[] vis, int u){
		vis[u]=true;for(int v:lAdy[u])if(!vis[v])dfsKosaraju(lAdy,ord,vis,v);ord.add(u);
	}
	/* 0 a n-1 = p, de n a 2n - 1 = no p */
	static boolean sat2(int[][] clausulas,int n){
		int c[][]=clausulas,m=clausulas.length,lAdy[][]=new int[2*n][];ArrayList<Integer>[] s=new ArrayList[2*n];
		for(int i=0;i<2*n;i++)s[i]=new ArrayList<Integer>();
		for(int i=0,p,q;i<m;i++){p=c[i][0];q=c[i][1];s[p>=n?p-n:p+n].add(q);s[q>=n?q-n:q+n].add(p);}
		for(int i=0,r;i<2*n;i++){lAdy[i]=new int[r=s[i].size()];for(int j=0;j<r;j++)lAdy[i][j]=s[i].get(j);}
		int[][] comp=kosaraju(lAdy);
		for(int[] r:comp){Arrays.sort(r);for(int p:r)if(Arrays.binarySearch(r,p>=n?p-n:p+n)>=0)return false;}
		return true;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int c=0,C=parseInt(in.readLine().trim());c++<C;){
			StringTokenizer st=new StringTokenizer(in.readLine());
			int P=parseInt(st.nextToken()),N=parseInt(st.nextToken());
			ArrayList<int[]> clausulas=new ArrayList<int[]>();
			for(int i=0;i<P;i++){
				st=new StringTokenizer(in.readLine());
				int M=parseInt(st.nextToken());
				int[] arr=new int[M];
				for(int j=0;j<M;j++)arr[j]=parseInt(st.nextToken())-1;
				for(int j=0;j<M;j++)for(int k=j;k<M;k++){
					clausulas.add(new int[]{arr[j],arr[k]});
					if(k!=j){
						clausulas.add(new int[]{arr[j]+N,arr[k]});
						clausulas.add(new int[]{arr[j],arr[k]+N});
					}
				}
			}
			for(int[] r:clausulas)System.out.println(Arrays.toString(r));
			System.out.println(sat2(clausulas.toArray(new int[0][]),N));
		}
	}
}
