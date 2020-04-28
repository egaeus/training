package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId HEISLAZY
 * @problemName He is lazy
 * @judge http://www.spoj.pl
 * @category graph
 * @level easy
 * @date 26/07/2012
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class SPOJHEISLAZY{
	static double dist(double x1,double y1,double x2,double y2){
		return sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	static double dijsktra(int d,int h,double[][] mAdy){
		int n=mAdy.length;double[] sol=new double[n];
		boolean[] visitados=new boolean[n];
		PriorityQueue<double[]> cola=new PriorityQueue<double[]>(n,new Comparator<double[]>(){
			public int compare(double[] o1,double[] o2){
				if(o1[0]<o2[0])return -1;
				if(o1[0]>o2[0])return 1;
				if(o1[1]<o2[1])return -1;
				if(o1[1]>o2[1])return 1;
				return 0;
			}
		});
		Arrays.fill(sol,Double.POSITIVE_INFINITY);sol[d]=0;
		visitados[d]=true;cola.add(new double[]{0,d});
		for(;!cola.isEmpty();) {
			double[] u=cola.poll();
			int p=(int)u[1];
			visitados[p]=true;
			for(int v=0;v<n;v++)
				if(!visitados[v]&&sol[v]>sol[p]+mAdy[p][v])
					cola.add(new double[]{sol[v]=sol[p]+mAdy[p][v],v});
		}
		return sol[h];
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),px=parseInt(st.nextToken()),py=parseInt(st.nextToken()),
					lx=parseInt(st.nextToken()),ly=parseInt(st.nextToken());
			if(N==-1&&px==-1&&py==-1&&lx==-1&&ly==-1)break;
			double[][] c=new double[N][];
			for(int i=0;i<N;i++){
				st=new StringTokenizer(in.readLine());
				c[i]=new double[]{parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken())};
			}
			double[][] mAdy=new double[N+2][N+2];
			for(int i=0;i<N+2;i++)Arrays.fill(mAdy[i],Double.POSITIVE_INFINITY);
			mAdy[N][N+1]=mAdy[N+1][N]=dist(px,py,lx,ly);
			for(int i=0;i<N;i++) {
				mAdy[N][i]=dist(px,py,c[i][0],c[i][1]);
				mAdy[i][N]=min(dist(px,py,c[i][0],c[i][1]),abs(dist(px,py,c[i][0],c[i][1])-c[i][2]));
				mAdy[N+1][i]=dist(lx,ly,c[i][0],c[i][1]);
				mAdy[i][N+1]=min(dist(lx,ly,c[i][0],c[i][1]),abs(dist(lx,ly,c[i][0],c[i][1])-c[i][2]));
				for(int j=0;j<N;j++)
					mAdy[i][j]=min(dist(c[i][0],c[i][1],c[j][0],c[j][1]),abs(dist(c[i][0],c[i][1],c[j][0],c[j][1])-c[i][2]));
			}
			System.out.printf(Locale.US,"%.2f\n",dijsktra(N,N+1,mAdy));
		}
	}
}
