package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 558
 * @problemName Wormholes
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 18/07/2012
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa558{
	static ArrayList<Integer> lAdy[];
	static int mAdy[][],h;
	static boolean bellmanFord(int s){
		int n,sol[]=new int[n=lAdy.length];
		Arrays.fill(sol,MAX_VALUE-1000000);
		sol[s]=0;
		for(int i=0;i++<n-1;)
			for(int u=0;u<n;u++)
				for(int v:lAdy[u])
					sol[v]=min(sol[v],sol[u]+mAdy[u][v]);
		for(int u=0;u<n;u++)
			for(int v:lAdy[u])
				if(sol[v]>sol[u]+mAdy[u][v])
					return true;
		return false;
	}
	static boolean[] vis;
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		vis=new boolean[1000];
		for(int t=0,T=parseInt(in.readLine().trim());t++<T;){
			StringTokenizer st=new StringTokenizer(in.readLine());
			int n=parseInt(st.nextToken()),m=parseInt(st.nextToken());
			mAdy=new int[n][n];lAdy=new ArrayList[n];
			for(int i=0;i<n;i++)lAdy[i]=new ArrayList<Integer>();
			for(int i=0;i<m;i++){
				st=new StringTokenizer(in.readLine());
				int x=parseInt(st.nextToken()),y=parseInt(st.nextToken()),c=parseInt(st.nextToken());
				lAdy[x].add(y);mAdy[x][y]=c;
			}
			boolean ws=bellmanFord(0);
			sb.append(ws?"possible":"not possible");
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
