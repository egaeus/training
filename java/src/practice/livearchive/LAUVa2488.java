package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2488
 * @problemName Maze Madness
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 07/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class LAUVa2488 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));int c=1;
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int M=parseInt(st.nextToken()),N=parseInt(st.nextToken());
			if(M==0&&N==0)break;
			char[][] tab=new char[2*N+1][];
			boolean[][] vis=new boolean[2*N+1][2*M+1];
			int I=-1,J=-1;
			for(int i=0;i<2*N+1;i++){
				tab[i]=in.readLine().trim().toCharArray();
				for(int j=0;j<2*M+1;j++)if(tab[i][j]=='s'){I=i;J=j;}
			}
			LinkedList<int[]> cola=new LinkedList<int[]>();
			cola.add(new int[]{I,J,0});int s=-1;
			int[][] v=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
			for(;!cola.isEmpty();){
				int[] u=cola.pollFirst();
				if(u[0]<0||u[0]>=tab.length||u[1]<0||u[1]>=tab[u[0]].length){s=u[2];break;}
				for(int i=u[0],j=u[1],h=0;h<4;h++)
					if(tab[i+v[h][0]][j+v[h][1]]!='-'&&tab[i+v[h][0]][j+v[h][1]]!='|'&&tab[i+v[h][0]][j+v[h][1]]!='+'&&
							(i+2*v[h][0]<0||j+2*v[h][1]<0||i+2*v[h][0]>=tab.length||j+2*v[h][1]>=tab[i].length||!vis[i+2*v[h][0]][j+2*v[h][1]])){
						if(!(i+2*v[h][0]<0||j+2*v[h][1]<0||i+2*v[h][0]>=tab.length||j+2*v[h][1]>=tab[i].length))
							vis[i+2*v[h][0]][j+2*v[h][1]]=true;
						cola.add(new int[]{i+2*v[h][0],j+2*v[h][1],u[2]+1});
					}
			}
			System.out.println("Maze "+c+++": "+(s==-1?"No escape!":s));
		}
	}
}
