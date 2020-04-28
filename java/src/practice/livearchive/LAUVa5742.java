package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict W.A.
 * @problemId 5742
 * @problemName Supply Mission
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level medium
 * @date Aug 22, 2013
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.ceil;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa5742 {
	public static double f() {
		double x=a[0],y=a[1],z=b[0],w=b[1],p=va[0],q=va[1],r1,r2,t1,t2;
		double H=q*x-y*p-q*z+w*p,I=y-w,J=x-z,A=J*J+I*I,B=2*I*H,C=H*H-J*J*V*V;
		r1=(-B+sqrt(B*B-4*A*C))/(2*A);
		r2=(-B-sqrt(B*B-4*A*C))/(2*A);
		t1=(x-z)/(r1-p);
		t2=(x-z)/(r2-p);
		double t=max(t1,t2);
		return Double.isNaN(t)?Double.POSITIVE_INFINITY:t;
	}
	static double[] a=new double[2];
	static double[] va=new double[2];
	static double[] b=new double[2];
	static double V;
	public static double dist(double xa,double ya,double xb,double yb) {
		return sqrt((xa-xb)*(xa-xb)+(ya-yb)*(ya-yb));
	}
	public static double getTime(int[] ord) {
		double sol=0;
		double[] pos=new double[]{base[0],base[1]};
		V=base[2];
		for(int i=0;i<ord.length;i++) {
			int j=ord[i];
			a[0]=subs[j][0]+subs[j][2]*sol;
			a[1]=subs[j][1]+subs[j][3]*sol;
			va[0]=subs[j][2];
			va[1]=subs[j][3];
			b=pos;
			double t=f();
			sol+=t+1;
			pos[0]=subs[j][0]+subs[j][2]*sol;
			pos[1]=subs[j][1]+subs[j][3]*sol;
		}
		return sol+dist(base[0],base[1],pos[0],pos[1])/V;
	}
	static double min;
	static double[] base;
	static double[][] subs;
	public static void getTime(int a,int[] ord,int c) {
		if((1<<ord.length)-1==a) {
			min=min(min,getTime(ord));
		}
		for(int i=0;i<ord.length;i++)
			if((a&(1<<i))==0) {
				ord[c]=i;
				getTime(a|(1<<i),ord,c+1);
			}
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int N,c=1;(N=parseInt(in.readLine().trim()))!=0;c++) {
			subs=new double[N][];
			min=Double.POSITIVE_INFINITY;
			for(int i=0;i<subs.length;i++) {
				StringTokenizer st=new StringTokenizer(in.readLine());
				subs[i]=new double[]{parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken())};
			}
			StringTokenizer st=new StringTokenizer(in.readLine());
			base=new double[]{parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken())};
			getTime(0, new int[N], 0);
			long val=(long)ceil(min*60*60);
			sb.append("Case ").append(c).append(": ").append(val/(60*60)).append(" hour(s) ").append((val%(60*60))/60).append(" minute(s) ").append(val%60).append(" second(s)\n");
		}
		System.out.print(new String(sb));
	}
}
