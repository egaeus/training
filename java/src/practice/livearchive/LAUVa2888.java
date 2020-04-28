package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2888
 * @problemName Child Play
 * @judge http://livearchive.onlinejudge.org/
 * @category dp
 * @level medium
 * @date 29/08/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class LAUVa2888 {
	static int[][] arr;
	static byte[][] mem,memp;
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			arr=new int[N][];int sum=0,max=0;
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				arr[i]=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken())};
				max+=abs(arr[i][0]-arr[i][1]);
				sum+=arr[i][0]+arr[i][1];
			}
			Arrays.sort(arr,new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[0]+o1[1]!=o2[0]+o2[1]?o1[0]+o1[1]-o2[0]-o2[1]:(min(o1[0],o1[1])-min(o2[0],o2[1]));
				}
			});
			mem=new byte[N+1][max+1];
			mem[0][0]=1;
			for(int i=0;i<N;i++)
				for(int j=0;j<=max;j++)
					if(mem[i][j]==1)mem[i+1][j+abs(arr[i][0]-arr[i][1])]=mem[i+1][abs(j-abs(arr[i][0]-arr[i][1]))]=1;
			if(mem[N][0]==1)System.out.println(sum/2+" discard none");
			else {
				memp=new byte[N+1][max+1];
				memp[N][0]=1;
				for(int i=N;i>0;i--)
					for(int j=0;j<=max;j++)
						if(memp[i][j]==1)
							memp[i-1][j+abs(arr[i-1][0]-arr[i-1][1])]=
								memp[i-1][abs(j-abs(arr[i-1][0]-arr[i-1][1]))]=1;
				int v=-1,min=MAX_VALUE;
				for(int i=0;i<N;i++)
					for(int j=0;j<=max;j++)
						if(mem[i][j]==1&&memp[i+1][j]==1&&min>arr[i][0]+arr[i][1]){
							min=arr[i][0]+arr[i][1];
							v=i;
						}
				if(v>-1)System.out.println((sum-min)/2+" discard "+min(arr[v][0],arr[v][1])+" "+max(arr[v][0],arr[v][1]));
				else System.out.println("impossible");
			}
		}
	}
}
