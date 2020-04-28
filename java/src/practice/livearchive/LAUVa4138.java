package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 4138
 * @problemName Anti Brute Force Lock
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 31/07/2012
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class LAUVa4138{
	static class Escaner{
		BufferedReader in;
		StringTokenizer st;
		Escaner(){
			in=new BufferedReader(new InputStreamReader(System.in));
			st=new StringTokenizer("");
		}
		int nextInt() throws Throwable{
			if(st.hasMoreTokens()) return parseInt(st.nextToken());
			st=new StringTokenizer(in.readLine());
			return nextInt();
		}
	}
	static int d(int a,int b){
		return min(abs(a-b),min(a,b)+10-max(a,b));
	}
	static int s(int a,int b){
		int r=0;
		for(int i=0;i<4;i++,a/=10,b/=10)
			r+=d(a%10,b%10);
		return r;
	}
	public static void main(String args[]) throws Throwable{
		Escaner sc=new Escaner();
		for(int t=0,T=sc.nextInt();t++<T;){
			int n=sc.nextInt(),min=MAX_VALUE;
			int[] k=new int[n];
			for(int i=0;i<n;i++)
				min=min(min,s(k[i]=sc.nextInt(),0));
			int[][] mAdy=new int[2*n][2*n];
			ArrayList<Integer> lAdy[]=new ArrayList[2*n];
			for(int i=0;i<lAdy.length;i++)lAdy[i]=new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				lAdy[i].add(i+n);
				for(int j=i+1;j<n;j++){
					mAdy[i][j]=mAdy[j][i]=s(k[i],k[j]);
					lAdy[i].add(j);
					lAdy[j].add(i);
				}
				for(int j=0;j<n;j++)
					lAdy[n+i].add(n+j);
			}
			System.out.println(prim(mAdy,lAdy)+min);
		}
	}
	static int prim(int[][] mAdy,ArrayList<Integer> lAdy[]){
		int r=0,n=mAdy.length,res[]=new int[n];
		boolean vis[]=new boolean[n];
		PriorityQueue<int[]> cola=new PriorityQueue<int[]>(n,new Comparator<int[]>(){
			public int compare(int[] o1,int[] o2){
				return o1[0]!=o2[0]?o1[0]-o2[0]:o1[1]-o2[1];
			}
		});
		Arrays.fill(res,MAX_VALUE-10000000);
		res[0]=0;
		cola.add(new int[]{0,0});
		for(int u[];!cola.isEmpty();){
			u=cola.poll();
			vis[u[1]]=true;
			for(int v:lAdy[u[1]])
				if(!vis[v]&&res[v]>mAdy[u[1]][v])cola.add(new int[]{res[v]=mAdy[u[1]][v],v});
		}
		for(int a:res)
			r+=a;
		return r;
	}
}
