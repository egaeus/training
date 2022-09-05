package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10207
 * @problemName The Unreal Tournament
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 19/04/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa10207{
	static BigInteger[][] memB;
	static double[][] memA;
	static void f(int MAX){
		memB=new BigInteger[MAX][MAX];
		memA=new double[MAX][MAX];
		for(int i=0;i<MAX;i++){
			memB[i][0]=BigInteger.ZERO;
			memB[0][i]=BigInteger.ZERO;
		}
		for(int i=1;i<MAX;i++)
			for(int j=1;j<MAX;j++)
				memB[i][j]=memB[i-1][j].add(memB[i][j-1]).add(BigInteger.valueOf(2));
	}
	static void f(double p,double q,int MAX){
		for(int i=0;i<MAX;i++){
			memA[i][0]=0;
			memA[0][i]=1;
		}
		memA[0][0]=-1;
		for(int i=1;i<MAX;i++)
			for(int j=1;j<MAX;j++)
				memA[i][j]=p*memA[i-1][j]+q*memA[i][j-1];
	}
	public static void main(String args[]) throws Throwable{
		int MAX=1001;
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();f(MAX);int caso=0;
		NumberFormat nf=NumberFormat.getInstance(Locale.US);
		nf.setMaximumFractionDigits(5);
		nf.setMinimumFractionDigits(5);
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;caso++){
			double p=Double.parseDouble(st.nextToken());
			int N=parseInt(st.nextToken());
			if(N==0)break;
			if(caso>0)sb.append("\n");
			f(p,1-p,MAX);
			for(int i=0;i<N;i++){
				st=new StringTokenizer(in.readLine());
				int I=parseInt(st.nextToken()),J=parseInt(st.nextToken());
				sb.append(nf.format(memA[I][J])+"\n");
				sb.append(memB[I][J]+"\n");
			}
		}
		System.out.print(new String(sb));
	}
}
