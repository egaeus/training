package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2165
 * @problemName Bomb the bridge
 * @judge http://livearchive.onlinejudge.org/
 * @category geom, graph
 * @level medium
 * @date 08/08/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.ceil;
import static java.lang.Math.min;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class LAUVa2165 {
	static double distancia(int[] c1,int[] c2){
		double dist=sqrt((c1[0]-c2[0])*(c1[0]-c2[0])+(c1[1]-c2[1])*(c1[1]-c2[1]));
		if(dist<=c1[2]+c2[2])return 0;
		return dist-c1[2]-c2[2];
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int c=0,C=parseInt(in.readLine().trim());c++<C;){
			StringTokenizer st=new StringTokenizer(in.readLine());
			int W=parseInt(st.nextToken()),L=parseInt(st.nextToken()),B=parseInt(st.nextToken());
			double[][] mAdyGrafo=new double[B+2][B+2];lAdyGrafoConexos=new TreeSet[B+2];
			int[][] bombas=new int[B][];
			for(int i=0;i<B+2;i++){
				if(i<B){
					st=new StringTokenizer(in.readLine());
					bombas[i]=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken())};
				}
				lAdyGrafoConexos[i]=new TreeSet<Integer>();
			}
			for(int i=0;i<B+2;i++)
				for(int j=i+1;j<B+2;j++){
					double dist;
					if(i==0)if(j==B+1)dist=W;else dist=max(0,bombas[j-1][0]-bombas[j-1][2]);
					else if(j==B+1)dist=max(0,W-(bombas[i-1][0]+bombas[i-1][2]));
					else dist=distancia(bombas[i-1], bombas[j-1]);
					if(abs(dist)<=1e-10){
						lAdyGrafoConexos[i].add(j);
						lAdyGrafoConexos[j].add(i);
					}
					mAdyGrafo[i][j]=mAdyGrafo[j][i]=dist;
				}
			ArrayList<TreeSet<Integer>> componentes=componentesConexas();
			/*for(TreeSet<Integer> m:componentesConexas())System.out.println(m);
			for(double[] m:mAdyGrafo)System.out.println(Arrays.toString(m));*/
			if(componentes.size()==1)System.out.println("Bridge already split");
			else {
				int inicio=0,fin=componentes.size()-1;
				for(int i=0;i<componentes.size();i++){
					if(componentes.get(i).contains(0))inicio=i;
					if(componentes.get(i).contains(B+1))fin=i;
				}
				if(inicio==fin)System.out.println("Bridge already split");
				else{
					double min=MAX_VALUE;
					for(int i:componentes.get(inicio))
						for(int j:componentes.get(fin))
							min=min(min,mAdyGrafo[i][j]);
					System.out.println((int)ceil(min/2));
				}
			}
		}
	}
	static TreeSet<Integer>[] lAdyGrafoConexos;
	static ArrayList<TreeSet<Integer>> componentesConexas(){
		ArrayList<TreeSet<Integer>> res=new ArrayList<TreeSet<Integer>>();int n;
		boolean visitados[]=new boolean[n=lAdyGrafoConexos.length];
		for(int i=0;i<n;i++)
			if(!visitados[i]){
				visitados[i]=true;
				TreeSet<Integer> nuevo=new TreeSet<Integer>();
				nuevo.add(i);
				componentesConexas(visitados, i, nuevo);
				res.add(nuevo);
			}
		return res;
	}
	static void componentesConexas(boolean[] visitados, int v, TreeSet<Integer> vis){
		for(int p:lAdyGrafoConexos[v])
			if(!visitados[p]){vis.add(p);visitados[p]=true;componentesConexas(visitados,p,vis);}
	}
}
