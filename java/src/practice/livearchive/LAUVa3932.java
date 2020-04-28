package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3932
 * @problemName Finding Seats
 * @judge http://livearchive.onlinejudge.org/
 * @category search
 * @level easy
 * @date 27/10/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa3932 {
	static int f(int a, int b, int c, int d){
		return mat[c][d]-(a>0?mat[a-1][d]:0)-(b>0?mat[c][b-1]:0)+(a>0&&b>0?mat[a-1][b-1]:0);
	}
	static int min(int a, int b, int c, int d){
		if(d==mat[0].length)return MAX_VALUE;
		if(c<0)return MAX_VALUE;
		if(f(a,b,c,d)>=R)return Math.min((c-a+1)*(d-b+1),min(a,b,c-1,d));
		return min(a,b,c,d+1);
	}
	static int[][] mat;static int R;
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());R=parseInt(st.nextToken());
			if(N==0&&M==0&&R==0)break;
			mat=new int[N][M];
			for(int i=0;i<N;i++){
				char[] ln=in.readLine().trim().toCharArray();
				for(int j=0;j<M;j++)mat[i][j]=ln[j]=='.'?1:0;
			}
			for(int i=1;i<N;i++)mat[i][0]+=mat[i-1][0];
			for(int i=1;i<M;i++)mat[0][i]+=mat[0][i-1];
			for(int i=1;i<N;i++)
				for(int j=1;j<M;j++)
					mat[i][j]+=mat[i-1][j]+mat[i][j-1]-mat[i-1][j-1];
			int res=MAX_VALUE;
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					res=Math.min(res,min(i,j,N-1,j));
			System.out.println(res);
		}
	}
}
