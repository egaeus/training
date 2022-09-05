package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2617
 * @problemName Noise Effect
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 11/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;
public class LAUVa2617 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			int[][] arr=new int[N][N];
			int[][] arr1=new int[N][N];
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++)arr[i][j]=parseInt(st.nextToken());
			}
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++)arr1[i][j]=parseInt(st.nextToken());
			}
			int res[]=new int[8];
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++){
					res[0]+=Math.abs(arr[i][j]-arr1[i][j])<=100?1:0;
					res[1]+=Math.abs(arr[i][j]-arr1[j][N-i-1])<=100?1:0;
					res[2]+=Math.abs(arr[i][j]-arr1[N-i-1][N-j-1])<=100?1:0;
					res[3]+=Math.abs(arr[i][j]-arr1[N-j-1][i])<=100?1:0;
					res[4]+=Math.abs(arr[i][j]-arr1[j][i])<=100?1:0;
					res[5]+=Math.abs(arr[i][j]-arr1[N-i-1][j])<=100?1:0;
					res[6]+=Math.abs(arr[i][j]-arr1[N-j-1][N-i-1])<=100?1:0;
					res[7]+=Math.abs(arr[i][j]-arr1[i][N-j-1])<=100?1:0;
				}
			Arrays.sort(res);
			System.out.printf(Locale.US,"%.2f%n",(res[7]*100.0)/(N*N));
		}
	}
}
