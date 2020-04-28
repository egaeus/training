package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3528
 * @problemName The Warehouse
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 07/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class LAUVa3528 {
	static class Nodo implements Comparable<Nodo>{
		int pI,pJ,c;
		byte[][] mat;
		Nodo(int pI, int pJ, byte[][] mat, int c){
			int n;this.mat=new byte[n=mat.length][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					this.mat[i][j]=mat[i][j];
			this.pI=pI;
			this.pJ=pJ;
			this.c=c;
		}
		ArrayList<Nodo> getMovimientos(){
			int d[][]=new int[][]{{0,1},{0,-1},{1,0},{-1,0}},m=4,n=mat.length;
			ArrayList<Nodo> res=new ArrayList<Nodo>();
			for(int i=0;i<m;i++)
				if(pI+d[i][0]>=0&&pI+d[i][0]<n&&pJ+d[i][1]>=0&&pJ+d[i][1]<n&&mat[pI+d[i][0]][pJ+d[i][1]]>0)
					res.add(new Nodo(pI+d[i][0],pJ+d[i][1],mat,c+1));
			if(mat[pI][pJ]>1)
				for(int i=0;i<m;i++)
					if(pI+mat[pI][pJ]*d[i][0]>=0&&pI+mat[pI][pJ]*d[i][0]<n&&pJ+mat[pI][pJ]*d[i][1]>=0&&pJ+mat[pI][pJ]*d[i][1]<n){
						boolean ws=true;
						for(int H=0,h=pI+d[i][0],k=pJ+d[i][1];H<mat[pI][pJ]&&ws;H++,h+=d[i][0],k+=d[i][1])
							ws=mat[h][k]==0;
						if(ws){
							Nodo N=new Nodo(pI+d[i][0],pJ+d[i][1], mat,c+1);
							N.mat[pI][pJ]=0;
							for(int H=0,h=pI+d[i][0],k=pJ+d[i][1];H<mat[pI][pJ]&&ws;H++,h+=d[i][0],k+=d[i][1])
								N.mat[h][k]=1;
							res.add(N);
						}
					}
			return res;
		}
		public int compareTo(Nodo o) {
			if(pI!=o.pI)return pI-o.pI;
			if(pJ!=o.pJ)return pJ-o.pJ;
			for(int i=0,n;i<(n=mat.length);i++)
				for(int j=0;j<n;j++)
					if(mat[i][j]!=o.mat[i][j])return mat[i][j]-o.mat[i][j];
			return 0;
		}
		
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),I=parseInt(st.nextToken())-1,J=parseInt(st.nextToken())-1,GI=-1,GJ=-1,s=-1;
			if(N==0&&I==-1&&J==-1)break;
			byte[][] mat=new byte[N][N];
			for(int i=0;i<N;i++){
				char[] ln=in.readLine().trim().toCharArray();
				for(int j=0;j<N;j++)
					if(ln[j]=='E'){GI=i;GJ=j;mat[i][j]=1;}
					else if(ln[j]!='.')mat[i][j]=(byte)(ln[j]-'0');
			}
			TreeSet<Nodo> mapa=new TreeSet<Nodo>();
			LinkedList<Nodo> cola=new LinkedList<Nodo>();
			mapa.add(new Nodo(I,J,mat,0));
			cola.add(new Nodo(I,J,mat,0));
			for(;!cola.isEmpty();){
				if(cola.getFirst().pI==GI&&cola.getFirst().pJ==GJ)break;
				Nodo n=cola.pollFirst();
				ArrayList<Nodo> mov=n.getMovimientos();
				for(Nodo u:mov)
					if(!mapa.contains(u)){
						mapa.add(u);
						cola.add(u);
					}
			}
			if(cola.isEmpty())System.out.println("Impossible.");
			else System.out.println(cola.getFirst().c);
		}
	}
}
