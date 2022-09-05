package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2613
 * @problemName Will Indiana Jones Get There?
 * @judge http://livearchive.onlinejudge.org/
 * @category graph, geom
 * @level medium
 * @date 18/08/2011
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.sqrt;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class LAUVa2613 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			double[][] lns=new double[N][];
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				int X=parseInt(st.nextToken()),Y=parseInt(st.nextToken()),L=parseInt(st.nextToken());
				lns[i]=new double[]{X,Y,L>=0?X+L:X,L<0?Y-L:Y};
			}
			double[][] mAdy=new double[N][N];
			for(int i=0;i<N;i++)
				for(int j=i+1;j<N;j++){
					mAdy[i][j]=mAdy[j][i]=distancia(lns[i], lns[j]);
				}
			ArrayList<Integer>[] lAdyTree=prim(mAdy,0);
			LinkedList<double[]> cola=new LinkedList<double[]>();boolean vis[]=new boolean[N];
			cola.add(new double[]{0,0});vis[0]=true;
			for(;cola.getLast()[0]!=1;){
				double r[]=cola.pollLast();int v=(int)r[0];
				for(int u:lAdyTree[v])if(!vis[u]){cola.add(new double[]{u,max(r[1],mAdy[v][u])});vis[u]=true;if(u==1)break;}
			}
			/*for(double d[]:mAdy){
				for(double h:d)System.out.printf("%.2f ",h);
				System.out.println();
			}*/
			System.out.printf(Locale.US,"%.2f%n",cola.getLast()[1]);
		}
	}
	static ArrayList<Integer>[] prim(double[][] mAdy, int v){
		int n,p[]=new int[n=mAdy.length];double d[]=new double[n];boolean[] vis=new boolean[n];
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
		ArrayList<Integer>[] res=new ArrayList[n];
		for(int i=0;i<n;i++)res[i]=new ArrayList<Integer>();
		for(int i=0;i<n;i++)if(p[i]>=0){res[p[i]].add(i);res[i].add(p[i]);}
		return res;
	}
	static double distancia(double[] l1,double[] l2){
		if(interseccionSq(new Line2D.Double(l1[0],l1[1],l1[2],l1[3]),new Line2D.Double(l2[0],l2[1],l2[2],l2[3]))!=null)return 0;
		if(l1[0]==l1[2]&&l2[0]==l2[2]){
			if((l1[1]>=l2[1]&&l1[1]<=l2[3])||(l1[3]>=l2[1]&&l1[3]<=l2[3])||(l2[1]>=l1[1]&&l2[1]<=l1[3])||(l2[3]>=l1[1]&&l2[3]<=l1[3]))
				return abs(l1[0]-l2[0]);
			return min(min(d(l1[0],l1[1],l2[0],l2[1]),d(l1[0],l1[1],l2[2],l2[3])),min(d(l1[2],l1[3],l2[0],l2[1]),d(l1[2],l1[3],l2[2],l2[3])));
		}
		if(l1[1]==l1[3]&&l2[1]==l2[3]){
			if((l1[0]>=l2[0]&&l1[0]<=l2[2])||(l1[2]>=l2[0]&&l1[2]<=l2[2])||(l2[0]>=l1[0]&&l2[0]<=l1[2])||(l2[2]>=l1[0]&&l2[2]<=l1[2]))
				return abs(l1[1]-l2[1]);
			return min(min(d(l1[0],l1[1],l2[0],l2[1]),d(l1[0],l1[1],l2[2],l2[3])),min(d(l1[2],l1[3],l2[0],l2[1]),d(l1[2],l1[3],l2[2],l2[3])));
		}
		if(l1[0]==l1[2]){
			if(l1[0]>=l2[0]&&l1[0]<=l2[2])
				return min(abs(l1[1]-l2[1]),abs(l1[3]-l2[1]));
			if(l2[1]>=l1[1]&&l2[1]<=l1[3])
				return min(abs(l1[0]-l2[0]),abs(l1[0]-l2[2]));
			return min(min(d(l1[0],l1[1],l2[0],l2[1]),d(l1[0],l1[1],l2[2],l2[3])),min(d(l1[2],l1[3],l2[0],l2[1]),d(l1[2],l1[3],l2[2],l2[3])));
		}
		return distancia(l2, l1);
	}
	static double d(double x1,double y1,double x2, double y2){
		return sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	static Point2D interseccionSq(Line2D l1,Line2D l2){
		Point2D p=interseccionLn(l1, l2);if(p==null)return null;
		double p1x=l1.getX1(),p1y=l1.getY1(),p2x=l1.getX2(),p2y=l1.getY2(),q1x=l2.getX1(),
		q1y=l2.getY1(),q2x=l2.getX2(),q2y=l2.getY2(),px=p.getX(),py=p.getY();
		if(px<=Math.max(p1x,p2x)&&px>=Math.min(p1x,p2x)&&py<=Math.max(p1y,p2y)&&
			py>=Math.min(p1y,p2y)&&px<=Math.max(q1x,q2x)&&px>=Math.min(q1x,q2x)&&
			py<=Math.max(q1y,q2y)&&py>=Math.min(q1y,q2y))return p;
		return null;
	}
	static Point2D interseccionLn(Line2D l1,Line2D l2){
		double p1=l1.getX1(),p2=l1.getY1(),x1=l1.getX2(),y1=l1.getY2(),q1=l2.getX1(),
		q2=l2.getY1(),x2=l2.getX2(),y2=l2.getY2(),v1=x1-p1,v2=y1-p2,w1=x2-q1,w2=y2-q2,
		s1=v2*(q1-p1)-v1*(q2-p2),s2=w2*v1-w1*v2,s=s1/s2;
		if(Math.abs(s2)<=1e-10)return null;
		return new Point2D.Double(q1+s*w1,q2+s*w2);
	}
}
