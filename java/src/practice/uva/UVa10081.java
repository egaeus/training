package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10081
 * @problemName Tight Words
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 12/02/2013
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa10081 {
	static double[][][][] mem;
	static double[] f(int p,int ant,boolean ws){
		if(p==N)return new double[]{1.0,ws?1.0:0.0};
		if(mem[p][ant+1][ws?1:0]!=null)return mem[p][ant+1][ws?1:0]; 
		double a=0,b=0;
		for(int i=0;i<=K;i++) {
			double[] s=f(p+1,i,ws&&(ant==-1||abs(ant-i)<=1));
			a+=s[0];
			b+=s[1];
		}
		return mem[p][ant+1][ws?1:0]=new double[]{a,b};
	}
	static int K,N;
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(String ln;(ln=in.readLine())!=null;){
			StringTokenizer st=new StringTokenizer(ln);
			K=parseInt(st.nextToken());
			N=parseInt(st.nextToken());
			mem=new double[N][K+2][2][];
			double[] s=f(0,-1,true);
			System.out.printf(Locale.US,"%.5f\n",(1.*s[1]/s[0])*100);
		}
	}
}
