package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 10397
 * @problemName Connect the Campus
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 30/03/2012
 **/
import static java.lang.Math.sqrt;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Scanner;
public class UVa10397{
	static double prim(double[][] mAdy){
		int n,p[]=new int[n=mAdy.length],v=0;double d[]=new double[n];boolean[] vis=new boolean[n];
		PriorityQueue<double[]> cola=new PriorityQueue<double[]>(n,new Comparator<double[]>() {
			public int compare(double[] o1,double[] o2){
				return o1[1]!=o2[1]?(o1[1]<o2[1]?-1:1):(int)o1[0]-(int)o2[0];
			}
		});
		Arrays.fill(d, Double.POSITIVE_INFINITY);d[v]=0;vis[v]=true;
		Arrays.fill(p, -1);cola.add(new double[]{v,0});
		for(;!cola.isEmpty();){
			double[] ult=cola.poll();int s=(int)ult[0];vis[s]=true;
			for(int u=0;u<n;u++)
				if(u!=s&&!vis[u]&&d[u]>mAdy[s][u]){
					p[u]=s;
					cola.add(new double[]{u,d[u]=mAdy[s][u]});
				}
		}
		double res=0;
		for(int i=0;i<n;i++)if(p[i]>=0){res+=mAdy[p[i]][i];}
		return res;
	}
	public static void main(String args[]) throws Throwable{
		Scanner sc=new Scanner(System.in);
		for(;sc.hasNextInt();){
			int N=sc.nextInt();
			int[][] ciudades=new int[N][];
			for(int i=0;i<N;i++)
				ciudades[i]=new int[]{sc.nextInt(),sc.nextInt()};
			double[][] mAdy=new double[N][N];
			for(int i=0;i<N;i++)
				for(int j=i+1;j<N;j++)
					mAdy[i][j]=mAdy[j][i]=sqrt((ciudades[i][0]-ciudades[j][0])*(ciudades[i][0]-ciudades[j][0])+(ciudades[i][1]-ciudades[j][1])*(ciudades[i][1]-ciudades[j][1]));
			int M=sc.nextInt();
			for(int i=0;i<M;i++){
				int d=sc.nextInt()-1,h=sc.nextInt()-1;
				mAdy[d][h]=mAdy[h][d]=0;
			}
			System.out.printf(Locale.US,"%.2f%n",prim(mAdy));
		}
	}
}
