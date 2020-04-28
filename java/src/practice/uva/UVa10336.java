package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10336
 * @problemName Rank the Languages
 * @judge http://uva.onlinejudge.org/
 * @category flood fill
 * @level easy
 * @date 30/03/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class UVa10336{
	static TreeSet<int[]> f(int H,int W,char[][] world){
		int[] s=new int[26];
		for(int i=0;i<H;i++)
			for(int j=0;j<W;j++)
				if(world[i][j]!='\0'){
					s[world[i][j]-'a']++;
					f(H,W,world[i][j],world,i,j);
				}
		TreeSet<int[]> sol=new TreeSet<int[]>(new Comparator<int[]>(){
			public int compare(int[] o1,int[] o2){
				return o1[1]!=o2[1]?o2[1]-o1[1]:o1[0]-o2[0];
			}
		});
		for(int i=0;i<26;i++)if(s[i]>0)sol.add(new int[]{i,s[i]});
		return sol;
	}
	static int[][] v=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
	static void f(int H,int W,char ch,char[][] world,int I,int J){
		LinkedList<int[]> cola=new LinkedList<int[]>();
		cola.add(new int[]{I,J});world[I][J]='\0';
		for(int[] u;!cola.isEmpty();){
			u=cola.pollFirst();
			for(int i=0;i<v.length;i++)
				if(u[0]+v[i][0]>=0&&u[0]+v[i][0]<H&&u[1]+v[i][1]>=0&&u[1]+v[i][1]<W&&world[u[0]+v[i][0]][u[1]+v[i][1]]==ch){
					cola.add(new int[]{u[0]+v[i][0],u[1]+v[i][1]});world[u[0]+v[i][0]][u[1]+v[i][1]]='\0';
				}
		}
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int t=0,T=parseInt(in.readLine().trim());t++<T;){
			StringTokenizer st=new StringTokenizer(in.readLine());
			int H=parseInt(st.nextToken()),W=parseInt(st.nextToken());
			char[][] world=new char[H][];
			for(int i=0;i<H;i++)world[i]=in.readLine().trim().toCharArray();
			TreeSet<int[]> s=f(H,W,world);
			sb.append("World #"+t+"\n");
			for(int[] p:s)sb.append((char)(p[0]+'a')+": "+p[1]+"\n");
		}
		System.out.print(new String(sb));
	}
}
