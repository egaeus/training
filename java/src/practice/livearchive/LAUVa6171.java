package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 6171
 * @problemName Slithering Serpent
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level medium
 * @date Jul 23, 2013
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class LAUVa6171 {
	static int[][] jug=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
	static ArrayList<Integer> getPosicion(int[] inicio,int cantInicio,long jugado,int cantJug) {
		boolean[][] tab=new boolean[100][100];
		int x=50,y=50;
		tab[x][y]=true;
		for(int i=0;i<cantInicio;i++) {
			int p=inicio[i];
			x+=jug[p][0];
			y+=jug[p][1];
			tab[x][y]=true;
		}
		for(int i=0;i<cantJug;i++) {
			int p=abs((int)(jugado&((1<<2)-1)));;
			jugado=jugado>>>2;
			x+=jug[p][0];
			y+=jug[p][1];
			tab[x][y]=true;
		}
		ArrayList<Integer> sol=new ArrayList<Integer>();
		for(int i=0;i<jug.length;i++) {
			if(x+jug[i][0]<0||x+jug[i][0]>=tab.length||y+jug[i][1]<0||y+jug[i][1]>=tab.length)
				return new ArrayList<Integer>();
			if(!tab[x+jug[i][0]][y+jug[i][1]])
				sol.add(i);
		}
		return sol;
	}
	static boolean esPosible(int inicio[],int cantInicio,long jugado,int cantJug) {
		boolean[][] tab=new boolean[100][100];
		int x=50,y=50;
		tab[x][y]=true;
		for(int i=0;i<cantInicio;i++) {
			int p=inicio[i];
			x+=jug[p][0];
			y+=jug[p][1];
			tab[x][y]=true;
		}
		for(int i=0;i<cantJug;i++) {
			int p=abs((int)(jugado&((1<<2)-1)));
			jugado=jugado>>>2;
			x+=jug[p][0];
			y+=jug[p][1];
			tab[x][y]=true;
		}
		int c=0,p=0;
		cola1[c][0]=x;
		cola1[c++][1]=y;
		for(;p<c;){
			x=cola1[p][0];
			y=cola1[p++][1];
			for(int i=0;i<jug.length;i++) {
				if(x+jug[i][0]<0||x+jug[i][0]>=tab.length||y+jug[i][1]<0||y+jug[i][1]>=tab.length)
					return true;
				if(!tab[x+jug[i][0]][y+jug[i][1]]) {
					cola1[c][0]=x+jug[i][0];
					cola1[c++][1]=y+jug[i][1];
					tab[x+jug[i][0]][y+jug[i][1]]=true;
				}
			}
		}
		return false;
	}
	static long[][] cola=new long[1000000][2];
	static int[][] cola1=new int[1000000][2];
	static int f(int inicio[],int cantInicio) {
		int c=0,p=0;
		cola[c][0]=0;
		cola[c++][1]=0;
		for(;p<c;) {
			long[] u=cola[p++];
			if(!esPosible(inicio, cantInicio, u[0], (int)u[1]))return (int)u[1];
			ArrayList<Integer> s=getPosicion(inicio, cantInicio, u[0], (int)u[1]);
			for(int v:s) {
				cola[c][0]=u[0]|(v<<(2*u[1]));
				cola[c++][1]=u[1]+1;
			}
		}
		return -1;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String pos="NSEW";
		int[] inicio=new int[37];
		for (int N;(N=parseInt(in.readLine().trim()))!=0;) {
			int cantInicio=0;
			String ln=in.readLine().trim().replaceAll("[^1234567890NSEW]", "");
			for(int i=0;i<N;i++) {
				int p1=ln.indexOf("N"),p2=ln.indexOf("S"),p3=ln.indexOf("W"),p4=ln.indexOf("E");
				p1=p1==-1?MAX_VALUE:p1;
				p2=p2==-1?MAX_VALUE:p2;
				p3=p3==-1?MAX_VALUE:p3;
				p4=p4==-1?MAX_VALUE:p4;
				int c=parseInt(ln.substring(0, min(min(p1,p2),min(p3,p4))));
				int a=pos.indexOf(ln.charAt(min(min(p1,p2),min(p3,p4))));
				for(int k=0;k<c;k++) 
					inicio[cantInicio++]=a;
				ln=ln.substring(min(min(p1,p2),min(p3,p4))+1);
			}
			System.out.println(f(inicio, cantInicio));
		}
		System.out.print(new String(sb));
	}
}
