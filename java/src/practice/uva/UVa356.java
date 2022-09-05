package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 356
 * @problemName Square Pegs And Round Holes 
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 4/06/2012
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa356 {
	static boolean d(double[] c,double a,double b){
		return sqrt((c[0]-a)*(c[0]-a)+(c[1]-b)*(c[1]-b))<=c[2];
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();int caso=0;
		for (String ln;(ln=in.readLine())!=null;caso++) {
			if(caso>0)sb.append("\n");
			int N=parseInt(ln.trim());
			double[] c=new double[]{N,N,N-.5};
			int a=0,b=0;
			for(int i=0;i<2*N;i++)
				for(int j=0;j<2*N;j++){
					boolean ws=true,ws1=false;
					for(int h=0;h<2;h++)
						for(int k=0;k<2;k++){
							ws&=d(c,i+h,j+k);
							ws1|=d(c,i+h,j+k);
						}
					if(ws)a++;
					else if(ws1)b++;
				}
			sb.append("In the case n = "+N+", "+b+" cells contain segments of the circle.\n");
			sb.append("There are "+a+" cells completely contained in the circle.\n");
		}
		System.out.print(new String(sb));
	}
}
