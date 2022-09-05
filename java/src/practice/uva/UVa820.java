package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 820
 * @problemName Internet Bandwidth
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date Nov 5, 2013
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.round;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
public class UVa820 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int N,caso=1;(N=parseInt(in.readLine().trim()))!=0;caso++) {
			double[][] c=new double[N][N];
			StringTokenizer st=new StringTokenizer(in.readLine());
			int S=parseInt(st.nextToken())-1,T=parseInt(st.nextToken())-1,C=parseInt(st.nextToken());
			for(int i=0;i<C;i++) {
				st=new StringTokenizer(in.readLine());
				int desde=parseInt(st.nextToken())-1,hasta=parseInt(st.nextToken())-1, cap=parseInt(st.nextToken());
				c[desde][hasta]+=cap;
				c[hasta][desde]+=cap;
			}
			sb.append("Network ").append(caso).append("\n");
			sb.append("The bandwidth is ").append((int)round(edmondsKarp(c, S, T))).append(".\n\n");
		}
		System.out.print(new String(sb));
	}

	static double edmondsKarp(double[][] capacity, int v1, int v2) {
		int n = capacity.length, lAdy[][] = new int[n][], ants[] = new int[n], queue[] = new int[n], v, u;
		double f = 0d, m, flow[][] = new double[n][n], minCap[] = new double[n];
		List h[] = new List[n];
		for (u = 0; u < n; u++)
			h[u] = new ArrayList<Integer>();
		for (u = 0; u < n; u++)
			for (v = 0; v < n; v++)
				if (capacity[u][v] > 1e-10) {
					h[u].add(v);
					h[v].add(u);
				}
		for (u = 0; u < n; u++)
			lAdy[u] = toArr(h[u]);
		for (; (m = bfsEK(capacity, flow, lAdy, ants, minCap, queue, v1, v2)) > 1e-10; f += m)
			for (v = v2, u = ants[v]; v != v1; v = u, u = ants[v]) {
				flow[u][v] += m;
				flow[v][u] -= m;
			}
		return f;
	}

	static double bfsEK(double[][] capacity, double[][] flow, int[][] lAdy,
			int[] ants, double[] minCap, int[] queue, int v1, int v2) {
		int i, t = 0, u;
		double z;
		Arrays.fill(ants, -1);
		ants[v1] = -2;
		minCap[v1] = Double.POSITIVE_INFINITY;
		for (queue[t++] = v1, i = 0; i < t; i++)
			for (int v : lAdy[u = queue[i]])
				if ((z = capacity[u][v] - flow[u][v]) > 1e-10 && ants[v] == -1) {
					ants[v] = u;
					minCap[v] = Math.min(minCap[u], z);
					if (v == v2)
						return minCap[v2];
					queue[t++] = v;
				}
		return 0d;
	}

	static int[] toArr(List<Integer> p) {
		int r[] = new int[p.size()], i = 0;
		for (int x : p)
			r[i++] = x;
		return r;
	}
}
