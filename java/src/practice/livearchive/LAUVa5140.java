package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 5140
 * @problemName Squares
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 10/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa5140 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();int caso=0;
		for(String ln;(ln=in.readLine())!=null;caso++){
			int N=parseInt(ln.trim());
			int[][] derecha=new int[N][N];
			int[][] abajo=new int[N][N];
			int M=parseInt(in.readLine().trim());
			for(int i=0;i<M;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				char F=st.nextToken().charAt(0);
				if(F=='H')derecha[parseInt(st.nextToken())-1][parseInt(st.nextToken())-1]=1;
				else {
					int j=parseInt(st.nextToken())-1;
					abajo[parseInt(st.nextToken())-1][j]=1;
				}
			}
			int[] sol=new int[N];			
			for(int i=0;i<N;i++)for(int j=1;j<N;j++)derecha[i][j]+=derecha[i][j-1];
			for(int j=0;j<N;j++)for(int i=1;i<N;i++)abajo[i][j]+=abajo[i-1][j];
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					for(int k=1;k<Math.min(N-i,N-j);k++){
						int sumArriba=derecha[i][j+k-1]-(j>0?derecha[i][j-1]:0),
						sumAbajo=derecha[i+k][j+k-1]-(j>0?derecha[i+k][j-1]:0),
						sumIzquierda=abajo[i+k-1][j]-(i>0?abajo[i-1][j]:0),
						sumDerecha=abajo[i+k-1][j+k]-(i>0?abajo[i-1][j+k]:0);
						if(sumArriba==k&&sumAbajo==k&&sumDerecha==k&&sumIzquierda==k)sol[k]++;
					}
			if(caso>0)sb.append("\n**********************************\n\n");
			sb.append("Problem #"+(caso+1)+"\n\n");
			boolean ws=false;
			for(int i=1;i<N;i++)
				if(sol[i]>0){
					ws=true;
					sb.append(sol[i]+" square (s) of size "+i+"\n");
				}
			if(!ws)sb.append("No completed squares can be found.\n");
		}
		System.out.print(new String(sb));
	}
}
