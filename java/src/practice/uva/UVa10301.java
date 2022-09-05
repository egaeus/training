package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10301
 * @problemName Rings and Glue
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date Jun 17, 2013
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class UVa10301 {
	static boolean intersection(double[] a,double b[]) {
		return dist(a,b)<a[2]+b[2]&&dist(a,b)+min(a[2],b[2])>max(a[2],b[2]);
	}
	static double dist(double a[],double b[]) {
		return sqrt((a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]));
	}
	static int maxComponent(ArrayList<Integer> lAdy[],int N) {
		int max=0;
		boolean[] vis=new boolean[N];
		for(int i=0;i<N;i++) 
			if(!vis[i]) 
				max=Math.max(max,component(lAdy,vis,i));
		return max;
	}
	static int[] cola=new int[100];
	static int component(ArrayList<Integer> lAdy[],boolean[] vis,int u) {
		int c=1,p=0,res=1;
		vis[u]=true;
		cola[0]=u;
		for(;p<c;) 
			for(int v:lAdy[cola[p++]])
				if(!vis[v]) {
					vis[v]=true;
					cola[c++]=v;
					res++;
				}
		return res;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int N;(N=parseInt(in.readLine().trim()))!=-1;) {
			double[][] circles=new double[N][];
			for(int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(in.readLine());
				circles[i]=new double[]{Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken())};
			}
			ArrayList<Integer> lAdy[]=new ArrayList[N];
			for(int i=0;i<N;i++)lAdy[i]=new ArrayList<Integer>();
			for(int i=0;i<N;i++)
				for(int j=i+1;j<N;j++) 
					if(intersection(circles[i], circles[j])) {
						lAdy[i].add(j);
						lAdy[j].add(i);
					}
			int max=maxComponent(lAdy, N);
			sb.append("The largest component contains ").append(max).append(" ").append(max==1?"ring":"rings").append(".\n");
		}
		System.out.print(new String(sb));
	}
}
