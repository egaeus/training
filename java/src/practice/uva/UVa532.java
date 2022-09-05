package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 532
 * @problemName Dungeon Master
 * @judge http://uva.onlinejudge.org/
 * @category floodfill
 * @level easy
 * @date 10/01/2012
 **/
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class UVa532 {
	static char[][][] mat;
	static boolean[][][] vis;
	static int[] t;
	static int f(int x,int y,int z){
		LinkedList<int[]> cola=new LinkedList<int[]>();
		cola.add(new int[]{x,y,z,0});vis[x][y][z]=true;
		for(int[] u;!cola.isEmpty();){
			u=cola.pollFirst();
			if(mat[u[0]][u[1]][u[2]]=='E')return u[3];
			for(int i=0;i<3;i++)
				for(int h=-1;h<2;h+=2)
					if(u[i]+h>=0&&u[i]+h<t[i]){
						u[i]+=h;
						if(!vis[u[0]][u[1]][u[2]]&&mat[u[0]][u[1]][u[2]]!='#'){
							cola.add(new int[]{u[0],u[1],u[2],u[3]+1});
							vis[u[0]][u[1]][u[2]]=true;
						}
						u[i]-=h;
					}
		}
		return MIN_VALUE;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;) {
			int L=parseInt(st.nextToken()),R=parseInt(st.nextToken()),C=parseInt(st.nextToken());
			if(L==0&&R==0&&C==0)break;
			t=new int[]{L,R,C};
			mat=new char[L][R][];
			vis=new boolean[L][R][C];
			for(int i=0;i<L;i++){
				for(int j=0;j<R;j++)mat[i][j]=in.readLine().trim().toCharArray();
				in.readLine();
			}
			int x=0,y=0,z=0,s;
			loop:for(;x<L;x++)for(y=0;y<R;y++)for(z=0;z<C;z++)if(mat[x][y][z]=='S')break loop;
			System.out.println((s=f(x,y,z))==MIN_VALUE?"Trapped!":"Escaped in "+s+" minute(s).");
		}
	}
}
