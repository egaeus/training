package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict W.A.
 * @problemId 10012
 * @problemName How Big Is It?
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date Jun 17, 2013
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa10012 {
	static int M;
	static double rad[];
	static double f(int A,int arr[],int p) {
		if(p==M) {
			double val=rad[arr[0]];
			int ant=0;
			double cant=0;
			System.out.println(Arrays.toString(arr));
			for(int i=1;i<M;i++) {
				double v=sqrt((rad[arr[i]]+rad[arr[i-1]])*(rad[arr[i]]+rad[arr[i-1]])-abs(rad[arr[i]]-rad[arr[i-1]])*abs(rad[arr[i]]-rad[arr[i-1]]));
				if(v+cant>=rad[arr[ant]]) {
					System.out.println(v+" "+cant);
					ant=i;
					cant=0;
					val+=v+cant;
				}
				else cant+=v;
			}
			System.out.println(cant);
			if(cant+rad[arr[p-1]]>=rad[arr[ant]])
				val+=rad[arr[p-1]];
			System.out.println(val);
			return val;
		}
		double min=Double.POSITIVE_INFINITY;
		for(int i=0;i<M;i++)
			if((A&(1<<i))==0) {
				arr[p]=i;
				min=min(min,f(A|(1<<i),arr,p+1));
			}
		return min;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int N=parseInt(in.readLine().trim()),n=0;n++<N;) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			M=parseInt(st.nextToken());
			rad=new double[M];
			for(int i=0;i<M;i++)
				rad[i]=Double.parseDouble(st.nextToken());
			System.out.printf(Locale.US,"%.3f\n",f(0,new int[M],0));
		}
	}
}
