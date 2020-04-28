package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2612
 * @problemName This Sentence is False
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 16/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class LAUVa2612 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			TreeSet<Integer>[] lAdy=new TreeSet[2*N];
			for(int i=0;i<2*N;i++)lAdy[i]=new TreeSet<Integer>();
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				st.nextToken();int s=parseInt(st.nextToken())-1;
				st.nextToken();char t=st.nextToken().charAt(0);
				lAdy[i].add(t=='t'?s:(N+s));
				lAdy[t=='t'?s:(N+s)].add(i);
				lAdy[i+N].add(t=='t'?(N+s):s);
				lAdy[t=='t'?(N+s):s].add(i+N);
			}
			ArrayList<TreeSet<Integer>> res=componentesConexas(lAdy);
			boolean ws=true;int cont=0;
			for(int i=0;i<res.size()&&ws;i++){
				int neg=0,noNeg=0;
				for(int h:res.get(i)){
					neg+=h>=N?1:0;
					noNeg+=h<N?1:0;
					if(res.get(i).contains(h+N)){ws=false;break;}
				}
				cont+=Math.max(neg, noNeg);
			}
			if(ws)System.out.println(cont/2);
			else System.out.println("Inconsistent");
		}
	}
	static ArrayList<TreeSet<Integer>> componentesConexas(TreeSet<Integer>[] lAdy){
		ArrayList<TreeSet<Integer>> res=new ArrayList<TreeSet<Integer>>();int n;
		boolean[] visitados=new boolean[n=lAdy.length];
		for(int i=0;i<n;i++)if(!visitados[i])res.add(componenteConexa(lAdy, i, visitados));
		return res;
	}
	static TreeSet<Integer> componenteConexa(TreeSet<Integer>[] lAdy, int v, boolean visitados[]){
		TreeSet<Integer> res=new TreeSet<Integer>();
		LinkedList<Integer> cola=new LinkedList<Integer>();
		res.add(v);visitados[v]=true;cola.add(v);
		for(;!cola.isEmpty();){
			int u=cola.pollFirst();
			for(int h:lAdy[u])
				if(!visitados[h]){cola.add(h);visitados[h]=true;res.add(h);}
		}
		return res;
	}
}
