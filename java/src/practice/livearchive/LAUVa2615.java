package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict T.L.E.
 * @problemId 2615
 * @problemName Not Too Convex Hull
 * @judge http://livearchive.onlinejudge.org/
 * @category dp, geom
 * @level medium
 * @date 18/08/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;
import static java.lang.Math.atan2;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.StringTokenizer;
public class LAUVa2615 {
	static int B,N;
	static double mem[][];
	static int[] pt,pts[];
	static double areas[][];
	static double f(int R){
		mem=new double[B+1][N+1];
		for(double[] d:mem)Arrays.fill(d,Double.POSITIVE_INFINITY);
		mem[B][N]=0;
		for(int i=B-1;i>=0;i--)
			for(int j=N-1;j>=0;j--){
				for(int h=j+2;h<=N;h++){
					double area=areas[(j+N-R)%N][(h-1+N-R)%N];
					mem[i][j]=min(mem[i][j],area+mem[i+1][h]);
				}
			}
		return mem[0][0];
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		areas=new double[101][101];
		//BufferedReader in=new BufferedReader(new FileReader("C:\\convex.in.txt"));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			B=parseInt(st.nextToken());N=parseInt(st.nextToken())-1;
			if(B==0&&N==-1)break;
			st=new StringTokenizer(in.readLine());
			pt=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken())};
			pts=new int[N][2];
			for(int i=0;i<N;i++){
				st=new StringTokenizer(in.readLine());
				pts[i]=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken())};
			}
			final int[] P=pt;
			Arrays.sort(pts, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if(o1==P)return -1;if(o2==P)return 1;
					double dist1=atan2(o1[0]-P[0],o1[1]-P[1]),
					dist2=atan2(o2[0]-P[0],o2[1]-P[1]);
					return dist1<dist2?-1:1;
				}
			});
			int[][] copia=new int[2*N][];
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++){
					int n=i<=j?j-i+2:(N-i+j+2);
					for(int h=0,r=i;h<n;h++,r=(r+1)%N)copia[h]=pts[r];
					copia[n-1]=pt;
					int[][] convex=convexHull(copia,1e-6,false,n);
					double area=area(convex);
					if(area<1e-6)area=Double.POSITIVE_INFINITY;
					areas[i][j]=area;
				}
			double res=Double.POSITIVE_INFINITY;
			for(int i=0;i<N;i++)
				res=min(res,f(i+1));
			System.out.printf(Locale.US,"%.2f%n",res);
		}
	}
	static double movimientoVectorial(int[] p,int[] q,int[] r){
		return (q[0]-p[0])*(r[1]-p[1])-(q[1]-p[1])*(r[0]-p[0]);
	}
	static boolean doubleEquals(double a, double b, double epsilon){
		if(Math.abs(a)==Double.POSITIVE_INFINITY&&Math.abs(b)==Double.POSITIVE_INFINITY)return true;
		return Math.abs(a-b)<=epsilon;
	}
	static int[][] res=new int[102][2];
	static int[][] convexHull(int[][] pts, final double epsilon, boolean conBorde, int np){
		if(pts.length==0)return new int[0][];
		int n=np;
		int[] p=new int[]{MAX_VALUE,MAX_VALUE};
		for(int i=0;i<n;i++){int[] q=pts[i];
			if(q[1]<p[1]||(q[1]==p[1]&&q[0]<p[0]))p=q;}
		final int[] P=p;
		Arrays.sort(pts, 0, n, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1==P)return -1;if(o2==P)return 1;
				double dist1=Math.atan2(o1[0]-P[0],o1[1]-P[1]),
				dist2=Math.atan2(o2[0]-P[0],o2[1]-P[1]);
				return (dist1<dist2?-1:1);
			}
		});
		int j=Math.min(2, n);int i=j+1;
		res[0]=p;res[1%n]=pts[1%n];
		int[] p1=pts[1%n],p2=pts[2%n];
		if(!conBorde){
			j = 1;
			for (int k = 1; k < n; k++)
				if(!pts[k].equals(pts[0])){p1 = pts[k]; res[1%n]=pts[k];
					p2 = pts[(k+1)%n];i=k;j=2;break;}
		}
		for (; i <= n; i++)
			if((doubleEquals(movimientoVectorial(p2,p1,pts[i%n]),0,epsilon)&&conBorde)||(!doubleEquals(movimientoVectorial(p2, p1, pts[i%n]),0,epsilon)&&movimientoVectorial(p2,p1,pts[i%n])>0)){
				if(p2!=pts[1])res[j++]=p2;
	 			p1=p2;p2=pts[i%n];
			}
			else {
				if(i>2&&!doubleEquals(movimientoVectorial(p2,p1,pts[i%n]),0,epsilon))i--;
				if(j-2<0)p1=res[0];else p1 =res[j-2];p2 = res[j-1];
				if(j > 2){res[--j] = null;}
			}
		return Arrays.copyOfRange(res, 0, j);
	}
	static double area(int[][] pts) {
		double res=0;int n=pts.length;
		for(int i=0,j=1;i<n;i++,j=(j+1)%n)
			res+=pts[i][0]*pts[j][1]-pts[i][1]*pts[j][0];
		return Math.abs(res)/2.0;
	}
}
