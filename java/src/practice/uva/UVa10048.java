package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10048
 * @problemName Audiophobia
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 30/04/2012
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa10048 {
	static void floydWarshall(int[][] mAdy,int N){
		for(int k=0;k<N;k++)
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					mAdy[i][j]=min(mAdy[i][j],max(mAdy[i][k],mAdy[k][j]));
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();int caso=1;
		for (StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;caso++) {
			int C=parseInt(st.nextToken()),S=parseInt(st.nextToken()),Q=parseInt(st.nextToken());
			if(C==0&&S==0&&Q==0)break;
			if(caso>1)sb.append("\n");
			int[][] mAdy=new int[C][C];
			for(int i=0;i<C;i++){
				Arrays.fill(mAdy[i],MAX_VALUE);
				mAdy[i][i]=0;
			}
			for(int i=0;i<S;i++){
				st=new StringTokenizer(in.readLine());
				int d=parseInt(st.nextToken())-1,h=parseInt(st.nextToken())-1,c=parseInt(st.nextToken());
				mAdy[d][h]=mAdy[h][d]=min(mAdy[h][d],c);
			}
			floydWarshall(mAdy,C);
			sb.append("Case #"+caso+"\n");
			for(int i=0;i<Q;i++){
				st=new StringTokenizer(in.readLine());
				int d=parseInt(st.nextToken())-1,h=parseInt(st.nextToken())-1;
				sb.append((mAdy[d][h]==MAX_VALUE?"no path":mAdy[d][h])+"\n");
			}
		}
		System.out.print(new String(sb));
	}
}
