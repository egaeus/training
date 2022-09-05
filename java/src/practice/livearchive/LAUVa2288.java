package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2288
 * @problemName To The Max
 * @judge http://livearchive.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 18/11/2011
 **/
import java.util.Scanner;
public class LAUVa2288 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[][] arr=new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				arr[i][j]=sc.nextInt();
		for(int i=1;i<N;i++){arr[i][0]+=arr[i-1][0];arr[0][i]+=arr[0][i-1];}
		for(int i=1;i<N;i++)
			for(int j=1;j<N;j++)
				arr[i][j]+=arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				for(int k=i;k<N;k++)
					for(int h=j;h<N;h++)
						max=Math.max(max,arr[k][h]-(i>0?arr[i-1][h]:0)-(j>0?arr[k][j-1]:0)+(i>0&&j>0?arr[i-1][j-1]:0));
		System.out.println(max);
	}
}
