package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId NWERC10G
 * @problemName Selling Land
 * @judge http://www.spoj.pl
 * @category dp
 * @level medium
 * @date 24/03/2011
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SPOJNWERC10G {
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int c = 0, C = parseInt(in.readLine().trim()); c++<C; ){
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
			char[][] matriz = new char[N][];
			for(int i = 0; i < N; i++)
				matriz[i] = in.readLine().trim().toCharArray();
			int[][] alturas = new int[N][M];
			for(int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					if(matriz[i][j]!='#')
						if(i==0||matriz[i-1][j]=='#')alturas[i][j]=1;
						else alturas[i][j]=alturas[i-1][j]+1;
			int[][] anchuras = new int[N][M];
			for(int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					if(matriz[i][j]!='#')
						if(j==0||matriz[i][j-1]=='#')anchuras[i][j]=1;
						else anchuras[i][j]=anchuras[i][j-1]+1;
			int[] res = new int[4001];
			for(int i = 0; i < N; i++){
				int max = 0, minW = 1002;
				for(int j = 0; j < M; j++){
					max = j>0&&alturas[i][j-1]>0&&alturas[i][j]>=alturas[i][j-1]?max+2:0;
					minW = j>0&&alturas[i][j-1]>0&&alturas[i][j]>=alturas[i][j-1]?minW+1:1002;
					for(int h = j>0&&alturas[i][j-1]>0&&alturas[i][j]>=alturas[i][j-1]?alturas[i][j-1]+1:1; h <= alturas[i][j]; h++){
						minW = min(minW, anchuras[i-h+1][j]);
						max = max(max, 2*minW+2*h);
					}
					res[max]++;
				}
			}
			for(int i = 1; i < res.length; i++)
				if(res[i]>0)
					sb.append(res[i] + " x " + i + "\n");
		}
		System.out.print(new String(sb));
	}
}
