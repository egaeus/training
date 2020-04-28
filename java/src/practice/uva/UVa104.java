package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 104
 * @problemName Arbitrage
 * @judge http://uva.onlinejudge.org/
 * @category graph,dp
 * @level medium
 * @date 2/01/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class UVa104 {
	static double[][] mAdy;
	static LinkedList<Integer> f(int N){
		double[][][] mem=new double[N][N][N+1];
		int[][][] camino=new int[N][N][N+1];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++){
				mem[i][j][0]=mAdy[i][j];
				for(int c=0;c<=N;c++)
					camino[i][j][c]=-1;
			}
		for(int c=0;c<N;c++)
			for(int k=0;k<N;k++)
				for(int i=0;i<N;i++)
					for(int j=0;j<N;j++)
						/*if(i!=k&&j!=k)*/{
							double v=mem[i][k][c]*mAdy[k][j];
							if(mem[i][j][c+1]<v){
								mem[i][j][c+1]=v;
								camino[i][j][c+1]=k;
							}
						}
		boolean ws=false;
		int c=0,i=0;
		for(c=0;c<N&&!ws;c++)
			for(i=0;i<N&&!ws;i++)
				ws=mem[i][i][c]>1.01;
		if(!ws)return null;
		c--;i--;
		LinkedList<Integer> res=new LinkedList<Integer>();
		for(int j=i;c>=0;c--){
			res.addFirst(j+1);
			j=camino[i][j][c];
		}
		res.addFirst(i+1);
		return res;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for (String ln;(ln=in.readLine())!=null;) {
			int N=parseInt(ln.trim());
			mAdy=new double[N][N];
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++)
					if(i==j)mAdy[i][j]=1;
					else mAdy[i][j]=Double.parseDouble(st.nextToken());
			}
			LinkedList<Integer> r=f(N);
			if(r==null)sb.append("no arbitrage sequence exists");
			else {
				int c=0;
				for(int a:r)sb.append((c++>0?" ":"")+a);
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
