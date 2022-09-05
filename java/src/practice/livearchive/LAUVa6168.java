package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 6168
 * @problemName Fat Ninjas
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level easy
 * @date Jul 22, 2013
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;
public class LAUVa6168 {
	static int pts[][],N,L;
	static boolean[] vis;
	static int[] cola=new int[5000];
	static boolean f(ArrayList<Integer> lAdy[]) {
		int p=0,c=0;
		Arrays.fill(vis, false);
		vis[0]=true;
		cola[c++]=0;
		for(int u;p<c;) {
			u=cola[p++];
			for(int v:lAdy[u]) {
				if(v==N+1)return true;
				if(!vis[v]) {
					vis[v]=true;
					cola[c++]=v;
				}
			}
		}
		return false;
	}
	static double dist(int[] a,int[] b) {
		return sqrt((a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]));
	}
	static void armarGrafo(ArrayList<Integer> lAdy[],double a) {
		for(int i=0;i<lAdy.length;i++)lAdy[i].clear();
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) 
				if(dist(pts[i],pts[j])<2*a) {
					lAdy[i+1].add(j+1);
					lAdy[j+1].add(i+1);
				}
			if(pts[i][1]<2*a) {
				lAdy[0].add(i+1);
				lAdy[i+1].add(0);
			}
			if(L-pts[i][1]<2*a) {
				lAdy[N+1].add(i+1);
				lAdy[i+1].add(N+1);
			}
		}
	}
	static double f(double a,double b) {
		if(abs(b-a)<=1e-5)return (a+b)/2;
		double p=(a+b)/2;
		ArrayList<Integer> lAdy[]=new ArrayList[N+2];
		vis=new boolean[N+2];
		for(int i=0;i<N+2;i++)lAdy[i]=new ArrayList<Integer>();
		armarGrafo(lAdy, p);
		if(f(lAdy))return f(a,p);
		return f(p,b);
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (StringTokenizer st;(st=new StringTokenizer(in.readLine().trim()))!=null;) {
			L=parseInt(st.nextToken());
			N=parseInt(st.nextToken());
			if(N==0&&L==0)break;
			pts=new int[N][];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(in.readLine());
				pts[i]=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken())};
			}
			System.out.printf(Locale.US,"%.3f\n",2*f(0,L));
		}
		System.out.print(new String(sb));
	}
}
