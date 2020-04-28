package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 108
 * @problemName Maximum Sum
 * @judge http://uva.onlinejudge.org/
 * @category Math
 * @level easy
 * @date June 6, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa108 {
	static long maxSumSubMat(long[][] nums) {
		int N=nums.length,M=nums[0].length;
		long[][] creciente=new long[N+2][M+2];
		long[][] decreciente=new long[N+2][M+2];
		long[][] mins=new long[N+2][M+2];
		long[][] maxs=new long[N+2][M+2];
		long sum=0;
		for(int i=0;i<N+2;i++){
			creciente[i][M+1]=Long.MAX_VALUE;
			decreciente[i][0]=Long.MAX_VALUE;
			maxs[i][M+1]=Long.MIN_VALUE;
		}
		for(int i=0;i<M+2;i++) {
			creciente[N+1][i]=Long.MAX_VALUE;
			decreciente[0][i]=Long.MAX_VALUE;
			maxs[N+1][i]=Long.MIN_VALUE;
		}
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++) {
				sum+=nums[i][j];
				creciente[i+1][j+1]=creciente[i][j+1]+creciente[i+1][j]-creciente[i][j]+nums[i][j];
				decreciente[N-i][M-j]=decreciente[N-i+1][M-j]+decreciente[N-i][M-j+1]-decreciente[N-i+1][M-j+1]+nums[N-1-i][M-j-1];
				mins[N-i][M-j]=Math.min(Math.min(mins[N-i][M-j+1],mins[N-i+1][M-j]),decreciente[N-i][M-j]);
				maxs[N-i][M-j]=Math.max(Math.max(maxs[N-i][M-j+1],maxs[N-i+1][M-j]),decreciente[N-i][M-j]);
			}
		long max=Long.MIN_VALUE;
		for(long m[]:creciente)System.out.println(Arrays.toString(m));
		System.out.println("-------");
		for(long m[]:decreciente)System.out.println(Arrays.toString(m));
		System.out.println("-------");
		for(long m[]:mins)System.out.println(Arrays.toString(m));
		System.out.println("-------");
		for(long m[]:maxs)System.out.println(Arrays.toString(m));
		System.out.println("-------");
		System.out.println(sum);
		for(int i=0;i<N+1;i++)
			for(int j=0;j<M+1;j++) {
				if(i==0&&j==3){
					System.out.println("  ---- "+(sum-(mins[i][j+1]+mins[i+1][j]-maxs[i+1][j+1])-creciente[i][M]-creciente[N][j]+creciente[i][j]));
					System.out.println("----->"+mins[i][j+1]+" "+mins[i+1][j]+" "+maxs[i+1][j+1]+" "+creciente[i][M]+" "+creciente[N][j]+" "+creciente[i][j]);
				}
				max=Math.max(max,sum-(mins[i][j+1]+mins[i+1][j]-maxs[i+1][j+1])-creciente[i][M]-creciente[N][j]+creciente[i][j]);
			}
		return max;
	}
	static class Escaner {
		BufferedReader in;
		StringTokenizer st;
		public Escaner() {
			 in = new BufferedReader(new InputStreamReader(System.in));
			 st=new StringTokenizer("");
		}
		public int nextInt() throws Throwable {
			if(st.hasMoreTokens())return parseInt(st.nextToken());
			st=new StringTokenizer(in.readLine());
			return nextInt();
		}
	}
	public static void main(String[] args) throws Throwable {
		Escaner sc=new Escaner();
		int n = sc.nextInt();
		long[][] arr = new long[n][n];
		for(int i=0;i<n*n;i++)
			arr[i/n][i%n]=sc.nextInt();
		System.out.println(maxSumSubMat(arr));
	}
}
