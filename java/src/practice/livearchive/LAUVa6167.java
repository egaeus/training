package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict T.L.E.
 * @problemId 6167
 * @problemName Fridge Lock
 * @judge http://livearchive.onlinejudge.org/
 * @category dp
 * @level medium
 * @date Jul 22, 2013
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
public class LAUVa6167 {
	static int[][] opciones,ecuaciones;
	static boolean[][][] mem;
	static boolean[][] dp;
	static int ecuacion;
	static TreeSet<Long> f() {
		for(int i=0;i<opciones.length;i++)
			for(int j=0;j<200001;j++) {
				for(int k=0;k<opciones[i].length;k++)
					mem[i+1][j][k]=false;
				dp[i+1][j]=false;
				memVuelta[i+1][j]=null;
			}
		dp[0][100000]=true;
		int min=100000,max=100000;
		for(int i=0;i<opciones.length;i++) {
			int minTmp=min,maxTmp=max;
			for(int k=min;k<=max;k++) {
				if(dp[i][k])
					for(int j=0;j<opciones[i].length;j++) {
						mem[i+1][k+ecuaciones[ecuacion][i]*opciones[i][j]][j]=true;
						dp[i+1][k+ecuaciones[ecuacion][i]*opciones[i][j]]=true;
						minTmp=min(minTmp,k+ecuaciones[ecuacion][i]*opciones[i][j]);
						maxTmp=max(maxTmp,k+ecuaciones[ecuacion][i]*opciones[i][j]);
					}
			}
			min=minTmp;
			max=maxTmp;
		}
		return devuelta(opciones.length, 100000+ecuaciones[ecuacion][ecuaciones[ecuacion].length-1]);
	}
	static TreeSet<Long> memVuelta[][];
	static TreeSet<Long> devuelta(int p,int v) {
		TreeSet<Long> sol=new TreeSet<Long>();
		if(p==0){
			sol.add(0L);
			return sol;
		}
		if(memVuelta[p][v]!=null)return memVuelta[p][v];
		for(int u=0;u<opciones[p-1].length;u++){
			if(mem[p][v][u]) {
				TreeSet<Long> c=devuelta(p-1, v-ecuaciones[ecuacion][p-1]*opciones[p-1][u]);
				for(long d:c) 
					sol.add(d|(((long)u)<<(6*(p-1))));
			}
		}
		return memVuelta[p][v]=sol;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		mem=new boolean[11][200001][50];
		dp=new boolean[11][200001];
		memVuelta=new TreeSet[11][200001];
		for (int N;(N=parseInt(in.readLine().trim()))!=0;) {
			opciones=new int[N][];
			for(int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(in.readLine());
				TreeSet<Integer> arr=new TreeSet<Integer>();
				for(;st.hasMoreTokens();)arr.add(parseInt(st.nextToken()));
				int k=0;
				opciones[i]=new int[arr.size()];
				for(int a:arr)
					opciones[i][k++]=a;
			}
			ecuaciones=new int[N][N+1];
			for(int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(in.readLine().replace("=", " "));
				for(int k=0;k<=N;k++)
					ecuaciones[i][k]=parseInt(st.nextToken());
			}
			TreeMap<Long,Integer> s=new TreeMap<Long, Integer>();
			for(int i=0;i<N;i++) {
				ecuacion=i;
				TreeSet<Long> f=f();
				for(Long a:f) {
					Integer p=s.get(a);
					if(p==null)p=0;
					p++;
					s.put(a, p);
				}
			}
			for(Entry<Long, Integer> entry:s.entrySet()) 
				if(entry.getValue()==N) {
					int[] sol=new int[N];
					long v=entry.getKey();
					for(int i=0;i<N;i++,v=v>>6)
						sol[i]=(int)(v%(1<<6));
					for(int i=0;i<N;i++) 
						sb.append(i>0?" ":"").append(opciones[i][sol[i]]);
					break;
				}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
