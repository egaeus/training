package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3471
 * @problemName ICPC Strikes Again
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 14/09/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class LAUVa3471 {
	static int[] costosTarea;
	static TreeSet<Integer>[] lAdy;
	static TreeSet<Integer>[] trab;
	static void generarCostos(TreeSet<Integer> nodosInicio){
		boolean[] visitados=new boolean[lAdy.length];
		for(int i:nodosInicio)generarCostos(i,visitados);
	}
	static void generarCostos(int v, boolean[] visitados){
		if(visitados[v])return;
		visitados[v]=true;
		for(int u:lAdy[v]){
			generarCostos(u,visitados);
			costosTarea[v]+=costosTarea[u];
		}
		return ;
	}
	static int sueldo(int t){
		boolean[] v=new boolean[lAdy.length];
		for(int i=0;i<v.length;i++)
			if(!v[i]&&trab[i].contains(t))sueldo(i,v);
		int res=0;
		for(int i=0;i<v.length;i++)if(!v[i]&&trab[i].contains(t))res+=costosTarea[i];
		return res;
	}
	static void sueldo(int v, boolean[] vis){
		for(int u:lAdy[v])
			if(!vis[u]){
				vis[u]=true;
				sueldo(u, vis);
			}
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int T=parseInt(st.nextToken()),E=parseInt(st.nextToken());
			if(T==0&&E==0)break;
			sb.append("*****\n");
			costosTarea=new int[T];
			lAdy=new TreeSet[T];for(int i=0;i<T;i++)lAdy[i]=new TreeSet<Integer>();
			trab=new TreeSet[T];for(int i=0;i<T;i++)trab[i]=new TreeSet<Integer>();
			TreeSet<Integer> nodosInicio=new TreeSet<Integer>();
			for(int i=0;i<T;i++)nodosInicio.add(i);
			for(int i=0;i<T;i++){
				st=new StringTokenizer(in.readLine());
				costosTarea[i]=parseInt(st.nextToken());
				int ND=parseInt(st.nextToken()),NE=parseInt(st.nextToken());
				st=new StringTokenizer(in.readLine());
				for(int j=0;j<ND;j++)lAdy[i].add(parseInt(st.nextToken())-1);
				nodosInicio.removeAll(lAdy[i]);
				for(int j=0;j<NE;j++)trab[i].add(parseInt(st.nextToken())-1);
			}
			generarCostos(nodosInicio);
			for(int i=0;i<E;i++)
				sb.append((i+1)+" "+sueldo(i)+"\n");
		}
		System.out.print(new String(sb));
	}
}
