package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 5741
 * @problemName Wealthy Family
 * @judge http://livearchive.onlinejudge.org/
 * @category dp
 * @level medium
 * @date Aug 26, 2013
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class LAUVa5741 {
	static int[] costo=new int[150000];
	static ArrayList<Integer>[] lAdy=new ArrayList[150000];
	static int[] posicion=new int[150000];
	static int[] nodo=new int[150000];
	static int[] proxPosicion=new int[150000];
	static int[] pila=new int[150000];
	static int[][] mem=new int[2][150001];
	static int[] padre=new int[150000];
	static int N;
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<lAdy.length;i++)lAdy[i]=new ArrayList<Integer>();
		for (String ln;(ln=in.readLine())!=null;) {
			StringTokenizer st=new StringTokenizer(ln);
			N=parseInt(st.nextToken());
			int K=parseInt(st.nextToken());
			for(int i=0;i<N;i++)lAdy[i].clear();
			int root=0;
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(in.readLine());
				int desde=parseInt(st.nextToken())-1;
				if(desde==-1)root=i;
				else lAdy[desde].add(i);
				costo[i]=parseInt(st.nextToken());
				padre[i]=desde;
			}
			int c=0,p=0;
			pila[c++]=root;
			for(int u;c>0;) {
				u=pila[c-1];
				nodo[p]=u;
				posicion[u]=p++;
				proxPosicion[u]=posicion[u];
				c--;
				for(int v:lAdy[u]) 
					pila[c++]=v;
			}
			for(int i=p-1;i>=1;i--)
				proxPosicion[padre[nodo[i]]]=max(proxPosicion[padre[nodo[i]]],proxPosicion[nodo[i]]);
			int s=f(K);
			System.out.println(s<0?"impossible":s);
		}
		System.out.print(new String(sb));
	}
	static int f(int K) {
		for(int i=0;i<=N;i++)
			mem[0][i]=0;
		mem[1][N]=-1500000001;
		for(int k=1;k<=K;k++) {
			for(int p=N-1;p>=0;p--) {
				int u=nodo[p];
				mem[1][p]=max(mem[1][p+1],mem[0][proxPosicion[u]+1]+costo[u]);
			}
			for(int i=0;i<=N;i++)
				mem[0][i]=mem[1][i];
		}
		int sol=-1;
		for(int j=0;j<=N;j++) 
			sol=max(sol,mem[1][j]);
		return sol;
	}
}
