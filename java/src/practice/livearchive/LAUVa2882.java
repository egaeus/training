package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2882
 * @problemName  Secure Region
 * @judge http://livearchive.onlinejudge.org/
 * @category geom
 * @level medium
 * @date 25/08/2011
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class LAUVa2882 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int X1=parseInt(st.nextToken()),Y1=parseInt(st.nextToken()),X2=parseInt(st.nextToken()),Y2=parseInt(st.nextToken());
			if(X1==0&&X2==0&&Y1==0&&Y2==0)break;
			int N,arr[][]=new int[(N=parseInt(in.readLine().trim()))+2][],arr2[][]=new int[N+2][];
			for(int i=0;i<N;i++){
				st=new StringTokenizer(in.readLine());
				arr2[i]=arr[i]=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken())};
			}
			arr2[N]=arr[N]=new int[]{X1,Y1};
			arr2[N+1]=arr[N+1]=new int[]{X2,Y2};
			Arrays.sort(arr,new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {return o1[0]-o2[0];}
			});
			Arrays.sort(arr2,new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2){return o1[1]-o2[1];}
			});
			int[] pos=new int[N+2];
			for(int i=0;i<N+2;i++)
				pos[i]=Arrays.binarySearch(arr, arr2[i],new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {return o1[0]-o2[0];}
			});
			int sol[]=new int[2];
			for(int i=0;i<N+2;i++)
				for(int j=i+1;j<N+2;j++){
					int yAnt=Y1;
					for(int h=0,bs;h<N+2;h++){
						bs=pos[h];
						if(bs>i&&bs<j){
							int min=min(arr2[h][1]-yAnt,arr[j][0]-arr[i][0]),max=max(arr2[h][1]-yAnt,arr[j][0]-arr[i][0]);
							if(sol[0]<min||(sol[0]==min&&sol[1]<max)){sol[0]=min;sol[1]=max;}
							yAnt=arr2[h][1];
						}
					}
					int min=min(Y2-yAnt,arr[j][0]-arr[i][0]),max=max(Y2-yAnt,arr[j][0]-arr[i][0]);
					if(sol[0]<min||(sol[0]==min&&sol[1]<max)){sol[0]=min;sol[1]=max;}
				}
			System.out.println(sol[0]+" "+sol[1]);
		}
	}
}
