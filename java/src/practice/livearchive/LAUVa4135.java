package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict R.E.
 * @problemId 4135
 * @problemName Resistor
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level medium
 * @date 01/08/2012
 **/
import static java.lang.Integer.bitCount;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class LAUVa4135{
	static TreeSet<Double> f(int a,int b){
		if(sets[a][b].size()>0)return sets[a][b]; 
		TreeSet<Double> res=sets[a][b];
		if(b-a==1)res.add(arr[a]);
		else {
			for(int i=a+1;i<b;i++) {
				TreeSet<Double> A=f(a,i),B=f(i,b);
				for(double s:A)
					for(double d:B) {
						if(a==0&&b==arr.length)r=min(r,min(abs(h-s-d),abs(h-(s*d/(s+d)))));
						res.add(s+d);
						res.add(s*d/(s+d));
					}
			}
		}
		return sets[a][b];
	}
	static double a[],arr[],r,h;
	static double f(int n){
		if(n==(1<<a.length)-1)f(0,a.length);
		for(int i=0;i<a.length;i++)
			if(((1<<i)&n)==0){
				for(int j=0;j<=a.length;j++)for(int k=0;k<=a.length;k++)sets[j][k].clear();
				arr[bitCount(n)]=a[i];
				f((1<<i)|n);
			}
		return r;
	}
	static TreeSet<Double> sets[][];
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		sets=new TreeSet[8][8];
		for(int j=0;j<8;j++)for(int k=0;k<8;k++)sets[j][k]=new TreeSet<Double>();
		for(int t=0,T=parseInt(in.readLine());t++<T;){
			StringTokenizer st=new StringTokenizer(in.readLine());
			h=parseInt(st.nextToken());int N=parseInt(st.nextToken());
			arr=new double[N];a=new double[N];r=Double.POSITIVE_INFINITY;
			st=new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++)a[i]=parseInt(st.nextToken());
			//System.out.printf(Locale.US,"%.3f\n",f(0));
		}
	}
}
