package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 12637
 * @problemName 30 Minutes or Less
 * @judge http://uva.onlinejudge.org/
 * @category hungarian
 * @level easy
 * @date Nov 8, 2013
 **/
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa12637 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln;(ln =in.readLine())!=null;){
			StringTokenizer st = new StringTokenizer(ln);
			int R = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			double  [][] m = new double[N][R];
			int res[][] = new int[R][];
			int ord[][]  = new int[N][];
			for(int i=0;i<R;++i){
				st = new StringTokenizer(in.readLine());
				res[i]= new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			}
			for(int i=0;i<N;++i)
			{
				st = new StringTokenizer(in.readLine());
				ord[i]= new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			}
			
			for(int i=0;i<N;++i){
				for(int j=0;j<R;++j){
					m[i][j]= abs(res[j][0]-ord[i][0])+abs(res[j][1]-ord[i][1]); 
				}
			}
			
			System.out.println((int)asignacion(m, N, R));
		}
	}

	
	public static double asignacion(double tabla[][], int filas, int columnas) {
		double[][] copy=new double[filas+1][columnas+1];
		for(int i=0;i<filas;i++)
			for(int j=0;j<columnas;j++)
				copy[i+1][j+1]=tabla[i][j];
		double[]  u=new double[filas+1],v=new double[columnas+1],minv=new double[columnas+1];
		int[] p=new int[columnas+1],camino=new int[columnas+1];
		boolean vis[]=new boolean[columnas+1];
		for(int i=1;i<=filas;i++) {
			Arrays.fill(minv,Double.POSITIVE_INFINITY);
			Arrays.fill(vis, false);
			p[0]=i;
			int J=0;
			for(;;) {
				vis[J] = true; 
				int i0 = p[J];
				double delta = Double.POSITIVE_INFINITY; 
				int I=0; 
				for(int j=1;j<=columnas;j++)
					if (!vis[j]) { 
						double cur = copy[i0][j] - u[i0] - v[j]  ; 
						if (cur<minv[j]){
							minv[j] = cur ; 
							camino[j] = J ; 
						}
						if (minv[j]<delta ) {
							delta = minv[j] ; 
							I= j ;
						}
					}
				for (int j=0;j<= columnas ;j++) {
					if(vis[j]){ 
						u[p[j]]+=delta; 
						v[j] -= delta; 
					}else 
					minv[j] -=delta ; }
				J = I ;
				if(p[J]==0)
					break;
			}  
			for(;;) { 
				int I=camino[J] ; 
				p[J]=p[I] ; 
				J = I ; 
				if(J==0)
					break;
			} 
		}
		int sol[]=new int[filas+1] ; 
		for ( int i=1;i<p.length;i++){ 
			if ( p[i] != 0 ) 
				sol[p[i]] = i; 
		}		
		return -v[0] ; 
	}
}
