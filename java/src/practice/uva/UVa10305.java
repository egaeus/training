package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10305
 * @problemName Ordering Tasks
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level easy
 * @date 28/12/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class UVa10305 {
	static List<Integer> sortTopologico(TreeSet<Integer>[] lAdy){
		LinkedList<Integer> res=new LinkedList<Integer>();
		boolean[] vis=new boolean[lAdy.length];
		for(int i=0;i<lAdy.length;i++)if(!vis[i])sortTopologico(lAdy,res,i,vis);
		return res;
	}
	static void sortTopologico(TreeSet<Integer>[] lAdy,List<Integer> res,int v,boolean[] vis){
		vis[v]=true;
		for(int u:lAdy[v])
			if(!vis[u])sortTopologico(lAdy,res,u,vis);
		res.add(0,v);
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;) {
			int A=parseInt(st.nextToken()),B=parseInt(st.nextToken());
			if(A==0&&B==0)break;
			TreeSet<Integer>[] lAdy=new TreeSet[A];
			for(int i=0;i<A;i++)lAdy[i]=new TreeSet<Integer>();
			for(int i=0;i<B;i++){
				st=new StringTokenizer(in.readLine());
				lAdy[parseInt(st.nextToken())-1].add(parseInt(st.nextToken())-1);
			}
			List<Integer> s=sortTopologico(lAdy);
			boolean ws=false;
			for(int a:s){System.out.print((ws?" ":"")+(a+1));ws=true;}
			System.out.println();
		}
	}
}
