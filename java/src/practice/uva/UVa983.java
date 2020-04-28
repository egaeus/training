package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 983
 * @problemName Localized Summing for Blurring
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date Nov 6, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa983 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int caso=0;
		for (String ln;(ln=in.readLine())!=null;caso++) {
			if(caso>0) {
				ln=in.readLine();
				sb.append("\n");
			}
			StringTokenizer st=new StringTokenizer(ln);
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());
			long[][] mat=new long[N][N];
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					mat[i][j]=parseInt(in.readLine().trim());
			for(int i=1;i<N;i++) {
				mat[i][0]+=mat[i-1][0];
				mat[0][i]+=mat[0][i-1];
			}
			for(int i=1;i<N;i++)
				for(int j=1;j<N;j++)
					mat[i][j]+=mat[i-1][j]+mat[i][j-1]-mat[i-1][j-1];
			long sum=0,val;
			for(int i=0;i<N-M+1;i++)
				for(int j=0;j<N-M+1;j++) {
					sum+=(val=mat[i+M-1][j+M-1]-(i>0?mat[i-1][j+M-1]:0)-(j>0?mat[i+M-1][j-1]:0)+(i>0&&j>0?mat[i-1][j-1]:0));
					sb.append(val).append("\n");
				}
			sb.append(sum).append("\n");
		}
		System.out.print(new String(sb));
	}
}
