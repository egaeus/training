package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 336
 * @problemName A Node Too Far
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 10/01/2012
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.min;

import java.util.Scanner;
import java.util.TreeMap;
public class UVa336 {
	static void f(int[][] mAdy){
		for(int k=0,n=mAdy.length;k<n;k++)
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(mAdy[i][k]!=MAX_VALUE&&mAdy[k][j]!=MAX_VALUE)
						mAdy[i][j]=min(mAdy[i][j],mAdy[i][k]+mAdy[k][j]);
	}
	public static void main(String args[]) throws Throwable {
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		for(int N,caso=1;(N=sc.nextInt())!=0;) {
			int[][] mAdy=new int[30][30];
			for(int i=0;i<30;i++){
				for(int j=0;j<30;j++)mAdy[i][j]=MAX_VALUE;
				mAdy[i][i]=0;
			}
			TreeMap<Integer,Integer> nodos=new TreeMap<Integer, Integer>();
			for(int i=0;i<N;i++){
				int d=sc.nextInt(),h=sc.nextInt(),D,H;
				if(nodos.containsKey(d))D=nodos.get(d);
				else{D=nodos.size();nodos.put(d,nodos.size());}
				if(nodos.containsKey(h))H=nodos.get(h);
				else{H=nodos.size();nodos.put(h,nodos.size());}
				if(D!=H)mAdy[D][H]=mAdy[H][D]=1;
			}
			f(mAdy);
			for(int d,h,D,c=0;;c=0){
				d=sc.nextInt();h=sc.nextInt();
				if(d==0&&h==0)break;
				if(nodos.containsKey(d))D=nodos.get(d);
				else{D=nodos.size();nodos.put(d,nodos.size());}
				for(int i=0;i<nodos.size();i++)if(mAdy[D][i]>h)c++;
				sb.append("Case "+caso+++": "+c+" nodes not reachable from node "+d+" with TTL = "+h+".\n");
			}
		}
		System.out.print(new String(sb));
	}
}
