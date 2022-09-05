package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 280
 * @problemName Vertex
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 17/6/2015
 **/
import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;
public class UVa280 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int N;(N=parseInt(in.readLine().trim()))!=0;) {
			long[][] mem=new long[N][N];
			for(long[] m:mem)
				Arrays.fill(m, Integer.MAX_VALUE);
			for(;;) {
				StringTokenizer st=new StringTokenizer(in.readLine());
				int from=parseInt(st.nextToken());
				if(from==0)
					break;
				from--;
				for(int to;(to=parseInt(st.nextToken()))!=0;)
					mem[from][to-1]=1;
			}
			for(int k=0;k<N;k++)
				for(int i=0;i<N;i++)
					for(int j=0;j<N;j++)
						mem[i][j]=Math.min(mem[i][j], mem[i][k]+mem[k][j]);
			StringTokenizer st=new StringTokenizer(in.readLine());
			int M=parseInt(st.nextToken());
			for(int i=0;i<M;i++) {
				int node=parseInt(st.nextToken())-1;
				boolean first=true;
				int count=0;
				for(int j=0;j<N;j++)
					if(mem[node][j]>=Integer.MAX_VALUE) 
						count++;
				sb.append(count);
				for(int j=0;j<N;j++)
					if(mem[node][j]>=Integer.MAX_VALUE)
						sb.append(" ").append(j+1);
				sb.append("\n");
			}
		}
		System.out.print(new String(sb));
	}
}
