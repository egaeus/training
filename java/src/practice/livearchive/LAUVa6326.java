package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 6326
 * @problemName Contest Hall Preparation
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Sep 19, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa6326 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t=0,T=parseInt(in.readLine().trim());t++<T;) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());
			boolean[] teams=new boolean[101];
			int[][] hall=new int[N][M];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(in.readLine());
				for(int j=0;j<M;j++)
					hall[i][j]=parseInt(st.nextToken());
			}
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					if(hall[i][j]!=-1)
						for(int k=-1;k<2;k++)
							for(int h=-1;h<2;h++) 
								if((k!=0||h!=0)&&i+k>=0&&i+k<N&&j+h>=0&&j+h<M&&hall[i][j]==hall[i+k][j+h])
									teams[hall[i][j]]=true;
			int cont=0;
			for(int i=0;i<teams.length;i++)
				if(teams[i])
					cont++;
			sb.append(cont).append("\n");
		}
		System.out.print(new String(sb));
	}
}
