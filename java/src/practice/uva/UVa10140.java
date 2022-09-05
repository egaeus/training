package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10140
 * @problemName Prime Distance
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 07/06/2012
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;
import static java.lang.Math.ceil;
import static java.lang.Math.max;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa10140{
	static boolean[] cribaSegmentada(long L,long U){
		boolean[] res=new boolean[(int)(U-L+1)];
		for(long i=L;i<2;i++)res[(int)(i-L)]=true;
		for(int i=0;i<=sqrt(U);i++)
			if(!p[i])
				for(long h=i*max((long)ceil(1.*L/i),2);h<=U;h+=i)
					res[(int)(h-L)]=true;
		return res;
	}
	static boolean p[];
	public static void main(String args[]) throws Throwable{
		p=new boolean[(int)sqrt(MAX_VALUE)+2];
		p[0]=p[1]=true;
		for(int i=0;i<p.length;i++)
			if(!p[i]) 
				for(int j=2*i;j<p.length;j+=i)
					p[j]=true;
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;){
			StringTokenizer st=new StringTokenizer(ln);
			long L=parseInt(st.nextToken()),U=parseInt(st.nextToken()),min=MAX_VALUE,max=0,rMin[]=null,rMax[]=null,ant;
			boolean[] criba=cribaSegmentada(L,U);
			for(ant=L;ant<=U;ant++)if(!criba[(int)(ant-L)])break;
			for(long i=ant+1;i<=U;i++){
				if(!criba[(int)(i-L)]){
					if(i-ant>max){
						max=i-ant;
						if(rMax==null) rMax=new long[2];
						rMax[0]=ant;
						rMax[1]=i;
					}
					if(i-ant<min){
						min=i-ant;
						if(rMin==null) rMin=new long[2];
						rMin[0]=ant;
						rMin[1]=i;
					}
					ant=i;
				}
			}
			sb.append(rMin==null?"There are no adjacent primes.\n":(rMin[0]+","+rMin[1]+" are closest, "+rMax[0]+","+rMax[1]+" are most distant.\n"));
		}
		System.out.print(new String(sb));
	}
}
