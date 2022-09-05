package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2618
 * @problemName Supermarket
 * @judge http://livearchive.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 11/08/2011
 **/
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class LAUVa2618 {
	static double mem[][],arr[][],list[];
	static double function(int i,int j){
		if(i>=list.length)return 0;
		if(j>=arr.length)return POSITIVE_INFINITY;
		if(mem[i][j]!=0)return mem[i][j];
		if(arr[j][0]==list[i])return mem[i][j]=Math.min(function(i+1,j+1)+arr[j][1],function(i,j+1));
		return mem[i][j]=function(i,j+1);
	}
	static double function(){
		for(int i=0;i<mem.length-1;i++)mem[i][mem[0].length-1]=POSITIVE_INFINITY;
		for(int i=mem.length-2;i>=0;i--)
			for(int j=mem[0].length-2;j>=0;j--)
				if(arr[j][0]==list[i])mem[i][j]=Math.min(mem[i+1][j+1]+arr[j][1],mem[i][j+1]);
				else mem[i][j]=mem[i][j+1];
		return mem[0][0];
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());
			if(N==0&&M==0)break;
			list=new double[N];arr=new double[M][];
			st=new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++)list[i]=parseInt(st.nextToken());
			for(int i=0;i<M;i++){
				st=new StringTokenizer(in.readLine());
				arr[i]=new double[]{parseInt(st.nextToken()),parseDouble(st.nextToken())};
			}
			mem=new double[N+1][M+1];double res=function();
			if(res==POSITIVE_INFINITY)System.out.printf("Impossible\n");
			else System.out.printf(Locale.US,"%.2f%n",res);
		}
	}
}
