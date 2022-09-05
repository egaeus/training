package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 821
 * @problemName Page Hopping
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 17/01/2013
 **/
import static java.lang.Math.min;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;
public class UVa821{
	static void init(int[][] mAdy) {
		for(int i=0;i<mAdy.length;i++){
			Arrays.fill(mAdy[i],10000);
			mAdy[i][i]=0;
		}
	}
	static void floydWarshall(int[][] mAdy){
		for(int k=0;k<mAdy.length;k++)
			for(int i=0;i<mAdy.length;i++)
				for(int j=0;j<mAdy.length;j++)
					mAdy[i][j]=min(mAdy[i][j],mAdy[i][k]+mAdy[k][j]);
	}
	public static void main(String args[]) throws Throwable{
		Scanner sc=new Scanner(System.in);
		boolean ws=false;
		int[][] mAdy=new int[101][101];
		TreeSet<Integer> nodos=new TreeSet<Integer>();
		init(mAdy);
		int caso=1;
		for(;;){
			int desde=sc.nextInt(),hasta=sc.nextInt();
			if(desde==0&&hasta==0){
				if(!ws)break;
				double sum=0;
				floydWarshall(mAdy);
				for(int i=0;i<mAdy.length;i++)
					for(int j=0;j<mAdy.length;j++)
						if(mAdy[i][j]<10000)
							sum+=mAdy[i][j];
				System.out.printf(Locale.US,"Case %d: average length between pages = %.3f clicks\n",caso++,sum/(nodos.size()*(nodos.size()-1)));
				init(mAdy);
				nodos.clear();
				ws=false;
			}
			else {
				ws=true;
				mAdy[desde][hasta]=min(1,mAdy[desde][hasta]);
				nodos.add(desde);
				nodos.add(hasta);
			}
		}
	}
}
