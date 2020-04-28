package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3156
 * @problemName Zing Zhu's Oyster Farm
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 31/08/2011
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa3156 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int[][] mat=new int[2006][2006];int[] v=new int[]{-1,1};int[] cola=new int[2006*2006];int c,r;
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			int minX=2006,minY=2006,maxX=-2006,maxY=-2006;
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				int X1=parseInt(st.nextToken()),Y1=parseInt(st.nextToken()),X2=parseInt(st.nextToken()),
				Y2=parseInt(st.nextToken()),H=parseInt(st.nextToken());
				minX=min(minX,2*min(X1,X2)+1000);
				minY=min(minY,2*min(Y1,Y2)+1000);
				maxX=max(maxX,2*max(X1,X2)+1005);
				maxY=max(maxY,2*max(Y1,Y2)+1005);
				for(int j=2*min(X1,X2)+1002;j<=2*max(X1,X2)+1002;j++)for(int h=2*min(Y1,Y2)+1002;h<=2*max(Y1,Y2)+1002;h++)
					mat[j][h]=max(mat[j][h],H);
			}
			int H=parseInt(in.readLine().trim());
			cola[0]=(minY<<11)|(minX);c=0;r=0;
			mat[minX][minY]=-1;
			int[] u=new int[2];
			for(;c<=r;c++){
				int U=cola[c];
				u[0]=U&((1<<11)-1);
				u[1]=U>>11;
				for(int i=0;i<v.length;i++){
					if(u[0]+v[i]>=minX&&u[0]+v[i]<=maxX&&mat[u[0]+v[i]][u[1]]>=0&&mat[u[0]+v[i]][u[1]]<H){
						mat[u[0]+v[i]][u[1]]=-1;
						cola[++r]=(u[1]<<11)|(u[0]+v[i]);
					}
					if(u[1]+v[i]>=minY&&u[1]+v[i]<=maxY&&mat[u[0]][u[1]+v[i]]>=0&&mat[u[0]][u[1]+v[i]]<H){
						mat[u[0]][u[1]+v[i]]=-1;
						cola[++r]=(((u[1]+v[i])<<11)|u[0]);
					}
				}
			}
			double res=0;
			for(int i=minX%2==0?minX+1:minX;i<=maxX;i+=2)
				for(int j=minY%2==0?minY+1:minY;j<=maxY;j+=2)
					if(mat[i][j]==0)res++;
			System.out.println((int)res);
			for(int i=0;i<mat.length;i++)for(int j=0;j<mat.length;j++)mat[i][j]=0;
		}
	}
}
