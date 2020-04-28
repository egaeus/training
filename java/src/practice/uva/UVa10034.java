package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10034
 * @problemName Freckles
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 22/12/2011
 **/
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class UVa10034 {
	static double prim(double d[][]){
		PriorityQueue<double[]> cola=new PriorityQueue<double[]>(d.length,new Comparator<double[]>() {
			public int compare(double[] o1, double[] o2) {
				if(o1[1]!=o2[1])return o1[1]<o2[1]?-1:1;
				return o1[0]<o2[0]?-1:1;
			}
		});
		boolean vis[]=new boolean[d.length];
		double mem[]=new double[d.length];
		Arrays.fill(mem,POSITIVE_INFINITY);
		mem[0]=0;cola.add(new double[]{0,0});
		for(;!cola.isEmpty();){
			int v=(int)cola.poll()[0];
			vis[v]=true;
			for(int u=0;u<d.length;u++)
				if(!vis[u]&&mem[u]>d[v][u])cola.add(new double[]{u,mem[u]=d[v][u]});
		}
		double res=0;
		for(int i=0;i<d.length;i++)res+=mem[i];
		return res;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int c=0,C=parseInt(in.readLine().trim());c<C;c++) {
			in.readLine();
			int N=parseInt(in.readLine().trim());
			double arr[][]=new double[N][];
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				arr[i]=new double[]{parseDouble(st.nextToken()),parseDouble(st.nextToken())};
			}
			double[][] d=new double[N][N];
			for(int i=0;i<N;i++)
				for(int j=i+1;j<N;j++)
					d[i][j]=d[j][i]=sqrt((arr[i][0]-arr[j][0])*(arr[i][0]-arr[j][0])+(arr[i][1]-arr[j][1])*(arr[i][1]-arr[j][1]));
			System.out.printf(Locale.US,"%.2f\n"+(c<C-1?"\n":""),prim(d));
		}
	}
}
