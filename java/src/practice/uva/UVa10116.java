package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10116
 * @problemName Robot Motion
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 17/6/2015
 **/
import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;
public class UVa10116 {
	public static void main(String args[]) throws Throwable {
		TreeMap<Character, int[]> move=new TreeMap<Character, int[]>();
		move.put('N', new int[]{-1,0});
		move.put('S', new int[]{1,0});
		move.put('E', new int[]{0,1});
		move.put('W', new int[]{0,-1});
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String ln;(ln=in.readLine())!=null;) {
			StringTokenizer st=new StringTokenizer(ln);
			int R=parseInt(st.nextToken()), C=parseInt(st.nextToken()), I=parseInt(st.nextToken())-1;
			if(R==0&&C==0&&I==-1)
				break;
			char[][] mat=new char[R][];
			for(int i=0;i<R;i++)
				mat[i]=in.readLine().trim().toCharArray();
			int[][] vis=new int[R][C];
			LinkedList<int[]> queue=new LinkedList<int[]>();
			vis[0][I]=1;
			queue.add(new int[]{0,I});
			for(boolean ws=true;!queue.isEmpty()&&ws;) {
				int[] u=queue.pollFirst();
				int[] m=move.get(mat[u[0]][u[1]]);
				u[0]+=m[0];
				u[1]+=m[1];
				if(u[0]<0||u[0]>=R||u[1]<0||u[1]>=C) {
					ws=false;
					sb.append(vis[u[0]-m[0]][u[1]-m[1]]).append(" step(s) to exit\n");
				}
				else if(vis[u[0]][u[1]]>0) {
					ws=false;
					sb.append(vis[u[0]][u[1]]-1).append(" step(s) before a loop of ").append(vis[u[0]-m[0]][u[1]-m[1]]-vis[u[0]][u[1]]+1).append(" step(s)\n");
				} else {
					vis[u[0]][u[1]]=vis[u[0]-m[0]][u[1]-m[1]]+1;
					queue.add(new int[]{u[0],u[1]});
				}
			}
		}
		System.out.print(new String(sb));
	}
}
