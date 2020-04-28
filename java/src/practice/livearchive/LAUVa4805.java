package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 4805
 * @problemName Ants Colony
 * @judge http://livearchive.onlinejudge.org/
 * @category LCA
 * @level medium
 * @date 08/02/2013
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class LAUVa4805{
	static class LCA {
		private int[] padreDirecto,altura,seccion,padreSeccion;
		private long[] costo;
		private int N;
		public LCA(ArrayList<int[]> lAdy[],int root) {
			int h=0;
			N=lAdy.length;
			padreDirecto=new int[N];
			altura=new int[N];
			seccion=new int[N];
			padreSeccion=new int[N];
			costo=new long[N];
			padreDirecto[root]=-1;
			boolean[] visitados=new boolean[N];
			LinkedList<Integer> pila=new LinkedList<Integer>();
			pila.add(root);
			visitados[root]=true;
			for(int p;!pila.isEmpty();) {
				p=pila.pollLast();
				for(int q[]:lAdy[p]) 
					if(!visitados[q[0]]){
						padreDirecto[q[0]]=p;
						altura[q[0]]=altura[p]+1;
						costo[q[0]]=costo[p]+q[1];
						pila.add(q[0]);
						h=max(h,altura[q[0]]);
						visitados[q[0]]=true;
					}
			}
			h=(int)sqrt(h+1);
			Arrays.fill(visitados,false);
			pila.clear();
			pila.add(root);
			visitados[root]=true;
			seccion[root]=0;
			padreSeccion[root]=-1;
			for(int p;!pila.isEmpty();) {
				p=pila.pollLast();
				for(int q[]:lAdy[p]) 
					if(!visitados[q[0]]){
						if(altura[q[0]]%h==0){
							padreSeccion[q[0]]=padreDirecto[q[0]];
							seccion[q[0]]=altura[q[0]]/h;
						}
						else {
							padreSeccion[q[0]]=padreSeccion[padreDirecto[q[0]]];
							seccion[q[0]]=seccion[padreDirecto[q[0]]];
						}						
						pila.add(q[0]);
						visitados[q[0]]=true;
					}
			}
		}
		public int lca(int a,int b){
			for(;padreSeccion[a]!=padreSeccion[b];) {
				if(seccion[a]>seccion[b]) 
					a=padreSeccion[a];
				else if(seccion[a]<seccion[b])
					b=padreSeccion[b];
				else {
					a=padreSeccion[a];
					b=padreSeccion[b];
				}
			}
			return lcaSeccion(a,b);
		}
		private int lcaSeccion(int a,int b) {
			for(;a!=b;) {
				if(altura[a]>altura[b])
					a=padreDirecto[a];
				else if(altura[a]<altura[b])
					b=padreDirecto[b];
				else {
					a=padreDirecto[a];
					b=padreDirecto[b];
				}
			}
			return a;
		}
		public long distancia(int a,int b) {
			int n=lca(a,b);
			return costo[a]+costo[b]-2*(costo[n]);
		}
		public int getNodo(int desde,int pasos) {
			if(desde==-1)return -1;
			if(pasos<=altura[desde]-(padreSeccion[desde]==-1?-1:altura[padreSeccion[desde]]))return getNodoSeccion(desde,pasos);
			return getNodo(padreSeccion[desde],pasos-altura[desde]+(padreSeccion[desde]==-1?-1:altura[padreSeccion[desde]]));
		}
		private int getNodoSeccion(int desde,int pasos) {
			if(pasos==0||desde==-1)return desde;
			return getNodoSeccion(padreDirecto[desde],pasos-1);
		}
	}
	static class Escaner {
		BufferedReader in;
		StringTokenizer st;
		Escaner(){
			in=new BufferedReader(new InputStreamReader(System.in));
			st=new StringTokenizer("");
		}
		int nextInt()throws Throwable{
			if(st.hasMoreTokens())return parseInt(st.nextToken());
			st=new StringTokenizer(in.readLine());
			return nextInt();
		}
	}
	public static void main(String args[]) throws Throwable{
		Escaner sc=new Escaner();
		StringBuilder sb=new StringBuilder();
		for(int N,H=0;(N=sc.nextInt())!=0;H++){
			ArrayList<int[]> lAdy[]=new ArrayList[N];
			for(int i=0;i<N;i++)lAdy[i]=new ArrayList<int[]>();
			for(int i=0;i<N-1;i++){
				int desde=sc.nextInt(),costo=sc.nextInt();
				lAdy[i+1].add(new int[]{desde,costo});
				lAdy[desde].add(new int[]{i+1,costo});
			}
			LCA lca=new LCA(lAdy,0);
			int L=sc.nextInt();
			for(int i=0;i<L;i++) {
				if(i>0)sb.append(" ");
				sb.append(lca.distancia(sc.nextInt(),sc.nextInt()));
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
