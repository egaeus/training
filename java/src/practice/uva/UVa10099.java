package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10099
 * @problemName The Tourist Guide
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 29/12/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.min;
import static java.lang.Math.ceil;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;
public class UVa10099 {
	static int f(int v,TreeSet<Integer> lAdy[],int[][] mAdy,int f,int N){
		PriorityQueue<int[]> cola=new PriorityQueue<int[]>(N,new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[1]!=o2[1])return o2[1]-o1[1];
				return o1[0]-o2[0];
			}
		});
		boolean[] vis=new boolean[N];
		int[] res=new int[N];
		res[v]=MAX_VALUE;
		cola.add(new int[]{v,MAX_VALUE});
		for(int u[],c;!cola.isEmpty();){
			u=cola.poll();
			vis[u[0]]=true;
			for(int h:lAdy[u[0]]){
				c=min(u[1],mAdy[u[0]][h]);
				if(!vis[h]&&res[h]<c)cola.add(new int[]{h,res[h]=c});
			}
		}
		return res[f];
	}
	public static void main(String args[]) throws Throwable {
		Scanner sc=new Scanner(System.in);
		for (int caso=1;;caso++) {
			int N=sc.nextInt(),M=sc.nextInt();
			if(N==0&&M==0)break;
			TreeSet<Integer> lAdy[]=new TreeSet[N];
			int[][] mAdy=new int[N][N];
			for(int i=0;i<N;i++)lAdy[i]=new TreeSet<Integer>();
			for(int i=0;i<M;i++){
				int d=sc.nextInt()-1,h=sc.nextInt()-1,c=sc.nextInt();
				mAdy[d][h]=mAdy[h][d]=c-1;
				lAdy[d].add(h);
				lAdy[h].add(d);
			}
			int c=f(sc.nextInt()-1,lAdy,mAdy,sc.nextInt()-1,N);
			System.out.println("Scenario #"+caso);
			System.out.println("Minimum Number of Trips = "+(int)ceil(1.*sc.nextInt()/c));
			System.out.println();
		}
	}
}
