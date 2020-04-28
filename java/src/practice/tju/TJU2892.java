package practice.tju; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2892
 * @problemName Task
 * @judge http://acm.tju.edu.cn/
 * @category graph
 * @level easy
 * @date 31/07/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class TJU2892{
	static ArrayList<Integer> lAdy[];
	static boolean hayCiclo(int v,boolean[] vis,boolean[] vis1){
		if(vis[v])return true;
		vis[v]=vis1[v]=true;
		for(int a:lAdy[v])
			if(hayCiclo(a,vis,vis1))return true;
		vis[v]=false;
		return false;
	}
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int t=0,T=parseInt(in.readLine().trim());t++<T;){
			StringTokenizer st=new StringTokenizer(in.readLine());
			int n=parseInt(st.nextToken()),m=parseInt(st.nextToken());
			lAdy=new ArrayList[n];
			for(int i=0;i<n;i++)lAdy[i]=new ArrayList<Integer>();
			for(int i=0;i<m;i++){
				st=new StringTokenizer(in.readLine());
				lAdy[parseInt(st.nextToken())-1].add(parseInt(st.nextToken())-1);
			}
			boolean ws=false;
			boolean[] vis=new boolean[n];
			for(int i=0;i<n&&!ws;i++)
				if(!vis[i])ws=hayCiclo(i,new boolean[n],vis);
			System.out.println(ws?0:1);
		}
	}
}
