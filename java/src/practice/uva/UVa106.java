package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 106
 * @problemName Fermat vs. Pythagoras
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level medium
 * @date 29/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
class UVa106 {
	static int mcd(int a,int b){
		if(b==0)return a;
		return mcd(b,a%b);
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int MAX=202861,MAXT=1980642,ppt[][]=new int[MAX][],count[]=new int[MAXT];
		long[] triplas=new long[MAXT];
		for(int m=1,c=0,x=0;m<=1000;m++)
			for(int n=1;n<m;n++){
				if((m-n)%2==1&&mcd(m,n)==1){
					ppt[c++]=new int[]{m*m-n*n,2*m*n,m*m+n*n};
					for(int i=1;i*(m*m+n*n)<=1000000;i++){
						long A=i*(m*m-n*n),B=i*2*m*n,C=i*(m*m+n*n);
						if(A*A+B*B==C*C)triplas[x++]=(C<<40)|(B<<20)|A;
					}
				}
			}
		Comparator<int[]> comp;
		Arrays.sort(ppt,comp=new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[2]!=o2[2])return o1[2]-o2[2];
				if(o1[1]!=o2[1])return o1[1]-o2[1];
				return o1[0]-o2[0];
			}
		});
		Arrays.sort(triplas);
		boolean[] p=new boolean[1000001];
		for(int i=0,c=0;i<MAXT;i++){
			long N=triplas[i];
			if(!p[(int)(N%(1<<20))]){c++;p[(int)(N%(1<<20))]=true;}
			N=N>>20;
			if(!p[(int)(N%(1<<20))]){c++;p[(int)(N%(1<<20))]=true;}
			N=N>>20;
			if(!p[(int)N]){c++;p[(int)N]=true;}
			count[i]=c;
		}
		for (String ln;(ln=in.readLine())!=null;) {
			long N=parseInt(ln.trim());
			int bs=Arrays.binarySearch(ppt,new int[]{(int)N,(int)N,(int)N},comp),bs1=Arrays.binarySearch(triplas,(N<<40)|(N<<20)|N);
			System.out.println((-bs-1)+" "+(N-(bs1==-1?0:count[-bs1-2])));
		}
	}
}
