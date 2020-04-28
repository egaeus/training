package practice.tju; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict No enviado
 * @problemId 1348
 * @problemName Freckles
 * @judge http://acm.tju.edu.cn/
 * @category graph
 * @level easy
 * @date 30/07/2012
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class TJU1348{
	static double prim(double[][] mAdy,int n){
		boolean[] v=new boolean[n];
		double[] a=new double[n];
		PriorityQueue<double[]> cola=new PriorityQueue<double[]>(n,new Comparator<double[]>(){
			public int compare(double[] o1,double[] o2){
				if(o1[0]<o2[0])return -1;
				if(o1[0]>o2[0])return 1;
				if(o1[1]<o2[1])return -1;
				if(o1[1]>o2[1])return 1;
				return 0;
			}
		});
		Arrays.fill(a,Double.POSITIVE_INFINITY);
		a[0]=0;v[0]=true;
		cola.add(new double[]{0,0});
		for(int h;!cola.isEmpty();){
			double[] u=cola.poll();
			v[h=(int)u[1]]=true;
			for(int i=0;i<n;i++)
				if(!v[i]&&a[i]>mAdy[h][i])
					cola.add(new double[]{a[i]=mAdy[h][i],i});
		}
		double res=0;
		for(double s:a)res+=s;
		return res;
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(String ln;(ln=in.readLine())!=null;){
			int n=parseInt(ln.trim());
			double[][] pts=new double[n][];
			for(int i=0;i<n;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				pts[i]=new double[]{Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken())};
			}
			double[][] mAdy=new double[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					mAdy[i][j]=sqrt((pts[i][0]-pts[j][0])*(pts[i][0]-pts[j][0])+(pts[i][1]-pts[j][1])*(pts[i][1]-pts[j][1]));
			System.out.printf(Locale.US,"%.2f\n",prim(mAdy,n));
		}
	}
}
