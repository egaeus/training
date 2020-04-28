package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2616
 * @problemName I hate SPAM, but some people love it
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 11/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class LAUVa2616 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			TreeSet<Integer> set[]=new TreeSet[N];
			for(int i=0;i<N;i++){
				set[i]=new TreeSet<Integer>();
				for(StringTokenizer st=new StringTokenizer(in.readLine());st.hasMoreTokens();){
					int v=parseInt(st.nextToken());
					if(v==0)break;
					if(v-1!=i)set[i].add(v-1);
				}
			}
			ArrayList<boolean[]> vis=new ArrayList<boolean[]>();
			ArrayList<Object[]> t=new ArrayList<Object[]>();
			for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
				int M=parseInt(st.nextToken());if(M==0)break;
				vis.add(getVisitados(M-1,set));
				t.add(new Object[]{parseInt(st.nextToken()),parseInt(st.nextToken()),st.nextToken(),st.nextToken(),st.nextToken()});
			}
			for(int i=0;i<N;i++){
				sb.append(in.readLine()+": ");
				for(int j=0;j<vis.size();j++)
					sb.append((vis.get(j)[i]?(set[i].size()<(Integer)t.get(j)[0]?t.get(j)[2]:(set[i].size()<(Integer)t.get(j)[1]?t.get(j)[3]:t.get(j)[4])):t.get(j)[2])+" ");
				sb.append("\n");
			}
		}
		System.out.print(new String(sb));
	}
	static boolean[] getVisitados(int v, TreeSet<Integer>[] r){
		LinkedList<Integer> cola=new LinkedList<Integer>();
		boolean[] vis=new boolean[r.length];
		cola.add(v);vis[v]=true;
		for(;!cola.isEmpty();cola.pollFirst())
			for(int u:r[cola.getFirst()])if(!vis[u]){vis[u]=true;cola.add(u);}
		return vis;
	}
}
